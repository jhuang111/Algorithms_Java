import java.util.*;
public class FixedCapacityStackOfStrings{
	private String [] a;//数组
	private int N;//字符串的个数
	public FixedCapacityStackOfStrings(int cap){//初始化
		a=new String[cap];
		N=0;
	}
	public int size(){//返回字符串的个数
		return N;
	}
	public boolean isFull(){//判断栈是否满
		return N==a.length;
	}
	public void push(String str){//压栈，保存一个字符串
		a[N]=str;
		N++;
	}
	public boolean isEmpty(){//判断栈是否为空
		return N==0;
	}
	public String pop(){//弹栈
		N--;
		return a[N];
	}
	public static void main(String [] args){
		FixedCapacityStackOfStrings ss = new FixedCapacityStackOfStrings(100);
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
