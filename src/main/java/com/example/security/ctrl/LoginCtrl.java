package com.example.security.ctrl;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginCtrl {
	
	@GetMapping("/loginForm")
    public String login(){
		//http://localhost:9090/loginForm
        return "loginForm";
    }
	
	@GetMapping("/home")
	@ResponseBody
    public String home(){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
		String registrationId = oauthToken.getAuthorizedClientRegistrationId();
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        
        String id="";
        String name=""; 
        String email="";
        
        if("naver".equals(registrationId)) {
        	System.out.println(oAuth2User.getAttributes().get("response"));
        	Map<String, String> tmpMap = (Map<String, String>) oAuth2User.getAttributes().get("response");
        	
        	id = tmpMap.get("id");
        	name = tmpMap.get("name");
        	email = tmpMap.get("email");
        }
        
        if("google".equals(registrationId)) {
        	System.out.println(oAuth2User);
        	id = oAuth2User.getAttribute("sub");
        	name = oAuth2User.getAttribute("name");
        	email = oAuth2User.getAttribute("email");
        }
        

        return "id:::"+id+"\n"+"name:::"+name+"\n"+"email:::"+email;
    }
}
