public class BinarySearchST<Key extends Comparable<Key>,Value>{//二分查找有序符号表
	private Key[] keys;//键
	private Value[] values;//值
	private int N;//元素个数
	public BinarySearchST(int capacity){//假设容量是足够的
		N=0;
		keys=(Key [])new Comparable[capacity];
		values=(value [])new Object[capacity];
	}
	private int size(){
		return N;
	}
	private boolean isEmpty(){
		return N==0;
	}
	public int rank(Key key){//找到键所在的位置
		int low=0;
		int hei=N-1;
		while(low<=hei){
			int mid=(low+hei)/2;
			int cmp=keys[mid].compareTo(key);
			if(cmp<0){
				low=mid+1;
			}else if(cmp>0){
				hei=mid-1;
			}else{
				return mid;
			}
		}
		return low;//未找到该键，low是第一个比key键大的位置，即新建要插入的位置，当新建比所有键都大时，low=N
	}
	public Value get(Key key){//返回键的值
		int i=rank(key);
		if(keys[i].compareTo(key)==0){//符号表中有该键
			return values[i];
		}else{
			return null;
		}
	}
	public put(Key key,Value value){//查找键，找到则更新值，找不到则插入
		int i=rank(key);
		if(keys[i].compareTo(key)==0){//符号表中有这个键
			values[i]=value;//更新该键
		}else{//符号表没有该键，插入新建
			for(int j=N;j>i;j++){
				keys[j]=keys[j-1];
				values[j]=values[j-1];
			}
			keys[i]=key;
			values[i]=value;
		}
		N++;
	}
}