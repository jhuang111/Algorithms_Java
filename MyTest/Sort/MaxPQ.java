//假设已知数据量大小，所以可以用数组对数据进行保存。
public class MaxPQ<Key extends Comparable<Key>>{//Key extends Comparable<Key>是什么意思？？？为什么要key继承comparable类型，而不是使用范型？？？
	private Key [] pq;//保存数据的数组
	private int N;//数据量大小而非数组大小
	public MaxPQ(int MaxN){//初始化，我们默认所有数据的大小小于maxN
		pq=(Key [])new Comparable[MaxN];//java没有范型数组，只能先创建Comparable类型的数组，再进行类型转换。
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public boolean less(int i,int j){//判断下标为i与下标为j的元素的大小关系
		return pq[i].compareTo(pq[j])<0;
	}
	public void exch(int i,int j){//将下标为i与下标为j的元素进行交换
		Key t=pq[i];
		pq[i]=pq[j];
		pq[j]=t;
	}
	public void swim(int k){//上浮,比较k与k/2，两者大的作父节点
		if(k/2>0 && less(k/2,k)){
			exch(k/2,k);
			swim(k/2);
		}
	}
	public void sink(int k){//下沉,比较k与2*k和2*k+1,三者最大的作父节点
		int j=2*k;
		if(j<N && less(j,j+1)){//先将2*k与2*k+1进行比较，大的为j
			j++;
		}
		if(j>N || less(j,k)){//j溢出数组或者j指向的值没有k指向的值大程序结束。
			return;
		}
		exch(j,k);//交换j与k的值
		sink(j);//继续下沉以保持堆有序
	}
	public void insert(Key key){//插入新值
		N++;//数组N=0不存放数据
		pq[N]=key;//插到最后
		swim(N);//上浮到合适的位置以保持数组堆有序
	}
	public Key delMax(){//返回最大值
		Key result=pq[1];//根节点即为所求
		exch(1,N);//将最后一个节点交换到根节点
		N--;//数据量减1，即删除最后一个元素
		sink(1);//保持数组堆有序
		return result;
	}
	
	public static void main(String [] args){
		MaxPQ test=new MaxPQ(10);
		test.insert(5);
		test.insert(3);
		test.insert(8);
		test.insert(9);
		test.insert(5);
		test.insert(1);
		test.insert(6);
		test.insert(4);
		test.insert(3);
		System.out.println(test.delMax());
		System.out.println(test.delMax());
		System.out.println(test.delMax());
		System.out.println(test.delMax());
		System.out.println(test.delMax());
		System.out.println(test.delMax());
	}
}
