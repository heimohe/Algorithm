package com.test;

public class Linklistreverse {

	/**
	 * @param args
	 * 单链表逆置
	 */
	public static void main(String[] args) {
		//生成链表
		node list = generatelist();
		//链表逆置
		node newlist = reverse(list);
		//新链表的第一个应该是逆置前的最后一个
		System.out.println(newlist.value);
	}

	private static node reverse(node list) {
		//如果链表为空,或者只有一个元素返回
		if(list == null || list.next == null ){
			return list;
		}
		// 链表逆置
		node pre = null;	//指向当前节点的前一个节点
		node cur = list ; 	//指向当前节点
		node next = list;	//指向当前节点的下一个节点
		while(cur!= null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	public static node generatelist() {
		//生成链表
		node n1 = new node(1,"a");
		node n2 = new node(2,"b");
		node n3 = new node(3,"c");
		node n4 = new node(4,"d");
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		return n1;
	}

}

class node{
	int key;
	String value;
	node next;
	public node(int key,String value){
		this.key = key;
		this.value = value;
	}
}
