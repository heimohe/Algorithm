package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Throwplate {

	/**
	 * @author wyl
	 * 有一口井，井的高度为N，每隔1个单位它的宽度有变化。
	 * 现在从井口往下面扔圆盘，如果圆盘的宽度大于井在某个高度的宽度，
	 * 则圆盘被卡住（恰好等于的话会下去）。
	 * 盘子有几种命运：1、掉到井底。2、被卡住。3、落到别的盘子上方。
	 * 盘子的高度也是单位高度。给定井的宽度和每个盘子的宽度，
	 * 求最终落到井内的盘子数量。
	 * 如图井和盘子信息如下：
		井：5 6 4 3 6 2 3
		盘子：2 3 5 2 4
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		//生成井
		int tmp=0;
		int sum=0;
		int M=7;	//井的層數為M
		int N=5;	//盤子的個數為N
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<M;i++){
			tmp=sc.nextInt();
			//做下預處理，因爲井的下面肯定比上面部分小
			if(i==0){
				list.add(tmp);
			}else{
				list.add(Math.min(tmp, list.get(i-1)));
			}
			
		}
		System.out.println(list);
		
		for(int j=1;j<=N;j++){
			//輸入盤子寬度
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
