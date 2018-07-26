package com.ubivelox.tlv.service;

import org.springframework.stereotype.Service;

import com.ubivelox.tlv.common.TlvUtil;
import com.ubivelox.tlv.domain.TlvParseData;

@Service
public class TlvParseService {

    public TlvParseData parseTlv(TlvParseData params) {
	System.out.println("TlvParseService");
	params.setResTlv(TlvUtil.parse(params.getReqTlv()));
	return params;
    }

}
