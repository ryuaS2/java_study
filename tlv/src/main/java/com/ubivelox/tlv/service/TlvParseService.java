package com.ubivelox.tlv.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ubivelox.tlv.common.ConstantCode;
import com.ubivelox.tlv.common.TlvUtil;
import com.ubivelox.tlv.common.ValidationUtil;
import com.ubivelox.tlv.domain.Tlv;
import com.ubivelox.tlv.domain.TlvParseData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TlvParseService {

    /**
     * <pre>
     * 1. Summary :
     * 2. Details :
     *
     * 3. LastModifiedDate :
     * 4. LastReviewedDate :
     * 5. History
     * 		2018. 8. 7. writing comments
     *
     * </pre>
     *
     * @param params
     * @return
     */
    public TlvParseData parseTlv(TlvParseData params) {
	log.info("TlvParseService");

	// 필수 값과 16진수 형식인지 체크
	if (ValidationUtil.isRequired(params.getReqTlv())) {
	    if (ValidationUtil.isHexaDec(params.getReqTlv())) {
		List<Tlv> resTlv = TlvUtil.parse(params.getReqTlv(), 0);

		// 파싱 성공 시 성공 응답 값 세팅
		if (null != resTlv && resTlv.size() > 0) {
		    params.setResTlv(resTlv);
		    params.setResCode(ConstantCode.RES_CODE.SUCCESS);
		    params.setResMsg(ConstantCode.RES_MSG.SUCCESS);
		}
	    } else {
		// 16진수 형식 오류
		params.setResCode(ConstantCode.RES_CODE.FORMAT_ERROR);
		params.setResMsg(ConstantCode.RES_MSG.FORMAT_ERROR);
	    }
	} else {
	    // 필수 값 오류
	    params.setResCode(ConstantCode.RES_CODE.REQUIRED_ERROR);
	    params.setResMsg(ConstantCode.RES_MSG.REQUIRED_ERROR);
	}
	return params;
    }

}
