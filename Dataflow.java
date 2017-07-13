package com.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dataflow {

	/**
	 * @author wyl
	 * 51nod�����������û�����ȼ�⹤�ߣ�ʹ�ø߼��˹������㷨��
	 * ͨ���û�����ʱ�䡢���켣�����������û�������վ������̶ȡ�
	 * ���е�ͳ�ƹ���ֻ��ͳ��ĳһ�������У��û�������̶ȵľ�ֵ��
	 * �п���ү������Ϊͳ�ƹ������һ����feature������ͳ�ƾ�ֵ��ͬʱ��
	 * ���㴰��������̶ȵı�׼�����λ������ֵ��Ҫ����ȡ������
	 */
	public static void main(String[] args) {
		Dataflow node = new Dataflow();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); //��������
		int k = scan.nextInt();	//������Ŀ
		Queue<Integer> queue = new LinkedList<Integer>(); //queue�������������
		LinkedList<Integer> list = new LinkedList<Integer>(); //linkedlist�������������򣬷��������λ���Ļ�ȡ
		int sum = 0;
		int numNOW = 0 ;//��ǰ����������ȸ���
		for(int i=0;i<n;i++){
			System.out.println("�����������: 1 �û����� 	2 ��ѯ��ֵ	3 ��ѯ����	4 ��ѯ��λ��");
			int operation  = scan.nextInt();
			switch (operation) {
			case 1:
				System.out.println("���������ֵ");
				int satisfy = scan.nextInt();
				sum += satisfy;
				numNOW++;
				if(queue.size() < k){
					queue.offer(satisfy);
					node.insertToList(list,satisfy);
					
				}else{
					//��������������ˣ��ͻ���ָ��ǣ���Ϊ��ֻ����������Σ����ݴ�����Ŀ�������ķ��������
					int removedvalue = queue.poll();	//�Ƴ������ض���ͷ����Ԫ��
					numNOW--;	//����ȴ�������һ
					sum -= removedvalue;	//�ܺͼ�ȥ�Ƴ���ͷ��Ԫ��ֵ
					list.remove(Integer.valueOf(removedvalue));	//��Ϊ�б�������ģ������Ƴ����ֵ
					queue.offer(satisfy);	//Ȼ�� �Ѹոս����������ֵ��ӽ�����β��
					node.insertToList(list, satisfy);	//����������ֵ�ŵ��б�ָ��λ�ã��ҵ� ����λ���������
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
