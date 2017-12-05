package com.kabank.web.serviceImpl;

import java.util.Calendar;

import com.kabank.bean.MemberBean;
import com.kabank.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
//
	
	private MemberBean[] members;//2. 멤버변수를 만들엇으니 초기화를만든다
	
	private int count; // 12.
	public MemberServiceImpl(int count) {  //3. 포탈에 인트 카운터를 전달
	members = new MemberBean[count]; //전달 받아야되니 int count를만든다)
		this.count = 0;
	}
	@Override
	public int count() { //빈이엿으면게터세터은 만든다//
		return this.count;
	}
	@Override
	public int createCustomNum() {
		int foo = 0;
		return foo;
	}
	@Override
	public String findGender(String ssn) {
		String foo = "";
		char ch = ssn.charAt(7);
		if (ch == '1' || ch == '3') {
			foo = "[남]";
		} else if (ch == '2' || ch == '4') {
			foo = "[여]";
		} else {
			foo = "[잘못된값]";
		}
		return foo;
	}
	@Override
	public int findAge(String ssn) {
		int foo = 0;
		Calendar now = Calendar.getInstance();
		char temp1 = ssn.charAt(0);
		char temp2 = ssn.charAt(1);
		String temp3 = "";
		int nowYear = now.get(now.YEAR);
		int ssnYear = Integer.parseInt(temp1 + temp2+"");
		int gap = nowYear - ssnYear;
		if (gap>=2000) {
			foo = Integer.parseInt(ssnYear+nowYear+"20" );
		}else {
			foo = Integer.parseInt(ssnYear+nowYear+"19");
		}
		foo = nowYear - foo; 
		return foo;
	}
	@Override
	public void addMember(MemberBean member) {
		members[count] = member; //11.멤버스에 카운터를 할당해야됨
		count++;
		//2. 메뉴판 임플 메인 빈
		
		
	}
	@Override
	public MemberBean[] list() {//2.초기화
		return members;
	}

	
}
