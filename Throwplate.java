package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Throwplate {

	/**
	 * @author wyl
	 * ��һ�ھ������ĸ߶�ΪN��ÿ��1����λ���Ŀ���б仯��
	 * ���ڴӾ�����������Բ�̣����Բ�̵Ŀ�ȴ��ھ���ĳ���߶ȵĿ�ȣ�
	 * ��Բ�̱���ס��ǡ�õ��ڵĻ�����ȥ����
	 * �����м������ˣ�1���������ס�2������ס��3���䵽��������Ϸ���
	 * ���ӵĸ߶�Ҳ�ǵ�λ�߶ȡ��������Ŀ�Ⱥ�ÿ�����ӵĿ�ȣ�
	 * �������䵽���ڵ�����������
	 * ��ͼ����������Ϣ���£�
		����5 6 4 3 6 2 3
		���ӣ�2 3 5 2 4
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		//���ɾ�
		int tmp=0;
		int sum=0;
		int M=7;	//���ČӔ���M
		int N=5;	//�P�ӵĂ�����N
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<M;i++){
			tmp=sc.nextInt();
			//�����A̎���򠑾�������϶������沿��С
			if(i==0){
				list.add(tmp);
			}else{
				list.add(Math.min(tmp, list.get(i-1)));
			}
			
		}
		System.out.println(list);
		
		for(int j=1;j<=N;j++){
			//ݔ��P�ӌ���
			tmp = sc.nextInt();
			if((M-1)>=0){
				while(list.get(M-1)<tmp){
					M--;
				}
			}
			if(M>0) {
				sum++;
				System.out.println("sum--->"+sum);
				M--;
			}else{
				System.out.println(sum);
				return;
			}
		}
		
	}
}
