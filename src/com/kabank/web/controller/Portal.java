package com.kabank.web.controller;

import java.util.Scanner;

import com.kabank.bean.MemberBean;
import com.kabank.web.service.MemberService;
import com.kabank.web.serviceImpl.AccountServiceImpl;
import com.kabank.web.serviceImpl.MemberServiceImpl;

public class Portal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("[인원]입력");
		//int count = (scanner.nextInt());//외부에서 받아야하니 스캐너를 달자
		MemberServiceImpl memberService = new MemberServiceImpl(scanner.nextInt());
		MemberBean member = null;
		while (true) {
			System.out.print("[MENU] 0.종료 1.회원가입 2.계좌개설 3.총회원수4.회원목록");
			switch (scanner.nextInt()) {
			case 0:
				System.out.print("종료");
				return;
			case 1:
				member = new MemberBean();
				System.out.print("이름");
				member.setName(scanner.next());
				System.out.print("주민번호");
				member.setSsn(scanner.next());
				member.setCustomNum(memberService.createCustomNum());
				member.setGender(memberService.findGender(member.getSsn()));
				member.setAge(memberService.findAge(member.getSsn()));
				memberService.addMember(member);//1.필요하니 에러나도 추가 이제 메뉴판 일플에 추가

				System.out.print(
						"[고객번호]" + member.getCustomNum()
						+ "[주민번호]" + member.getSsn()
						+ "[이름]"	+ member.getName()
						+ "[성별]" + member.getGender()
						+ "[나이]" + member.getAge());

				break;
			case 2:
				AccountServiceImpl createAccount = new AccountServiceImpl();
				System.out.print("이름");
				createAccount.setName(scanner.next());
				System.out.println("[계좌번호]");
				createAccount.setAccountNum();

				System.out.print("[이름]" + createAccount.getName() + "[계좌번호]" + createAccount.getAccountNum());

				break;
			case 3 :
				System.out.println("[총 회원수]" + memberService.count());
				break;
			case 4 :
				MemberBean[] members = memberService.list();//1.리스트
				for(int i=0;i<members.length;i++) {
					System.out.println("[회원]"+members[i].getName());
				}
				break;
				
			}
		}
	}
}
