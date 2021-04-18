package com.example.uploadingfiles.web.linkage;

import com.example.uploadingfiles.web.linkage.vo.XmlVo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.net.URI;

public class XmlResponse {

    public Mono<XmlVo> findServiceCouponInfo() {
        Object body = XmlVo.class;
        //return sendMono(body,"https://gorest.co.in/public-api/users/123/posts.xml");
        return sendMono(body,"localhost:8090//response/xml");
    }

    private Mono sendMono(Object body, String url) {
        return WebClient.builder()
                .build()
                .get()
                .uri(URI.create(url))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .onStatus(HttpStatus::isError, response -> {
                    String.format("xmlSample onStatus");
                    return Mono.error(new IllegalStateException(
                            String.format("Failed! %s", "TEST")
                    ));
                })
                .bodyToMono((Class)body)
                .onErrorMap( e -> {
                    return e;
                }).retry(3);
    }
}
