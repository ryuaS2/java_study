package com.ubivelox.tlv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ubivelox.tlv.domain.TlvParseData;
import com.ubivelox.tlv.service.TlvParseService;

@Controller
public class TlvParseController {

    @Autowired
    private TlvParseService tlvParseService;

    /**
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
    public String mainForm(@ModelAttribute TlvParseData params, Model model) {
	model.addAttribute("data", new TlvParseData());
	return "index";
    }

    /**
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
    public String parseTlvData(@ModelAttribute TlvParseData params, Model model) {
	System.out.println(params.getReqTlv());
	params = tlvParseService.parseTlv(params);
	model.addAttribute("data", params);

	System.out.println(params.toString());
	return "index";
    }
}
