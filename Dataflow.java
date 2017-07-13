package com.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dataflow {

	/**
	 * @author wyl
	 * 51nod近日上线了用户满意度检测工具，使用高级人工智能算法，
	 * 通过用户访问时间、鼠标轨迹等特征计算用户对于网站的满意程度。
	 * 现有的统计工具只能统计某一个窗口中，用户的满意程度的均值。
	 * 夹克老爷想让你为统计工具添加一个新feature，即在统计均值的同时，
	 * 计算窗口中满意程度的标准差和中位数（均值需要向下取整）。
	 */
	public static void main(String[] args) {
		Dataflow node = new Dataflow();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); //操作次数
		int k = scan.nextInt();	//窗口数目
		Queue<Integer> queue = new LinkedList<Integer>(); //queue用来控制满意度
		LinkedList<Integer> list = new LinkedList<Integer>(); //linkedlist则用来插入排序，方便进行中位数的获取
		int sum = 0;
		int numNOW = 0 ;//当前窗口内满意度个数
		for(int i=0;i<n;i++){
			System.out.println("输入操作类型: 1 用户访问 	2 查询均值	3 查询方差	4 查询中位数");
			int operation  = scan.nextInt();
			switch (operation) {
			case 1:
				System.out.println("输入满意度值");
				int satisfy = scan.nextInt();
				sum += satisfy;
				numNOW++;
				if(queue.size() < k){
					queue.offer(satisfy);
					node.insertToList(list,satisfy);
					
				}else{
					//这里如果队列满了，就会出现覆盖，因为它只保留最近三次（根据窗口数目来定）的访问满意度
					int removedvalue = queue.poll();	//移除并返回队列头部的元素
					numNOW--;	//满意度窗口数减一
					sum -= removedvalue;	//总和减去移除队头的元素值
					list.remove(Integer.valueOf(removedvalue));	//因为列表是有序的，所以移除这个值
					queue.offer(satisfy);	//然后 把刚刚进来的满意度值添加进队列尾部
					node.insertToList(list, satisfy);	//把这个满意度值放到列表指定位置，找到 它的位置排序插入
				}
				System.out.println(queue+" ..."+list);
				break;
				
			case 2:
				double average = Math.floor((double)sum/numNOW);
				System.out.println(average);
			default:
				break;
			}
		}
	}

	private void insertToList(LinkedList<Integer> list, int satisfy) {
		Iterator<Integer> it = list.iterator();
		int index = 0 ;
		while(it.hasNext()){
			int thenumber = it.next();
			if(thenumber > satisfy){
				break;
			}else{
				index++;
			}
		}
		list.add(index, satisfy);
	}

}
