import java.util.*;
public class ChangedCapacityStack<Item>{
	private Item [] a;//数组
	private int N;//字符串的个数
	public ChangedCapacityStack(){//初始化,数组长度为1
		a=(Item [])new Object[1];
		N=0;
	}
	public ChangedCapacityStack(int cap){//初始化
		a=(Item [])new Object[cap];
		N=0;
	}
	public int size(){//返回字符串的个数
		return N;
	}
	public boolean isFull(){//判断栈是否满
		return N==a.length;
	}
	public void reSize(int newSize){//改变栈的大小
		Item [] temp=(Item[]) new Object[newSize];
		for(int i=0;i<N;i++){
			temp[i]=a[i];
		}
		a=temp;
	}
	public void push(Item str){//压栈，保存一个字符串
		a[N]=str;
		N++;
		if(isFull()){//栈满了，栈容量扩充一倍
			reSize(2*a.length);
		}
	}
	public boolean isEmpty(){//判断栈是否为空
		return N==0;
	}
	public Item pop(){//弹栈
		N--;
		Item temp=a[N];//提前保存要弹出的内容,否则可能出现输出NULL的情况。
		a[N]=NULL;//将删掉的元素置空，防止游离
		if(N!=0 && N==a.length/4){//数组内的元素个数等于数组长度的1/4时，栈容量减少一半
			reSize(a.length/2);
		}
		return temp;
	}
	public static void main(String [] args){
		ChangedCapacityStack<String> ss = new ChangedCapacityStack<String>();
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){//不断输入
			String temp=sc.nextLine();
			if(temp.equals("-")){//“-”表示弹栈
				if(ss.isEmpty()){//栈空了
					System.out.println("The stack is empty!");
					break;
				}else{
					System.out.print(ss.pop()+" ");//ss.pop();
				}
			}else{//压栈
				ss.push(temp);
			}
		}
		System.out.println("(Thres are "+ss.size()+" left on stack!)");
	}
}
