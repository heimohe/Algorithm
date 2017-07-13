package com.test;

public class Linklistreverse {

	/**
	 * @param args
	 * ����������
	 */
	public static void main(String[] args) {
		//��������
		node list = generatelist();
		//��������
		node newlist = reverse(list);
		//������ĵ�һ��Ӧ��������ǰ�����һ��
		System.out.println(newlist.value);
	}

	private static node reverse(node list) {
		//�������Ϊ��,����ֻ��һ��Ԫ�ط���
		if(list == null || list.next == null ){
			return list;
		}
		// ��������
		node pre = null;	//ָ��ǰ�ڵ��ǰһ���ڵ�
		node cur = list ; 	//ָ��ǰ�ڵ�
		node next = list;	//ָ��ǰ�ڵ����һ���ڵ�
		while(cur!= null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	public static node generatelist() {
		//��������
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
