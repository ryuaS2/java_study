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

}
