package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class WalkGrid {

	/**
	 * @author wyl
	 * 有编号1-n的n个格子，机器人从1号格子顺序向后走，一直走到n号格子，
	 * 并需要从n号格子走出去。机器人有一个初始能量，每个格子对应一个整数A[i]，
	 * 表示这个格子的能量值。如果A[i] > 0，机器人走到这个格子能够获取A[i]
	 * 个能量，如果A[i] < 0，走到这个格子需要消耗相应的能量，
	 * 如果机器人的能量 < 0，就无法继续前进了。
	 * 问机器人最少需要有多少初始能量，才能完成整个旅程。
	 * 
	 * 例如：n = 5。{1，-2，-1，3，4} 最少需要2个初始能量，
	 * 才能从1号走到5号格子。途中的能量变化如下3 1 0 3 7。
	 */
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<5;i++){
			String input = sc.next();
			if (input.matches("-?[0-9]+.*[0-9]*")){
				System.out.println("输入的数值为"+Integer.parseInt(input));
				list.add(Integer.parseInt(input));
			}else{
				i = i-1;
				System.out.println("輸入的不是數字，請重新輸入");
			}
			
		}
		System.out.println(list);
		int result = fun(list);
		System.out.println("結果為："+result);
		
	}

	private static int fun(ArrayList<Integer> list) {
		int len  = list.size();
		int result = 0;
		int sum = 0;
		for(int i=0;i<len;i++){
			sum += list.get(i);
			if(sum < 0){
				result += -sum;
				sum = 0;
			}
		}
		return result;
		
	}

}
