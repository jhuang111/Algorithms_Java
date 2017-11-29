import java.util.*;
public class BST<Key extends Comparable<Key>,Value>{
	private class Node{
		private int N;//以该节点为根节点树的节点总个数
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		public Node(Key k,Value v,int n){
			N=n;
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
	public Node put(Node node,Key k,Value v){//将节点插入以node为根的子树中,注意N的更新
		if(node==null){//原树中不存在键为k的节点，新建此节点
			return new Node(k,v,1);
		}
		Key temp=node.key;
		if(temp.compareTo(k)>0){//当前节点的键值比k大，
			node.left=put(node.left,k,v);
		}else if(temp.compareTo(k)<0){//当前节点的键值比k小
			node.right=put(node.right,k,v);
		}else{//当前节点即为目标节点
			node.value=v;
		}
		node.N=size(node.left)+size(node.right)+1;//对节点的N进行更新
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
	public int size(Node node){
		if(node == null){
			return 0;
		}else{
			return node.N;
		}
	}
	public Key select(int n){//返回树中第n小的键
		return select(root,n).key;
	}
	private Node select(Node node,int n){//返回以node为节点的第n小的节点
		if(node==null){
			return null;
		}
		int size=size(node.left);
		if(size<n){//当前树以左儿子为根的节点数小于n
			return select(node.right,n-size-1);
		}else if(size>n){
			return select(node.left,n);
		}else{
			return node;
		}
	}
	public int rank(Key k){//k的排名
		return rank(root,k);
	}
	private int rank(Node node,Key k){
		if(node==null){
			return 0;//不存在该键
		}
		int cmp=node.key.compareTo(k);
		if(cmp<0){
			return rank(node.right,k)+1+size(node.left);
		}else if(cmp>0){
			return rank(node.left,k);
		}else{
			return size(node);
		}
	}
	public void deleteMin(){
		deleteMin(root);
	}
	private Node deleteMin(Node node){
		if(node.left==null){
			return node.right;//最小节点自动删除，父节点左指针指向右子树
		}
		node.left=deleteMin(node.left);
		node.N=size(node.left)+size(node.right)+1;//从后向前，经过的路径依次修改
		return node;
	}
	public void delete(Key k){
		delete(root,k);
	}
	private Node delete(Node node,Key k){
		if(node==null){
			return null;
		}
		int cmp=node.key.compareTo(k);
		if(cmp<0){
			node.right=delete(node.right,k);
		}else if(cmp>0){
			node.left=delete(node.left,k);
		}else{
			if(node.left==null){
				return node.right;
			}
			if(node.right==null){
				return node.left;
			}
			Node t=node;
			node=min(t.right);
			node.right=deleteMin(t.right);
			node.left=t.left;
		}
		node.N=size(node.left)+size(node.right)+1;
		return node;
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
		System.out.println("The floor under 'N' is "+bst.floor('N'));
		System.out.println(bst.select(1)+" is larger than 1 nodes");
		System.out.println(bst.select(2)+" is larger than 2 nodes");
		System.out.println(bst.select(3)+" is larger than 3 nodes");
		System.out.println("D is larger than "+bst.rank('D')+" nodes");
		bst.delete('E');
		bst.show();
	}
}
