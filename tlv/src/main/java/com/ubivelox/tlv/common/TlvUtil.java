package com.ubivelox.tlv.common;

import java.util.ArrayList;
import java.util.List;

import com.ubivelox.tlv.domain.Tlv;

public class TlvUtil {
    public static List<Tlv> parse(String strHex) {
	List<Tlv> tlvLst = new ArrayList<>();

	byte[] bytes = HexUtil.convertHexStringToByte(strHex);

	for (int i = 0; i < 100; i++) {
	    if (i == 0) {
		tlvLst.add(parseResult(bytes, i, bytes.length));
	    }
	}

	return tlvLst;
    }

    private static Tlv parseResult(byte[] bytes, int idx, int len) {
	Tlv result = new Tlv();
	// 1. 태그
	int tagBytes = getTagBytes(bytes, idx); // TAG의 바이트를 가져온다.
	System.out.println(" 1. tagBytes >> " + tagBytes);
	result.setTag(createTag(bytes, idx, tagBytes));

	// 2. 길이
	int lengthBytes = getLengthBytes(bytes, idx + tagBytes);
	System.out.println(" 2. lengthBytes >> " + lengthBytes);

	result.setLength(getValueLength(bytes, idx + tagBytes, lengthBytes));

	// 3. 값
	result.setValue(getValue(bytes, idx, tagBytes, result.getTag(), lengthBytes, result.getLength()));
	return result;

    }

    /**
     *
     * @MethodName : getValue
     * @MethodExplain :
     * @date : 2018. 7. 20. 오후 5:38:23
     * @author : 이수정
     *
     * @param bytes
     * @param idx
     * @param tagBytes
     * @param lengthBytes
     * @param length
     * @return
     */
    private static String getValue(byte[] bytes, int idx, int tagBytes, String tag, int lengthBytes, int valueLength) {
	String value = "";

	byte[] tagByte = HexUtil.convertHexStringToByte(tag);

	// 구성데이터 처리
	if ((tagByte[0] & ConstantCode.TAG.CONSTRUCTED_DATAOBJECT) == ConstantCode.TAG.CONSTRUCTED_DATAOBJECT) {
	    System.out.println("CONSTRUCTED DATA OBJECT");
	} else { // 원시데이터 처리
	    System.out.println("PRIMITIVE DATA OBJECT");
	}

	return value;
    }

    /**
     * Value 의 길이
     *
     * @MethodName : getValueLength
     * @MethodExplain :
     * @date : 2018. 7. 20. 오후 3:22:03
     * @author : 이수정
     *
     * @param bytes
     * @param idx
     * @return
     * @throws Exception
     */
    private static int getValueLength(byte[] bytes, int idx, int lengthBytes) {
	int length = bytes[idx] & 0xFF;

	if (lengthBytes > 1 && lengthBytes <= 3) {
	    length = 0;
	    for (int i = idx + 1; i < idx + lengthBytes; i++) {
		length = length * 0x100 + (bytes[i] & 0xFF);
		System.out.println(i + ") getValueLength >> " + length);
	    }
	}

	return length;
    }

    /**
     *
     * @MethodName : getLengthBytes
     * @MethodExplain :
     * @date : 2018. 7. 19. 오후 5:29:01
     * @author : 이수정
     *
     * @param bytes
     * @param idx
     * @return
     */
    private static int getLengthBytes(byte[] bytes, int idx) {
	int lenBytes = 1;

	if ((bytes[idx] & ConstantCode.LENGTH.MULTI_BYTE) == ConstantCode.LENGTH.MULTI_BYTE) { // 1바이트이상
	    lenBytes += bytes[idx] & ConstantCode.LENGTH.SINGLE_BYTE; //
	}

	return lenBytes;
    }

    /**
     *
     * @MethodName : createTag
     * @MethodExplain :
     * @date : 2018. 7. 19. 오후 5:16:38
     * @author : 이수정
     *
     * @param bytes
     * @param idx
     * @param tagBytesCount
     * @return
     */
    private static String createTag(byte[] bytes, int idx, int tagBytes) {
	String tag = HexUtil.arrayByteIndexToHexString(bytes, idx, tagBytes);
	return tag;
    }

    /**
     *
     * @MethodName : getTagBytes
     * @MethodExplain :
     * @date : 2018. 7. 19. 오후 5:20:12
     * @author : 이수정
     *
     * @param bytes
     * @param idx
     * @return
     */
    private static int getTagBytes(byte[] bytes, int idx) {
	if ((bytes[idx] & ConstantCode.TAG.MULTI_BYTE_TAG) == ConstantCode.TAG.MULTI_BYTE_TAG) {
	    int len = 2;
	    for (int i = idx + 1; i < idx + 10; i++) {
		if ((bytes[i] & ConstantCode.TAG.MULTI_BYTE_TAG_2) != ConstantCode.TAG.MULTI_BYTE_TAG_2) {
		    break;
		}
		len++;
	    }
	    return len;
	} else {
	    return 1;
	}
    }

}