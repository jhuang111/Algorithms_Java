package Sort;
import java.util.*;
public class Shell extends Example{
	public static void sort(Comparable[] a){
		int i;
		int j;
		int h=0;
		int k;
		while(h<a.length/3){
			h=h*3+1;
		}
		while(h>0){//h不断减小，直到为0
			for(i=0;i<h;i++){//将h个数组分别进行排序
				for(j=i;j+h<a.length;j=j+h){//将密度为h的元素进行排序
					for(k=j+h;k<a.length;k=k+h){
						if(less(a[k],a[k-h])){
							exch(a,k,k-h);//如果a[k]<a[k-h]，将这两个值进行交换
						}
					}				
				}
			}
			h=h/3;
		}
	}
	public static void main(String [] args){
		String[] a=readFromConsole();
		sort(a);
		if(isSorted(a)){
			show(a);
		}
		System.out.println("END!");
	}
}
