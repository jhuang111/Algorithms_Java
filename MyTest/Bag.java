import java.util.*;
public class Bag <Item> implements Iterable<Item>{
	private Node front;//the front of the point
	private class Node{
		Item item;
		Node next;
	}
	public Bag(){
		front=null;
	}
	public boolean isEmpty(){
		return front==null;
	}
	public void add(Item ite){//add a new node
		Node temp=new Node();
		temp.item=ite;
		temp.next=front;
		front=temp;//the front node moves to first
	}
	public Iterator<Item> iterator(){
		return new listIterator();//嵌套类实现迭代器
	}
	private class listIterator implements Iterator<Item>{
		private Node current;
		public listIterator(){
			current=front;//用current来保存front节点，以防止front被修改。
		}
		public boolean hasNext(){//迭代器主要函数
			return current!=null;
		}
		public Item next(){//迭代器主要函数
			Item result=current.item;
			current=current.next;
			return result;
		}
		public void remove(){//迭代器次要函数
			
		}
	}
	public static void main(String [] args){
		Bag<String> bag=new Bag<String>();
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String temp=sc.nextLine();
			System.out.print("test:");
			System.out.println(temp);
			bag.add(temp);
		}
		for(String s:bag){
			System.out.print("result:");
			System.out.println(s);
		}
		
	}
}
