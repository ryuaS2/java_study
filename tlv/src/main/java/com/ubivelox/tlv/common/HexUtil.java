package com.ubivelox.tlv.common;

public class HexUtil {
    private static final char[]	HEXA_TABLES = "0123456789ABCDEF".toCharArray();
    static final byte[]		BYTES	    = new byte[128];

    static {
	for (int i = 0; i < 10; i++) {
	    BYTES['0' + i] = (byte) i;
	    BYTES['A' + i] = (byte) (10 + i);
	    BYTES['a' + i] = (byte) (10 + i);
	}
    }

    public static String toHexString(final byte[] bytes) {
	return toHexString(bytes, 0, bytes.length);
    }

    public static String toFormattedHexString(final byte[] bytes) {
	return toFormattedHexString(bytes, 0, bytes.length);
    }

    public static String toHexString(final byte[] bytes, final int aLength) {
	return toHexString(bytes, 0, aLength);
    }

    /**
     * <pre>
     * 1. Summary :16진수 String을 Byte[]로 변환
     * 2. Details :
     *
     * 3. LastModifiedDate :
     * 4. LastReviewedDate :
     * 5. History
     * 		2018. 5. 18. writing comments
     *
     * </pre>
     *
     * @param hexStr
     * @return
     */
    public static byte[] convertHexStringToByte(final String hexStr) {

	byte[] hexByte = new byte[hexStr.length() / 2];

	for (int i = 0; i < hexByte.length; i++) {
	    hexByte[i] = (byte) Integer.parseInt(hexStr.substring(2 * i, 2 * i + 2), 16);
	}

	return hexByte;
    }

    public static String convertByteToHexString(final byte hexByte[]) {

	StringBuffer sb = new StringBuffer(hexByte.length * 2);
	String hexaDecimal;

	for (int x = 0; x < hexByte.length; x++) {
	    hexaDecimal = "0" + Integer.toHexString(0xff & hexByte[x]);
	    sb.append(hexaDecimal.substring(hexaDecimal.length() - 2));
	}

	return sb.toString();
    }

    /**
     *
     * @MethodName : arrayByteIndexToHexString
     * @MethodExplain :
     * @date : 2018. 7. 19. 오후 5:14:15
     * @author : 이수정
     *
     * @param bytes
     * @param offset
     * @param length
     * @return
     */
    public static String arrayByteIndexToHexString(final byte[] bytes, final int offset, final int length) {
	StringBuilder sb = new StringBuilder();
	String hexaDecimal;
	for (int i = offset; i < offset + length; i++) {
	    hexaDecimal = "0" + Integer.toHexString(0xff & bytes[i]);
	    sb.append(hexaDecimal.substring(hexaDecimal.length() - 2));
	}
	return sb.toString();
    }

    public static String toFormattedHexString(final byte[] bytes, final int aOffset, final int aLength) {
	StringBuilder sb = new StringBuilder();
	for (int si = aOffset, di = 0; si < aOffset + aLength; si++, di++) {
	    byte b = bytes[si];
	    sb.append(HEXA_TABLES[(b & 0xf0) >>> 4]);
	    sb.append(HEXA_TABLES[(b & 0x0f)]);
	}

	return sb.toString();

    }

    public static String toHexString(final byte[] bytes, final int aOffset, final int aLength) {
	char[] dst = new char[aLength * 2];

	for (int si = aOffset, di = 0; si < aOffset + aLength; si++) {
	    byte b = bytes[si];
	    dst[di++] = HEXA_TABLES[(b & 0xf0) >>> 4];
	    dst[di++] = HEXA_TABLES[(b & 0x0f)];
	}

	return new String(dst);
    }
}
