package com.kabank.web.serviceImpl;

import java.util.Random;
import java.util.Scanner;

/*
 * 님 앞으로 1234-통장개설이 되엇습니다.
 * */
public class AccountServiceImpl {
	private String name;
	private int accountNum;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setAccountNum() {
		Random r = new Random();
		boolean flag = true;
		while(flag) {
			int temp =  r.nextInt(1000000);
			if(temp>=100000) {
				accountNum = temp;
				flag = false;
			}else {
				flag = true;
			}
			System.out.println();
		}
		
	}
	public int getAccountNum() {
	return this.accountNum;
	}
}
