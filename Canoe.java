package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Canoe {

	/**
	 * @author wyl
	 * n个人，已知每个人体重。独木舟承重固定，每只独木舟最多坐两个人，
	 * 可以坐一个人或者两个人。显然要求总重量不超过独木舟承重，
	 * 假设每个人体重也不超过独木舟承重，问最少需要几只独木舟？
	 */
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		int tmp;
		int MAX=150;	//船隻承受的重量
		int sum=0;		//需要的船隻數量
		//輸入人的體重
		for(int i=0;i<7;i++){	//這裡制定有7個人
			 tmp = sc.nextInt();
			 list.add(tmp);
		}
		Collections.sort(list);
		//把人的體重排序
		System.out.println(list.toString());
		int len = list.size();
		System.out.println(len);
		int j = 0;
		while(j<len){
			if(list.get(j)+list.get(len-1)<= MAX){
				j++;	//體重輕的出去
			}
			len--;	//體重重的出去
			sum++;	//船隻數量增加
		}
		System.out.println("需要的船隻數量為--》"+sum);
	}

}
