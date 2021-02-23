package com.test.emailTest.test;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	private EmailSender email;
	
	@RequestMapping("/mail")
	public String test() {
		return "/mail";
	}
	
	
	@ResponseBody
    @RequestMapping("/sendMail")
    public String sendMail(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		String MAIL_HDKIM = "gusdnd3150@gmail.com"; //받는사람 setting
		try {
			email.sendAuthMail(MAIL_HDKIM);
		} catch (Exception e) {
		  e.printStackTrace();
		}

		return "success";
	}

	@RequestMapping("/member/signUpConfirm") // 이메일에 전송된 a tag 클릭 시 이 url을 타고 처리된다
	 public ModelAndView signUpConfirm(@RequestParam Map<String, String> map, ModelAndView mav){
	    //email, authKey 가 일치할경우 authStatus 업데이트
	    //memberService.updateAuthStatus(map);
	    
	    mav.addObject("display", "/view/member/signUp_confirm.jsp");
	    mav.setViewName("/view/index");
	    return mav;
	}
	
}
