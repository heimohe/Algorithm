package com.test;

import java.util.Stack;

import com.sun.org.apache.xalan.internal.xsltc.compiler.NodeTest;

public class BinaryTree {

	private treenode root = null;
	public  BinaryTree() {
		root = new treenode(1, "rootnode(A)");
	}
	
	/*
	 * ����һ�Ŷ�����
	 *   		A 
     *     B          C 
     *  D     E            F 
	 * */
	public void createbintree(treenode root){
		treenode newnodeB = new treenode(2,"B");
		treenode newnodeC = new treenode(3,"C");
		treenode newnodeD = new treenode(4,"D");
		treenode newnodeE = new treenode(5,"E");
		treenode newnodeF = new treenode(6,"F");
		root.leftchild = newnodeB;
		root.rightchild = newnodeC;
		root.leftchild.leftchild = newnodeD;
		root.leftchild.rightchild = newnodeE;
		root.rightchild.rightchild = newnodeF;
	}
	
	public treenode isempty() {
		return root = null ;
	}
	/*
	 * �����ĸ߶�
	 * */
	public int height() {
		return height(root);
	}
	/*
	 * ��ڵ����
	 * */
	public int size() {
		return size(root);
	}
	
	private int size(treenode subtree) {
		if(subtree == null){
			return 0;
		}else{
			return 1+size(subtree.leftchild)+size(subtree.rightchild);
		}
	}

	private int height(treenode subtree) {
		if(subtree == null)	{
			return 0;
		}else{
			int i = height(subtree.leftchild);
			int j = height(subtree.rightchild);
			return (i<j)?(j+1):(i+1);
		}
		
	}
	
	/*
	 * ����˫�׽ڵ�
	 * */
	public treenode parent(treenode element){
		return  (treenode) ((root == null || root == element) ? null: parent(root,element));
	}
	

	private treenode parent(treenode subtree, treenode element) {
		if(subtree == null){
			return null;
		}
		if(subtree.leftchild == element || subtree.rightchild == element){
			//���ظ��ڵ�
			return  element;
		}
		treenode p ;
		//�������������ң����������û�У���������������
		if((p=parent(subtree.leftchild,element)) != null){
			//�ݹ�����������
			return p;
		}else{
			//�ݹ�����������
			return parent(subtree.rightchild, element);
		}
	}
	
	public treenode getleftchildnode(treenode element){
		return (element!=null)?element.leftchild:null;
	}
	
	public treenode getrightchildnode(treenode element) {
		return (element!=null)?element.rightchild:null;
	}
	
	public treenode getroot() {
		return root;
	}
	
	//���ͷ�ĳ���ڵ�ʱ���ýڵ�������������Ѿ��ͷ��ˣ�
	//����Ӧ�ò��ú��������������ĳ���ڵ�ʱ�ýڵ�Ĵ洢�ռ��ͷ�
	public void  destroy(treenode subtree){
		//ɾ����Ϊsubtree������
		if(subtree != null){
			//ɾ��������
			destroy(subtree.leftchild);
			//ɾ��������
			destroy(subtree.rightchild);
			//ɾ�����ڵ�
			subtree = null;
		}
	}
	
	public void traverse(treenode subtree){
		System.out.println("key---:"+subtree.key+"value---:"+subtree.data);
		traverse(subtree.leftchild);
		traverse(subtree.rightchild);
	}

	/*
	 * ǰ�����
	 * */
	public void preorder(treenode subtree){
		if(subtree != null){
			visited(subtree);
			preorder(subtree.leftchild);
			preorder(subtree.rightchild);
		}
	}
	
	/*
	 * �������
	 * */
	public void inorder(treenode subtree){
		if(subtree != null){
			inorder(subtree.leftchild);
			visited(subtree);
			inorder(subtree.rightchild);
		}
	}
	
	/*
	 * �������
	 * */
	public void postorder(treenode subtree){
		if(subtree != null){
			postorder(subtree.leftchild);
			postorder(subtree.rightchild);
			visited(subtree);
		}
	}
	
	/*
	 * ǰ������ķǵݹ����
	 * */
	public void nonrecpreorder(treenode p){
		Stack<treenode> stack = new Stack<treenode>();
		treenode node = p;
		while(node != null || stack.size()> 0){
			while(node != null){
				visited(node);
				stack.push(node);
				node = node.leftchild;
			}
			node = stack.pop();
			node = node.rightchild;
		}
	}
	
	/*
	 * ��������ķǵݹ����
	 * */
	public void nonrecinorder(treenode p) {
		Stack<treenode> stack = new Stack<treenode>();
		treenode node = p;
		while(node != null || stack.size() > 0){
			//��������
			while(node != null){
				stack.push(node);
				node = node.leftchild;
			}
			//ջ�ǿ�
			if(stack.size() > 0){
				node = stack.pop();
				visited(node);
				node = node.rightchild;
			}
		}
	}
	
	//��������ķǵݹ�ʵ��
	public void nonrecpostorder(treenode p){
		Stack<treenode> stack = new Stack<treenode>();
		treenode node = p;
		while(p != null){
			//��������ջ
			for(;p.leftchild != null;p=p.leftchild){
				stack.push(p);
			}
			//��ǰ�ڵ������������������Ѿ����
			while(p != null && ( p.rightchild == null || p.rightchild == node)){
				visited(p);
				//��¼��һ���Ѿ�����ڵ�
				node = p;
				if(stack.empty()){
					return ;
				}
				p = stack.pop();
			}
			//����������
			stack.push(p);
			p = p.rightchild;
		}
	}
	
	private void visited(treenode subtree) {
		subtree.isvisited = true;
		System.out.println("key---:"+subtree.key+"value---:"+subtree.data);
	}


	/*
	 * �������ڵ����ݽṹ
	 * */
	class treenode{
		private int key = 0;
		private String data =null;
		private boolean isvisited = false;
		private treenode leftchild;
		private treenode rightchild;
		
		public treenode() {}
		
		public treenode(int key,String data) {
			this.key = key;
			this.data = data;
			this.leftchild = null;
			this.rightchild = null;
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createbintree(bt.root);
		System.out.println("the size of the tree is "+bt.size());
		System.out.println("the height of the tree is "+bt.height());
		
		System.out.println("********ǰ�������ABDECF��********");
		bt.preorder(bt.root);
		
		System.out.println("********���������DBEACF��*********");
		bt.inorder(bt.root);
		
		System.out.println("*********���������DEBFCA��*********");
		bt.postorder(bt.root);
		
		System.out.println("*************�ǵݹ� ǰ��ABDECF��**************");
		bt.nonrecpreorder(bt.root);
		
		System.out.println("***************�ǵݹ� ����DBEACF��****************");
		bt.nonrecinorder(bt.root);
		
		System.out.println("**************�ǵݹ� ����DEBFCA��***************");
		bt.nonrecpostorder(bt.root);
	}

}


