package Sort;
import java.util.*;
public class Selection extends Example{
	public static void sort(Comparable[] a){
		int i=0;
		int j=0;
		for(;i<a.length-1;i++){
			for(j=i;j<a.length;j++){
				if(less(a[j],a[i])){
					exch(a,i,j);
				}
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
