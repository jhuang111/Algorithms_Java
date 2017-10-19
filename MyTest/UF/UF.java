import java.lang.*;
import java.util.Scanner;
import java.io.*;
public class UF{
	private int [] id;
	private int num;//点数
	private int count;//分量数
	private int [] heigh;
	public UF(int temp){
		num=temp;
		count=temp;
		id=new int[num];
		heigh=new int[num];
		for(int i=0;i<num;i++){
			id[i]=i;
			heigh[i]=1;
		}
	}
	public boolean connected(int p,int q){//判断两个点是否相连
		if(p<0 || p>=num || q<0 || q>=num){
			return false;
		}
		return id[p]==id[q];
	}
	public void union(int p,int q){
		if(p<0 || p>=num || q<0 || q>=num){
			return;
		}
		int temp=id[q];
		for(int i=0;i<num;i++){
			if(id[i]==temp){
				id[i]=id[p];
			}
		}
	}
	public static void f1(){//第一种方法
		long start=System.nanoTime();
		Scanner sc=new Scanner(System.in);
		int temp=sc.nextInt();//输入点数
		UF uf=new UF(temp);
		int N=sc.nextInt();//输入边数
		for(int i=0;i<N;i++){
			int p=sc.nextInt();
			int q=sc.nextInt();
			if(!uf.connected(p,q)){//两个点不相连
				uf.count--;
				uf.union(p,q);
			}
		}
		System.out.println(uf.count+"components");
		long end=System.nanoTime();
		System.out.println("Function 1 运行时间为"+(end-start)+"ns");
		
	}
	public int root(int n){
		if(id[n]==n)
			return n;
		else{
			return this.root(id[n]);
		}
	}
	public boolean connected2(int p, int q){
		return this.root(p)==this.root(q);
	}
	public void union2(int p,int q){
		int proot=root(p);
		int qroot=root(q);
		if(heigh[proot]<heigh[qroot]){
			id[p]=qroot;
			id[proot]=qroot;
			heigh[qroot]++;
		}else{
			id[q]=proot;
			id[qroot]=proot;
			heigh[proot]++;
		}
	}
	public static void f2(){
		long start=System.nanoTime();
		Scanner sc=new Scanner(System.in);
		int temp=sc.nextInt();//输入点数
		UF uf=new UF(temp);
		int N=sc.nextInt();//输入边数
		for(int i=0;i<N;i++){
			int p=sc.nextInt();
			int q=sc.nextInt();
			if(!uf.connected2(p,q)){//两个点不相连
				uf.count--;
				uf.union2(p,q);
			}
		}
		System.out.println(uf.count+"components");
		long end=System.nanoTime();
		System.out.println("Function 2 运行时间为"+(end-start)+"ns");
	}
	public static void main(String [] args){
		f2();
	}	
}
