import java.util.*;
public class Queue<Item> implements Iterable<Item>{
	private class Node{
		private Item item;
		private Node next;
	}
	private Node front;
	private Node tail;
	public Queue(){
		front=null;
		tail=null;
	}
	public boolean isEmpty(){
		return front==null;
	}
	public void push(Item ite){
		Node temp=new Node();
		temp.item=ite;
		temp.next=front;
		if(tail==null){
			tail=temp;
		}
		front=temp;
	}
	public Item pop(){
		Node temp;
		temp=front;
		if(front==tail){//There is only one node
			Item result=temp.item;
			front=null;
			tail=null;
			return result;
		}
		while(temp.next!=tail){
			temp=temp.next;
		}
		Item result=tail.item;
		tail=temp;
		tail.next=null;
		return result;
	}
	public Iterator<Item> iterator(){
		return new listIterator();
	}
	private class listIterator implements Iterator<Item>{
		public boolean hasNext(){
			return !isEmpty();
		}
		public Item next(){
			return pop();
		}
		public void remove(){
			
		}
	}
	public static void main(String [] args){
		Queue<String> queue=new Queue<String>();
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			queue.push(sc.nextLine());
		}
		for(String s:queue){
			System.out.println(s);
		}
	}
}
