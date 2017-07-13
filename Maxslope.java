package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Maxslope {
	/**
	 * @author wyl
	 * 平面上有N个点，任意2个点确定一条直线，求出所有这些直线中，斜率最大的那条直线所通过的两个点。
	 * （点的编号为1-N，如果有多条直线斜率相等，则输出所有结果，按照点的X轴坐标排序，正序输出.
	 * 数据中所有点的X轴坐标均不相等，且点坐标为随机。）
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//生成5个点
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
		//对点进行排序
		Collections.sort(list,new Comparator<spot>() {

			public int compare(spot o1, spot o2) {
				// 根据x轴的值进行排序
				if(o1.getX()>o2.getX()){
					return 1;
				}
				return -1;
			}
		});
		System.out.println(list);
		//根据相邻的两个点求最大的斜率
		for(int i=0;i<4;i++){
			spot dian = (spot)list.get(i);
			spot dian1 = (spot)list.get(i+1);
			double res = (dian1.getY()-dian.getY())/(dian1.getX()-dian.getX());
			if(res>max){
				max=res;
			}
		}
		System.out.println("最大斜率为"+max);
	}
}


