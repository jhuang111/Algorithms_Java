package Sort;
import java.util.*;
public class MergeBT extends Example{
	private static  Comparable [] temp;
	public MergeBT(){
		
	}
	public static  void MergeBT(Comparable[]a,int left,int mid,int right){
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
		for(int size=1;size<a.length;size+=size){//子数组大小，每次是上一个的2倍
			for(int i=0;i<a.length-size;i=i+2*size){//i是每个数组的第一个元素
				MergeBT(a,i,i+size-1,Math.min(i+2*size-1, a.length-1));
			}
			
		}
	}
	public static void main(String[] args){
		String []a=readFromConsole();
		sort(a);
		if(isSorted(a)){
			show(a);
		}
		System.out.println("MergeBT END!");
	}
}
