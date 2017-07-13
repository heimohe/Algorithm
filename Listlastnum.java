package com.test;

public class Listlastnum {

	/**
	 * @param args
	 * 题目：输入带头结点的单链表L，输出该单链表中倒数第k个结点。
	 * 	        单链表的倒数第0个结点为该单链表的尾指针。要求只能遍历一次单链表。
	 */
	public static void main(String[] args) {
		//生成链表
		node list = generatelist();
		int k = 0;	//查找倒数第k个节点
		node n = findlastnode(list,k);
		System.out.println("倒数第"+k+"个节点值为"+n.value);

	}
	
	private static node findlastnode(node list, int k) {
		node p = list;
		node q = list;
		if(k<0){
			System.out.println("链表太短");
		}
		if(list == null ){
			System.out.println("链表为空");
		}
		while(k>0){
			p = p.next;
			k--;
			if(p == null ){
				System.out.println("链表太短不存在倒数第"+k+"个节点");
			}
		}
		System.out.println(p.value);
		while(p.next != null){
			p = p.next;
			q = q.next;
		}
		return q;
	}

	public static node generatelist() {
		//生成链表
		node n1 = new node(1,"a");
		node n2 = new node(2,"b");
		node n3 = new node(3,"c");
		node n4 = new node(4,"d");
		node n5 = new node(5,"e");
		node n6 = new node(6,"f");
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		return n1;
	}

}

class node1{
	int key;
	String value;
	node next;
	public node1(int key,String value){
		this.key = key;
		this.value = value;
	}
}
