package com.test;

public class Listlastnum {

	/**
	 * @param args
	 * ��Ŀ�������ͷ���ĵ�����L������õ������е�����k����㡣
	 * 	        ������ĵ�����0�����Ϊ�õ������βָ�롣Ҫ��ֻ�ܱ���һ�ε�����
	 */
	public static void main(String[] args) {
		//��������
		node list = generatelist();
		int k = 0;	//���ҵ�����k���ڵ�
		node n = findlastnode(list,k);
		System.out.println("������"+k+"���ڵ�ֵΪ"+n.value);

	}
	
	private static node findlastnode(node list, int k) {
		node p = list;
		node q = list;
		if(k<0){
			System.out.println("����̫��");
		}
		if(list == null ){
			System.out.println("����Ϊ��");
		}
		while(k>0){
			p = p.next;
			k--;
			if(p == null ){
				System.out.println("����̫�̲����ڵ�����"+k+"���ڵ�");
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
		//��������
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
