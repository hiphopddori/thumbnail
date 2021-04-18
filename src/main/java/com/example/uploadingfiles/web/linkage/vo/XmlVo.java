package com.example.uploadingfiles.web.linkage.vo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// https://docs.oracle.com/javase/8/docs/api/javax/xml/bind/annotation/XmlRootElement.html
@ToString
@NoArgsConstructor
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="COUPONINFO_OUT", namespace = "http://gsapi.m2i.kr/")
public class XmlVo {
    @XmlElement(name = "RESULTCODE", namespace = "http://gsapi.m2i.kr/")
    String resultCode;
    @XmlElement(name = "RESULTMSG",  namespace = "http://gsapi.m2i.kr/")
    String resultMsg;

    @Override
    public String toString() {
        return "XmlVo{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }
}
