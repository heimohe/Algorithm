package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Canoe {

	/**
	 * @author wyl
	 * n���ˣ���֪ÿ�������ء���ľ�۳��ع̶���ÿֻ��ľ������������ˣ�
	 * ������һ���˻��������ˡ���ȻҪ����������������ľ�۳��أ�
	 * ����ÿ��������Ҳ��������ľ�۳��أ���������Ҫ��ֻ��ľ�ۣ�
	 */
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		int tmp;
		int MAX=150;	//���b���ܵ�����
		int sum=0;		//��Ҫ�Ĵ��b����
		//ݔ���˵��w��
		for(int i=0;i<7;i++){	//�@�e�ƶ���7����
			 tmp = sc.nextInt();
			 list.add(tmp);
		}
		Collections.sort(list);
		//���˵��w������
		System.out.println(list.toString());
		int len = list.size();
		System.out.println(len);
		int j = 0;
		while(j<len){
			if(list.get(j)+list.get(len-1)<= MAX){
				j++;	//�w���p�ĳ�ȥ
			}
			len--;	//�w���صĳ�ȥ
			sum++;	//���b��������
		}
		System.out.println("��Ҫ�Ĵ��b������--��"+sum);
	}

}
