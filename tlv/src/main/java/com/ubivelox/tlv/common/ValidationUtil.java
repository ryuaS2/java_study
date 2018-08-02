package com.ubivelox.tlv.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

/**
 *
 * @PackageName : eams.common.util
 * @FileName : ValidationUtil.java
 * @FileExplain : 데이터 유효성체크
 * @date : 2016. 11. 7. 오후 4:23:30
 * @version : 1.0
 * @author : 이수정
 * @history :
 *          -----------------------------------------------------------------------
 *          DATE AUTHOR NOTE ----------- -------------------
 *          --------------------------------------- 2016. 11. 7. 이수정 최초 생성
 *          -----------------------------------------------------------------------
 */
@Component
public class ValidationUtil {

    public static final String HANGUL_REGEX = "^[ㄱ-ㅎ가-힣]*$";

    public static final String ALPHA_REGEX  = "^[a-zA-Z]*$";

    public static final String NUMBER_REGEX = "^[0-9]*$";

    public static final String EMAIL_REGEX  = "(\\w+\\.)*\\w+@(\\w+\\.)+[A-Za-z]+";

    public static final String IP4_REGEX    = "((([0-9])|([1-9]\\d{1})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}(([0-9])|([1-9]\\d{1})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))";

    public static final String MAC_REGEX    = "([0-9A-Fa-f]{1,2}[:-]){5}([0-9A-Fa-f]{1,2})";

    public static final String MOBILE_REGEX = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";

    public static final String TEL_REGEX    = "^\\d{2,3}-\\d{3,4}-\\d{4}$";

    public static final String HEXA_REGEX   = "^[a-fA-F0-9]*$";

    public String[]	       EXE_ARRAY    = { ".jsp", ".php", ".asp", ".cgi", ".exe" };
    public String[]	       IMG_ARRAY    = { ".gif", ".png", ".jpg", ".jpeg", ".gif", ".bmp" };

    /**
     *
     * @MethodName : isRequired
     * @MethodExplain : 필수값 체크
     * @date : 2016. 11. 16. 오후 3:09:40
     * @author : 이수정
     *
     * @param obj
     * @return
     */
    public static boolean isRequired(Object obj) {
	boolean result = false;

	if (obj == null || obj.toString().trim().length() == 0) {
	    result = false;
	} else {
	    result = true;
	}
	return result;
    }

    /**
     *
     * @MethodName : isHangul
     * @MethodExplain : 한글형식 체크
     * @date : 2016. 11. 7. 오후 4:43:02
     * @author : 이수정
     *
     * @param str
     * @return
     */
    public static boolean isHangul(String str) {
	return str.matches(HANGUL_REGEX);
    }

    /**
     *
     * @MethodName : isHangul
     * @MethodExplain : 필수 값 및 한글형식인지 체크
     * @date : 2016. 11. 16. 오후 5:22:22
     * @author : 이수정
     *
     * @param str
     * @param check
     * @return
     */
    public static boolean isHangul(String str, boolean check) {
	boolean result = false;

	if (check) {
	    if (isRequired(str) && str.matches(HANGUL_REGEX)) {
		result = true;
	    }
	}
	return result;
    }

    /**
     *
     * @MethodName : isAlphabet
     * @MethodExplain : 영문 형식체크
     * @date : 2016. 11. 16. 오후 7:46:20
     * @author : 이수정
     *
     * @param str
     * @return
     */
    public static boolean isAlphabet(String str) {
	return str.matches(ALPHA_REGEX);
    }

    /**
     *
     * @MethodName : isAlphabet
     * @MethodExplain : 필수값 및 영문 형식체크
     * @date : 2016. 11. 16. 오후 7:46:23
     * @author : 이수정
     *
     * @param str
     * @param check
     * @return
     */
    public static boolean isAlphabet(String str, boolean check) {
	boolean result = false;

	if (check) {
	    if (isRequired(str) && str.matches(ALPHA_REGEX)) {
		result = true;
	    }
	}
	return result;
    }

    /**
     *
     * @MethodName : isNumber
     * @MethodExplain : 숫자형식 체크
     * @date : 2016. 11. 16. 오후 7:51:20
     * @author : 이수정
     *
     * @param num
     * @return
     */
    public static boolean isNumber(String num) {
	return num.matches(NUMBER_REGEX);
    }

