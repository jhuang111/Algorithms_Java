package Sort;
import java.util.*;
public class Example{
	public static void sort(Comparable[] a){
		
	}
	protected static boolean less(Comparable v,Comparable w){//if v<w?
		return v.compareTo(w)<0;
	}
	protected static void exch(Comparable[]a,int i,int j){//exchage a[i] and a[j]
		Comparable temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	protected static boolean isSorted(Comparable []a){
		int i=1;
		while(i<a.length){
			if(less(a[i],a[i-1])){
				return false;
			
			}
			i++;
		}
		return true;
	}
	protected static void show(Comparable[]a){
		int i=0;
		while(i<a.length){
			System.out.print(a[i]+" ");
			i++;
		}
		System.out.println();
	}
	public static String [] readFromConsole(){
		Scanner sc=new Scanner(System.in);
		String result="";
		String sepator=java.util.UUID.randomUUID().toString();
		while(sc.hasNext()){
			String temp=sc.nextLine();
			result+=temp+sepator;
		}
		return result.split(sepator);
	}
}
