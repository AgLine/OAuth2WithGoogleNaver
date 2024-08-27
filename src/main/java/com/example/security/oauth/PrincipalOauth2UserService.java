package com.example.security.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
// loadUser는 구글에서 유저 프로필 받아옴
    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException{
        System.out.println("userRequest : " + oAuth2UserRequest.getClientRegistration());
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        
        if(oAuth2UserRequest.getClientRegistration().getRegistrationId().equals("google")) {
        	System.out.println("oauth에서 받아온 정보 : "+ oAuth2User.getAttributes());
        }
        
        if(oAuth2UserRequest.getClientRegistration().getRegistrationId().equals("naver")) {
        	System.out.println("oauth에서 받아온 정보 : "+ oAuth2User.getAttributes().get("response"));
        }
        return oAuth2User;
    }
}
