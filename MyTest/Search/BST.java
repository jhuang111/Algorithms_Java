import java.util.*;
public class BST<Key extends Comparable<Key>,Value>{
	private class Node{
		private int N;//以该节点为根节点树的节点总个数
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		public Node(Key k,Value v){
			key = k;
			value = v;
			left=null;
			right=null;
		}
	}
	private Node root;//根节点
	public void put(Key k,Value v){//更新或插入函数
		root=put(root,k,v);//对根节点进行更新
	}
	public Node put(Node node,Key k,Value v){//将节点插入以node为根的子树中
		if(node==null){//原树中不存在键为k的节点，新建此节点
			return new Node(k,v);
		}
		Key temp=node.key;
		if(temp.compareTo(k)>0){//当前节点的键值比k大，
			node.left=put(node.left,k,v);
		}else if(temp.compareTo(k)<0){//当前节点的键值比k小
			node.right=put(node.right,k,v);
		}else{//当前节点即为目标节点
			node.value=v;
		}
		return node;
	}
	public Value get(Key k){//获取键为k的值
		return get(root,k);
	}
	public Value get(Node node,Key k){
		if(node==null){
			return null;
		}
		Key temp=node.key;
		if(temp.compareTo(k)<0){//当前键的值小于k
			return get(node.right,k);
		}else if(temp.compareTo(k)>0){
			return get(node.left,k);
		}else{
			return node.value;
		}
	}
	public Key min(){//求树的最小键
		return min(root).key;
	}
	private Node min(Node node){
		if(node==null){
			return null;
		}
		if(node.left==null){
			return node;
		}
		return min(node.left);
	}
	public Key floor(Key k){//求树中小于等于k的最大值
		return floor(root,k).key;
	}
	private Node floor(Node node,Key k){
		if(node==null){
			return null;
		}
		int cmp=node.key.compareTo(k);
		if(cmp==0){//当前节点的键与所求键相同
			return node;
		}
		if(cmp>0){//当前节点的键比所求键大
			return floor(node.left,k);
		}
		Node t=floor(node.right,k);
		if(t==null){
			return node;
		}else{
			return t;
		}
	}
	public void show(){
        	System.out.println("Preorder traversal:");
		show(root);
	}
	
	public void show(Node node){
		if(node == null){
			return;
		}
		System.out.println("The Key is: "+node.key+", the value is: "+node.value);
		show(node.left);
		show(node.right);
	}
	public static void main(String [] args){
		BST bst=new BST<Character,Integer>();
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String s=sc.next();
			char c=s.charAt(0);
			int n=sc.nextInt();
			bst.put(c,n);
		}
		bst.show();
		System.out.println("The minimum of the tree is "+bst.min());
		System.out.println("The floor under 'M' is "+bst.floor('M'));
	}
}
