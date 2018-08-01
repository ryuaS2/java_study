/*
 * Copyright Ubivelox
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Ubivelox.,LTD.
 */
package com.ubivelox.tlv.common;

/**
 *
 * @PackageName : com.ubivelox.tlv.common
 * @FileName : ConstantCode.java
 * @FileExplain :
 * @date : 2018. 7. 26. 오후 5:02:10
 * @version : 1.0
 * @author : 이수정
 * @history :
 *          -----------------------------------------------------------------------
 *          DATE AUTHOR NOTE ----------- -------------------
 *          --------------------------------------- 2018. 7. 26. 이수정 최초 생성
 *          -----------------------------------------------------------------------
 */
public class ConstantCode {

    public class TAG {
	public static final byte APPLICATION_CLASS	= (byte) 0x40;
	public static final byte CONTEXT_SPECIFIC_CLASS	= (byte) 0x80;
	public static final byte PRIVATE_CLASS		= (byte) 0xC0;
	public static final byte CONSTRUCTED_DATAOBJECT	= (byte) 0x20;
	public static final byte MULTI_BYTE_TAG		= (byte) 0x1F;
	public static final byte MULTI_BYTE_TAG_2	= (byte) 0x80;

    }

    public class LENGTH {
	public static final byte LONG_FORM   = (byte) 0x80;
	public static final byte SHORT_FORM  = (byte) 0x7F;

	public static final byte SINGLE_BYTE = (byte) 0x7F;
	public static final byte MULTI_BYTE  = (byte) 0x80;
    }

    public class RES_CODE {
	public static final String SUCCESS	  = "0000"; // 성공
	public static final String SYNTAX_ERROR	  = "1000"; // 구문오류
	public static final String REQUIRED_ERROR = "1001"; // 필수값누락 오류
	public static final String FORMAT_ERROR	  = "1002"; // 요청 데이터 형식 오류
	public static final String SYSERR	  = "9999"; // 예기치 않은 오류
    }

    public class RES_MSG {
	public static final String SUCCESS	  = "성공";
	public static final String SYNTAX_ERROR	  = "데이터 형식이 맞지 않습니다.";
	public static final String REQUIRED_ERROR = "필수 데이터를 입력하여 주세요.";    // 필수값누락
	public static final String FORMAT_ERROR	  = "요청한 데이터 형식이 맞지 않습니다."; // 요청데이터형식오류
	public static final String SYSERR	  = "예기치 않은 오류가 발생하였습니다.";  // 원인을알수없는오류
    }
}
