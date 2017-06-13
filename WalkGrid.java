package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class WalkGrid {

	/**
	 * @author wyl
	 * �б��1-n��n�����ӣ������˴�1�Ÿ���˳������ߣ�һֱ�ߵ�n�Ÿ��ӣ�
	 * ����Ҫ��n�Ÿ����߳�ȥ����������һ����ʼ������ÿ�����Ӷ�Ӧһ������A[i]��
	 * ��ʾ������ӵ�����ֵ�����A[i] > 0���������ߵ���������ܹ���ȡA[i]
	 * �����������A[i] < 0���ߵ����������Ҫ������Ӧ��������
	 * ��������˵����� < 0�����޷�����ǰ���ˡ�
	 * �ʻ�����������Ҫ�ж��ٳ�ʼ������������������ó̡�
	 * 
	 * ���磺n = 5��{1��-2��-1��3��4} ������Ҫ2����ʼ������
	 * ���ܴ�1���ߵ�5�Ÿ��ӡ�;�е������仯����3 1 0 3 7��
	 */
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<5;i++){
			String input = sc.next();
			if (input.matches("-?[0-9]+.*[0-9]*")){
				System.out.println("�������ֵΪ"+Integer.parseInt(input));
				list.add(Integer.parseInt(input));
			}else{
				i = i-1;
				System.out.println("ݔ��Ĳ��ǔ��֣�Ո����ݔ��");
			}
			
		}
		System.out.println(list);
		int result = fun(list);
		System.out.println("�Y���飺"+result);
		
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
