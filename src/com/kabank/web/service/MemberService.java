package com.kabank.web.service;

import com.kabank.bean.MemberBean;

public interface MemberService {
	public int createCustomNum();//추상메소드
	public String findGender(String ssn);//바디가없는 메소드
	public int findAge(String ssn);
	public void addMember(MemberBean member);//
	public int count();
	public MemberBean[] list();//3초기화
	
	
}
