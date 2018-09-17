package com.base;

public class Number_Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=1233346556;
		int count=0;
		while(num>0) {
			num=num/10;
			count++;
		}
		System.out.println(count);

	}

}
