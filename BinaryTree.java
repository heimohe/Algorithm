package com.test;

import java.util.Stack;

import com.sun.org.apache.xalan.internal.xsltc.compiler.NodeTest;

public class BinaryTree {

	private treenode root = null;
	public  BinaryTree() {
		root = new treenode(1, "rootnode(A)");
	}
	
	/*
	 * 创建一颗二叉树
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
	 * 求树的高度
	 * */
	public int height() {
		return height(root);
	}
	/*
	 * 求节点个数
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
	 * 返回双亲节点
	 * */
	public treenode parent(treenode element){
		return  (treenode) ((root == null || root == element) ? null: parent(root,element));
	}
	

	private treenode parent(treenode subtree, treenode element) {
		if(subtree == null){
			return null;
		}
		if(subtree.leftchild == element || subtree.rightchild == element){
			//返回父节点
			return  element;
		}
		treenode p ;
		//先在左子树中找，如果左子树没有，才在右子树中找
		if((p=parent(subtree.leftchild,element)) != null){
			//递归在左子树找
			return p;
		}else{
			//递归在右子树找
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
	
	//在释放某个节点时，该节点的左右子树都已经释放了，
	//所以应该采用后序遍历，当访问某个节点时该节点的存储空间释放
	public void  destroy(treenode subtree){
		//删除根为subtree的子树
		if(subtree != null){
			//删除左子树
			destroy(subtree.leftchild);
			//删除右子树
			destroy(subtree.rightchild);
			//删除根节点
			subtree = null;
		}
	}
	
	public void traverse(treenode subtree){
		System.out.println("key---:"+subtree.key+"value---:"+subtree.data);
		traverse(subtree.leftchild);
		traverse(subtree.rightchild);
	}

	/*
	 * 前序遍历
	 * */
	public void preorder(treenode subtree){
		if(subtree != null){
			visited(subtree);
			preorder(subtree.leftchild);
			preorder(subtree.rightchild);
		}
	}
	
	/*
	 * 中序遍历
	 * */
	public void inorder(treenode subtree){
		if(subtree != null){
			inorder(subtree.leftchild);
			visited(subtree);
			inorder(subtree.rightchild);
		}
	}
	
	/*
	 * 后序遍历
	 * */
	public void postorder(treenode subtree){
		if(subtree != null){
			postorder(subtree.leftchild);
			postorder(subtree.rightchild);
			visited(subtree);
		}
	}
	
	/*
	 * 前序遍历的非递归遍历
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
	 * 中序遍历的非递归遍历
	 * */
	public void nonrecinorder(treenode p) {
		Stack<treenode> stack = new Stack<treenode>();
		treenode node = p;
		while(node != null || stack.size() > 0){
			//存在子树
			while(node != null){
				stack.push(node);
				node = node.leftchild;
			}
			//栈非空
			if(stack.size() > 0){
				node = stack.pop();
				visited(node);
				node = node.rightchild;
			}
		}
	}
	
	//后序遍历的非递归实现
	public void nonrecpostorder(treenode p){
		Stack<treenode> stack = new Stack<treenode>();
		treenode node = p;
		while(p != null){
			//左子树入栈
			for(;p.leftchild != null;p=p.leftchild){
				stack.push(p);
			}
			//当前节点无右子树或右子树已经输出
			while(p != null && ( p.rightchild == null || p.rightchild == node)){
				visited(p);
				//记录上一个已经输出节点
				node = p;
				if(stack.empty()){
					return ;
				}
				p = stack.pop();
			}
			//处理右子树
			stack.push(p);
			p = p.rightchild;
		}
	}
	
	private void visited(treenode subtree) {
		subtree.isvisited = true;
		System.out.println("key---:"+subtree.key+"value---:"+subtree.data);
	}


	/*
	 * 二叉树节点数据结构
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
		
		System.out.println("********前序遍历【ABDECF】********");
		bt.preorder(bt.root);
		
		System.out.println("********中序遍历【DBEACF】*********");
		bt.inorder(bt.root);
		
		System.out.println("*********后序遍历【DEBFCA】*********");
		bt.postorder(bt.root);
		
		System.out.println("*************非递归 前序【ABDECF】**************");
		bt.nonrecpreorder(bt.root);
		
		System.out.println("***************非递归 中序【DBEACF】****************");
		bt.nonrecinorder(bt.root);
		
		System.out.println("**************非递归 后序【DEBFCA】***************");
		bt.nonrecpostorder(bt.root);
	}

}


