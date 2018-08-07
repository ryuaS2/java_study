package com.ubivelox.tlv.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.ubivelox.tlv.domain.TlvParseData;
import com.ubivelox.tlv.service.TlvParseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TlvParseController {

    @Autowired
    private TlvParseService tlvParseService;

    /**
     * 메인 화면
     *
     * @MethodName : mainForm
     * @MethodExplain :
     * @date : 2018. 7. 26. 오후 6:14:24
     * @author : 이수정
     *
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String mainForm(@ModelAttribute TlvParseData params, Model model, HttpServletRequest request) {
	// 리다이렉트 된 데이터를 받아 온다.
	Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
	if (flashMap != null) {
	    params = (TlvParseData) flashMap.get("data");
	}
	model.addAttribute("data", params);
	return "index";
    }

    /**
     * TLV 파싱
     *
     * @MethodName : parseTlvData
     * @MethodExplain :
     * @date : 2018. 7. 26. 오후 6:14:17
     * @author : 이수정
     *
     * @param params
     * @param model
     * @return
     */
    @RequestMapping("/parseTlv")
    public String parseTlvData(@ModelAttribute TlvParseData params, RedirectAttributes model) {

	params = tlvParseService.parseTlv(params);

	log.debug(params.toString());

	model.addFlashAttribute("data", params);

	return "redirect:index";
    }
}
