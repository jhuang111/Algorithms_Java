import java.util.*;
public class RedBlackBST<Key extends Comparable<Key>,Value>{
	private Node root;
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	private class Node{
		Key key;
		Value value;
		Node left;
		Node right;
		int N;
		boolean color;
		public Node(Key k,Value v,int n,boolean c){
			key=k;
			value=v;
			N=n;
			color=c;
		}
	}
	public boolean isRed(Node node){
		if(node==null){
			return false;
		}
		return node.color==RED;
	}
	private int size(){
		return size(root);
	}
	public int size(Node node){
		if(node==null){
			return 0;
		}
		return node.N;
	}
	public Node rotateLeft(Node node){//左旋转,改变两个节点的左右指针，颜色，以及节点数
		Node nodeRight=node.right;
		node.right=nodeRight.left;
		nodeRight.left=node;
		nodeRight.color=node.color;
		node.color=RED;
		nodeRight.N=node.N;
		node.N=size(node.left)+size(node.right)+1;
		return nodeRight;
	}
	public Node rotateRight(Node node){//右旋转，改变两个节点的左右指针，颜色以及节点数
		Node nodeLeft=node.left;
		node.left=nodeLeft.right;
		nodeLeft.right=node;
		nodeLeft.color=node.color;
		node.color=RED;
		nodeLeft.N=node.N;
		node.N=size(node.left)+size(node.right)+1;
		return nodeLeft;
	}
	public void flipColor(Node node){//改变两个子节点的颜色
		node.color=RED;
		node.left.color=BLACK;
		node.right.color=BLACK;
	}
	public void put(Key k,Value v){
		root=put(root,k,v);
		root.color=BLACK;
	}
	public void show(){
        System.out.println("Preorder traversal:");
		show(root);
	}
	public void show(Node node){
		if(node == null){
			return;
		}
		if(node.color==BLACK){
			System.out.println("The Key is: "+node.key+", the value is: "+node.value);
			if(isRed(node.left)){
				System.out.println("The Key is: "+node.left.key+", the value is: "+node.left.value);
			}
		}
		show(node.left);
		show(node.right);
	}
	public Node put(Node node,Key k,Value v){
		if(node==null){
			return new Node(k,v,1,RED);//新生节点与父节点以红边相连
		}
		int cmp=node.key.compareTo(k);
		if(cmp>0){//目标节点在左子树中
			node.left=put(node.left,k,v);
		}else if(cmp<0){//目标节点在右子树中
			node.right=put(node.right,k,v);
		}else{
			node.value=v;
		}
		if(isRed(node.right) && !isRed(node.left)){//左节点为黑，右节点为红
			node=rotateLeft(node);
		}
		if(isRed(node.left) && isRed(node.left.left)){//左节点为红，左节点的左节点为红
			node=rotateRight(node);
		}
		if(isRed(node.left) && isRed(node.right)){//左节点为红，右节点为红
			flipColor(node);
		}
		node.N=size(node.left)+size(node.right)+1;
		return node;
	}
	public static void main(String [] args){
		RedBlackBST bst=new RedBlackBST<Character,Integer>();
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String s=sc.next();
			char c=s.charAt(0);
			int n=sc.nextInt();
			bst.put(c,n);
		}
		bst.show();
	}
}
