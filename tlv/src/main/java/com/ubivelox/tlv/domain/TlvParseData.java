package com.ubivelox.tlv.domain;

import java.util.List;

import lombok.Data;

@Data
public class TlvParseData {
    private String    reqTlv;	// 요청TLV 데이터
    private List<Tlv> resTlv;	// 응답 TLV
    private String    resCode;	// 응답 코드
    private String    errorMsg;	// 읍답 메시지
}
