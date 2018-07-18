package com.ubivelox.tlv.service;

import org.springframework.stereotype.Service;

import com.ubivelox.tlv.domain.TlvParseData;
import com.ubivelox.tlv.util.TlvUtil;

@Service
public class TlvParseService {

    public TlvParseData parseTlv(TlvParseData params) {
	System.out.println("TlvParseService");
	params.setResTlv(TlvUtil.parse(params.getReqTlv()));
	return params;
    }

}
