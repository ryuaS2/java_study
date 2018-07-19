package com.ubivelox.tlv.util;

import java.util.ArrayList;
import java.util.List;

import com.ubivelox.tlv.domain.Tlv;

public class TlvUtil {
    public static List<Tlv> parse(String strHex) {
	List<Tlv> tlvLst = new ArrayList<>();

	byte[] bytes = HexUtil.convertHexStringToByte(strHex);

	for (int i = 0; i < bytes.length; i++) {
	    if (i == 0) {
		tlvLst.add(parseResult(bytes, i, bytes.length));
	    }
	}

	return null;
    }

    private static Tlv parseResult(byte[] bytes, int idx, int len) {
	Tlv result = new Tlv();
	// 1. 태그 바이트 구하기
	int tagBytes = getTagBytes(bytes, idx); // TAG의 바이트를 가져온다.
	result.setTag(createTag(bytes, idx, tagBytes));

	// 2. 길이 바이트 구하기
	int lengthBytesCount = getLengthBytes(bytes, idx + tagBytes);
	result.setLength(getValueLength(bytes, idx + tagBytes));
	return null;

    }

    private static int getValueLength(byte[] bytes, int idx) {
	int length = bytes[idx] & 0xff;

	if ((length & 0x80) == 0x80) {
	    int numberOfBytes = length & 0x7f;

	    length = 0;
	    for (int i = idx + 1; i < idx + 1 + numberOfBytes; i++) {
		length = length * 0x100 + (bytes[i] & 0xff);
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
	int len = bytes[idx] & 0xff;

	if ((len & 0x80) == 0x80) { // 127이상일 경우 1바이트 이상
	    return 1 + (len & 0x7f);
	} else { // 127이하일 경우 1바이트 반환
	    return 1;
	}
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
	if ((bytes[idx] & 0x1F) == 0x1F) { // 31일 경우 태그 2Byte
	    int len = 2;
	    for (int i = idx + 1; i < idx + 10; i++) {
		if ((bytes[i] & 0x80) != 0x80) {
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