package com.example.uploadingfiles;

import com.example.uploadingfiles.web.linkage.XmlResponse;
import com.example.uploadingfiles.web.linkage.vo.XmlVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class LinkageController {

    @GetMapping("/flux")
    public void sendFlux() {
        XmlResponse coopMktApi = new XmlResponse();
        Mono<XmlVo> subscript =  coopMktApi.findServiceCouponInfo();
        subscript.subscribe(
                x -> System.out.println("########## next: " + x.toString()),
                err -> err.printStackTrace());
        System.out.println("####완료");
    }
    @GetMapping("/response/xml")
    public String getXml() {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<COUPONINFO_OUT xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"http://gsapi.m2i.kr/\">" +
                //"<COUPONINFO_OUT>" +
                "  <RESULTCODE>00</RESULTCODE>" +
                "  <RESULTMSG>처리완료</RESULTMSG>" +
                //"  <COMP_NAME>60계치킨</COMP_NAME>" +
                //"  <COUPONNAME>양념치킨</COUPONNAME>" +
                "</COUPONINFO_OUT>";
        return xml;
    }
}
