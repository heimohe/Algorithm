package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Maxslope {
	/**
	 * @author wyl
	 * ƽ������N���㣬����2����ȷ��һ��ֱ�ߣ����������Щֱ���У�б����������ֱ����ͨ���������㡣
	 * ����ı��Ϊ1-N������ж���ֱ��б����ȣ���������н�������յ��X�����������������.
	 * ���������е��X�����������ȣ��ҵ�����Ϊ�������
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//����5����
		Scanner scan = new Scanner(System.in);
		ArrayList list = new ArrayList();
		int x , y;
		double max=0;
		for(int i=0;i<5;i++) {
			x = scan.nextInt();
			y = scan.nextInt();
			spot spot =new spot(x, y);
			list.add(spot);
		}
		//�Ե��������
		Collections.sort(list,new Comparator<spot>() {

			public int compare(spot o1, spot o2) {
				// ����x���ֵ��������
				if(o1.getX()>o2.getX()){
					return 1;
				}
				return -1;
			}
		});
		System.out.println(list);
		//�������ڵ�������������б��
		for(int i=0;i<4;i++){
			spot dian = (spot)list.get(i);
			spot dian1 = (spot)list.get(i+1);
			double res = (dian1.getY()-dian.getY())/(dian1.getX()-dian.getX());
			if(res>max){
				max=res;
			}
		}
		System.out.println("���б��Ϊ"+max);
	}
}