    /**
     *
     * @MethodName : isNumber
     * @MethodExplain : 필수값 및 숫자형식 체크
     * @date : 2016. 11. 16. 오후 7:51:24
     * @author : 이수정
     *
     * @param num
     * @param check
     * @return
     */
    public static boolean isNumber(String num, boolean check) {
	boolean result = false;

	if (check) {
	    if (isRequired(num) && num.matches(NUMBER_REGEX)) {
		result = true;
	    }
	}
	return result;
    }

    /**
     * <pre>
     * 1. Summary :
     * 2. Details :
     *
     * 3. LastModifiedDate :
     * 4. LastReviewedDate :
     * 5. History
     * 		2018. 8. 1. writing comments
     *
     * </pre>
     *
     * @param num
     * @return
     */
    public static boolean isHexaDec(String str) {
	return str.matches(HEXA_REGEX);
    }

    /**
     * <pre>
     * 1. Summary :
     * 2. Details :
     *
     * 3. LastModifiedDate :
     * 4. LastReviewedDate :
     * 5. History
     * 		2018. 8. 1. writing comments
     *
     * </pre>
     *
     * @param num
     * @param check
     * @return
     */
    public static boolean isHexaDec(String num, boolean check) {
	boolean result = false;

	if (check) {
	    if (isRequired(num) && num.matches(HEXA_REGEX)) {
		result = true;
	    }
	}
	return result;
    }

    /**
     *
     * @MethodName : isEmail
     * @MethodExplain : 이메일주소 형식 체크
     * @date : 2016. 11. 7. 오후 4:23:34
     * @author : 이수정
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
	return email.matches(EMAIL_REGEX);
    }

    /**
     *
     * @MethodName : isEmail
     * @MethodExplain : 필수값 및 이메일형식 체크
     * @date : 2016. 11. 16. 오후 5:14:55
     * @author : 이수정
     *
     * @param email
     * @param check
     * @return
     */
    public static boolean isEmail(String email, boolean check) {
	boolean result = false;

	if (check) {
	    if (isRequired(email) && email.matches(EMAIL_REGEX)) {
		result = true;
	    }
	}
	return result;
    }

    /**
     *
     * @MethodName : isIp4Addr
     * @MethodExplain : IP4 주소형식 체크
     * @date : 2016. 11. 7. 오후 4:38:52
     * @author : 이수정
     *
     * @param ip
     * @return
     */
    public static boolean isIp4(String ip) {
	/*
	 * ([0-9])는 한 자리 숫자 ([1-9]\\d{1})는 2 자리 숫자, 즉 10~99 (1\d{2})는 1로 시작하는 세
	 * 자리 숫자, 즉 100에서 199 사이의 숫자와 일치한다. (2[0-4]\d)는 200에서 249 사이의 숫자와 일치한다.
	 * (25[0-5])는 250에서 255 사이의 숫자와 일치한다.
	 */
	return ip.matches(IP4_REGEX);
    }

    /**
     *
     * @MethodName : isIp4
     * @MethodExplain :
     * @date : 2016. 11. 16. 오후 5:20:48
     * @author : 이수정
     *
     * @param ip
     * @param check
     * @return
     */
    public static boolean isIp4(String ip, boolean check) {
	boolean result = false;

	if (check) {
	    if (isRequired(ip) && ip.matches(IP4_REGEX)) {
		result = true;
	    }
	}
	return result;
    }

    /**
     *
     * @MethodName : isMacAddr
     * @MethodExplain :
     * @date : 2016. 11. 15. 오후 6:04:40
     * @author : 이수정
     *
     * @param macAddr
     * @return
     */
    public static boolean isMacAddr(String macAddr) {
	return macAddr.matches(MAC_REGEX);
    }

    /**
     *
     * @MethodName : isMacAddr
     * @MethodExplain : 필수값 및 맥주소형식 체크
     * @date : 2016. 11. 16. 오후 3:11:22
     * @author : 이수정
     *
     * @param macAddr
     * @param check
     * @return
     */
    public static boolean isMacAddr(String macAddr, boolean check) {
	boolean result = false;

	if (check) {
	    if (isRequired(macAddr) && macAddr.matches(MAC_REGEX)) {
		result = true;
	    }
	}
	return result;
    }

