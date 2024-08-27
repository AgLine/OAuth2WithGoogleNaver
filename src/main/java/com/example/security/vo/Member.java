package com.example.security.vo;

import lombok.Data;

@Data
public class Member {
	
	// provider : google이 들어감
    private String provider;

    // providerId : 구굴 로그인 한 유저의 고유 ID가 들어감
    private String providerId;
    
    private String name;
    private String email;
}
