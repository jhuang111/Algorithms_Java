package Sort;
import java.util.*;
public class Merge extends Example{
	private static  Comparable [] temp;
	public Merge(){
		
	}
	public static  void merge(Comparable[]a,int left,int mid,int right){
		for(int i=left;i<=right;i++){
			temp[i]=a[i];
		}
		int i=left;
		int j=mid+1;
		for(int k=left;k<=right;k++){
				if(i>mid){//左边一半遍历完
					a[k]=temp[j];
					j++;
				}	
				else if(j>right){//右边一半遍历完
					a[k]=temp[i];
					i++;
				}
				else if(less(temp[i],temp[j])){//左元素小于右元素
					a[k]=temp[i];
					i++;
				}else{//右元素小于左元素
					a[k]=temp[j];
					j++;
				}
		}
	}
	public static void sort(Comparable []a){
		temp= new Comparable[a.length];//将数组构建在递归外部，一次性分配空间
		sort(a,0,a.length-1);
	}
	public static void sort(Comparable[]a,int left,int right){
		if(right<=left)
			return;
		int mid=(left+right)/2;
		sort(a,left,mid);
		sort(a,mid+1,right);
		merge(a,left,mid,right);
	}
	public static void main(String[] args){
		String []a=readFromConsole();
		sort(a);
		if(isSorted(a)){
			show(a);
		}
//		System.out.println("Merge END!");
	}
}