    /**
     *
     * @MethodName : isMobilePhoneNo
     * @MethodExplain : 핸드폰번호 체크
     * @date : 2016. 11. 7. 오후 5:55:30
     * @author : 이수정
     *
     * @param phoneNo
     * @return
     */
    public static boolean isMobilePhoneNo(String phoneNo) {
	return phoneNo.matches(MOBILE_REGEX);
    }

    /**
     *
     * @MethodName : isMobilePhoneNo
     * @MethodExplain :
     * @date : 2016. 11. 16. 오후 5:25:45
     * @author : 이수정
     *
     * @param phoneNo
     * @param check
     * @return
     */
    public static boolean isMobilePhoneNo(String phoneNo, boolean check) {
	boolean result = false;

	if (check) {
	    if (isRequired(phoneNo) && phoneNo.matches(MOBILE_REGEX)) {
		result = true;
	    }
	}
	return result;
    }

    /**
     *
     * @MethodName : isTelPhoneNo
     * @MethodExplain : 일반전화번호 체크
     * @date : 2016. 11. 8. 오후 3:25:12
     * @author : 이수정
     *
     * @param phoneNo
     * @return
     */
    public static boolean isTelPhoneNo(String phoneNo) {
	return phoneNo.matches(TEL_REGEX);
    }

    /**
     *
     * @MethodName : isTelPhoneNo
     * @MethodExplain : 필수 값 및 일반전화번호 형식 체크
     * @date : 2016. 11. 16. 오후 7:37:50
     * @author : 이수정
     *
     * @param phoneNo
     * @param check
     * @return
     */
    public static boolean isTelPhoneNo(String phoneNo, boolean check) {
	boolean result = false;

	if (check) {
	    if (isRequired(phoneNo) && phoneNo.matches(TEL_REGEX)) {
		result = true;
	    }
	}
	return result;
    }

    /**
     *
     * @MethodName : isDate
     * @MethodExplain : 날짜포맷 형식체크
     * @date : 2016. 11. 16. 오후 8:06:30
     * @author : 이수정
     *
     * @param szDate
     * @param szFormat
     * @return
     */
    public static boolean isDate(String szDate, String szFormat) {

	boolean result = true;
	SimpleDateFormat oDateFormat = new SimpleDateFormat();

	oDateFormat.applyPattern(szFormat);
	oDateFormat.setLenient(false); // 엄밀하게 검사한다는 옵션 (반드시 있어야 한다)

	try {
	    oDateFormat.parse(szDate);
	} catch (ParseException e) {
	    result = false;
	}
	return result;
    }

    /**
     *
     * @MethodName : isDate
     * @MethodExplain : 필수값 및 데이터형식 체크
     * @date : 2016. 11. 16. 오후 8:27:12
     * @author : 이수정
     *
     * @param szDate
     * @param szFormat
     * @param check
     * @return
     */
    public static boolean isDate(String szDate, String szFormat, boolean check) {
	boolean result = true;

	if (check) {
	    if (isRequired(szDate) && isDate(szDate, szFormat)) {
		result = true;
	    }
	}
	return result;
    }

    /**
     *
     * @MethodName : isImg
     * @MethodExplain : 이미지 파일 확장자인지 체크
     * @date : 2016. 11. 24. 오후 11:25:57
     * @author : UBIVELOX
     *
     * @param fileName
     * @return
     */
    public boolean isImg(String fileName) {
	boolean result = false;

	for (int i = 0; i < IMG_ARRAY.length; i++) {
	    if (fileName.toLowerCase().endsWith(IMG_ARRAY[i])) {
		result = true;
		break;
	    }
	}

	return result;
    }

    /**
     *
     * @MethodName : isEXE
     * @MethodExplain : 실행 파일 확장자인지 체크
     * @date : 2016. 11. 24. 오후 11:25:59
     * @author : UBIVELOX
     *
     * @param fileName
     * @return
     */
    public boolean isExe(String fileName) {
	boolean result = false;

	for (int i = 0; i < EXE_ARRAY.length; i++) {
	    if (fileName.toLowerCase().endsWith(EXE_ARRAY[i])) {
		result = true;
		break;
	    }
	}

	return result;
    }
}
