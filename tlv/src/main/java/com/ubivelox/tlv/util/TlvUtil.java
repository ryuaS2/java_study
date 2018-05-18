package com.ubivelox.tlv.util;

import java.util.ArrayList;
import java.util.List;

import com.ubivelox.tlv.domain.Tlv;

public class TlvUtil {
    public static List<Tlv> parse(String strHex) {
	List<Tlv> tlvLst = new ArrayList<>();

	byte[] bytes = HexUtil.convertHexStringToByte(strHex);

	return null;
    }

}