package com.ubivelox.tlv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ubivelox.tlv.domain.TlvParseData;

@Controller
public class TlvController {

    @RequestMapping("/index")
    public String mainForm(Model model) {
	model.addAttribute("data", new TlvParseData());
	return "index";
    }

    @RequestMapping("/parseTlv")
    public String parseTlvData(@ModelAttribute TlvParseData params, Model model) {
	System.out.println(params.getReqTlv());

	model.addAttribute("data", params);

	System.out.println(params.toString());
	return "index";
    }
}
