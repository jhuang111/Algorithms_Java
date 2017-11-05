package Sort;
import java.util.*;
public class Quick extends Example{
	public static void sort(Comparable []a){
		shuffle(a);
		sort(a,0,a.length-1);
	}
	public static void sort(Comparable []a,int left,int right){//数组包含左右边界
		if(right<=left) return;
		int j=partition(a,left,right);
		sort(a,left,j-1);
		sort(a,j+1,right);
	}
	public static int partition(Comparable[]a,int left,int right){//切分函数
		int j=left;//我们将第一个数作为比较大小的目标数字
		Comparable v=a[j];
		int low=left;//左指针
		int high=right+1;//右指针
		while(true){
			while(less(a[++low],v)){//找到左边第一个比目标数据大的				
				if(low>=right){//先比较大小，再对low进行操作
					break;
				}
				//low++;
			}
			while(less(v,a[--high])){//找到右边第一个比目标小的				
				if(left>=high){
					break;
				}
				//high--;
			}
			if(low>=high){//遍历结束,最后应该low与high一样大
				break;
			}
			exch(a,low,high);
		}
		exch(a,j,high);//将第一个放在合适的位置上
		return high;
	}
	public static void main(String[] args){
		String []a=readFromConsole();
		sort(a);
		if(isSorted(a)){
			show(a);
		}
		System.out.println("Quick END!");
	}
}
