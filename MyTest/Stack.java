import java.util.*;
public class Stack<Item> implements Iterable<Item>{
	private class Node{
		private Item item;
		private Node next;
	}
	private Node front;
	public Stack(){
		front=null;
	}
	public boolean isEmpty(){
		return front==null;//stack is empty if front is null;
	}
	public void push(Item ite){
		Node temp=new Node();
		temp.item=ite;
		temp.next=front;
		front=temp;
	}
	public Item pop(){
		Item result=front.item;
		front=front.next;
		return result;
	}
	public Iterator<Item> iterator(){
		return new listIterator();
	}
	private class listIterator implements Iterator{
		private Node current;
		public listIterator(){
			current=front;
		}
		public boolean hasNext(){
			return current!=null;//iterator has next if current != null
		}
		public Item next(){
			Item result=current.item;
			current=current.next;
			return result;
		}
		public void remove(){
			
		}
	}
	public static void main(String [] args){
		Stack<String> stack=new Stack<String>();
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			String temp=sc.nextLine();
			
			stack.push(temp);
		}
		for(String s:stack){
			System.out.println(s);
		}
	}
}
