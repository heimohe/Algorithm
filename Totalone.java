package com.test;

import java.util.Scanner;

public class Totalone {
	/**
	 * @author wyl
	 * �ж�һ�������Ķ�����λ���ж��ٸ�1
	 */
	static int kk=0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();
		int sum = count(value);
		System.out.println(sum);
	}
	private static int count(int value) {
		while(value!=0){
			value = value&(value-1);
			kk++;
		}
		return kk;
	}

}
