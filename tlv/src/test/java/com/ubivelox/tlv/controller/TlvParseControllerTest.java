package com.ubivelox.tlv.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ubivelox.tlv.domain.TlvParseData;
import com.ubivelox.tlv.service.TlvParseService;

public class TlvParseControllerTest {

    @Mock
    private TlvParseService    tlvParseService;
    @InjectMocks
    private TlvParseController tlvParseController = new TlvParseController();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	System.out.println("======[Class] TlvParseControllerTest START======");
    }

    @Test
    public void testMainForm() {

	Model mockModel = mock(Model.class);
	HttpServletRequest mockRequest = mock(HttpServletRequest.class);
	TlvParseData mockParams = mock(TlvParseData.class);

	String result = tlvParseController.mainForm(mockParams, mockModel, mockRequest);

	assertEquals(result, "index");
    }

    @Test
    public void testMainFormFlash() {

	Model mockModel = mock(Model.class);
	HttpServletRequest mockRequest = mock(HttpServletRequest.class);
	TlvParseData mockParams = mock(TlvParseData.class);
	mockParams.setReqTlv("123123");
	mockModel.addAttribute("data", mockParams);

	Map<String, ?> mockFlashMap = RequestContextUtils.getInputFlashMap(mockRequest);

	String result = tlvParseController.mainForm(mockParams, mockModel, mockRequest);

	assertEquals(result, "index");
    }

    @Test
    public void testParseTlvData() {
	RedirectAttributes mockModel = mock(RedirectAttributes.class);
	TlvParseData mockParams = mock(TlvParseData.class);

	mockParams = tlvParseService.parseTlv(mockParams);

    }
}
