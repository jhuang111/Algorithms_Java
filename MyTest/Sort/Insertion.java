package Sort;
import java.util.*;
public class Insertion extends Example{
	public static void sort(Comparable[] a){
		int i=1;
		int j;
		for(;i<a.length;i++){
			j=i-1;	
			while(j>=0 && less(a[j+1],a[j])){
				exch(a,j+1,j);
				j--;
			}
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
