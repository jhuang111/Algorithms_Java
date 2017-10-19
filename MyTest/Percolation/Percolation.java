package Percolation;
import java.util.Scanner;
public class Percolation{
	private int [][] id;//每个点的根
	private int [][] heigh;//每个树的高度
	private int N;//n维
	private int MAX;//最大值
	private int numOpen;
	public Percolation(int n){
		numOpen=0;
		N=n;
		id=new int[N][N];
		heigh=new int[N][N];
		MAX=2147483647;
		for(int i=0;i<N;i++){//初始化
			for(int j=0;j<N;j++){
				id[i][j]=(i-1)*N+j;//所有点的根是自己
				heigh[i][j]=0;//树的高度为0,当这个点打开的时候高度变为1
			}
		}
	}
	public int root(int row,int col){//点的根
		int num1=(row-1)*N+col;
		int num2=id[row-1][col-1]
		if(num2!=num1){//一个点的id不等于它的位置时，这个点不是根。
			return root(num2/N+1,num2%N);
		}else{
			return num2;
		}
		
	}
	public int getHeigh(int n){
		if(n%N==0){
			return heigh[n/N-1][N];
		}else{
			return heigh[n/N][n%N];
		}

	}
	public void chHeigh(int n){
		if(n%N==0){
			heigh[n/N-1][N]++;
		}else{
			heigh[n/N][n%N]++;
		}
	}
 	public int maxHeighIndex(int row,int col){//新开点，周围点最大高度的根
		int max=heigh[row-1][col-1];
		int result=(row-1)*N+col;
		if(row-2>=0){
			if(isOpen(row-1,col)){
				int temp=root(row-1,col);
				int getH=getHeigh(temp);
				if(max<getH){
					result=temp;
					max=getH;
				}
			}
		}
		if(row<N){
			if(isOpen(row+1,col)){
				int temp=root(row+1,col);
				int getH=getHeigh(temp);
				if(max<getH){
					result=temp;
					max=getH;
				}
			}			
		}
		if(col-2>=0){
			if(isOpen(row,col-1)){
				int temp=root(row,col-1);
				int getH=getHeigh(temp);
				if(max<getH){
					result=temp;
					max=getH;
				}
			}
		}
		if(col<N){
			if(isOpen(row,col+1)){
				int temp=root(row,col+1);
				int getH=getHeigh(temp);
				if(max<getH){
					result=temp;
					max=getH;
				}
			}			
		}
		return result;
	}
	public void chRoot(int row,int col,int mRoot){//改变周围点的根
		if(row-2>=0){
			if(isOpen(row-1,col)){
				int temp=root(row-1,col);
				int tempRow;
				int tempCol;
				if(temp%N==0){
					tempRow=temp/N-1;
					tempCol=N;					
				}else{
					tempRow=temp/N;
					tempCol=temp%N;
				}
				id[tempRow][tempCol]=mRoot;
				if(getHeigh(mRoot)!=MAX)
					chHeigh(mRoot);
			}
		}
		if(row<N){
			if(isOpen(row+1,col)){
				int temp=root(row+1,col);
				int tempRow;
				int tempCol;
				if(temp%N==0){
					tempRow=temp/N-1;
					tempCol=N;					
				}else{
					tempRow=temp/N;
					tempCol=temp%N;
				}
				id[tempRow][tempCol]=mRoot;
			}			
		}
		if(col-2>=0){
			if(isOpen(row,col-1)){
				int temp=root(row,col-1);
				int tempRow;
				int tempCol;
				if(temp%N==0){
					tempRow=temp/N-1;
					tempCol=N;					
				}else{
					tempRow=temp/N;
					tempCol=temp%N;
				}
				id[tempRow][tempCol]=mRoot;
			}
			
		}
		if(col<N){
			if(isOpen(row,col+1)){
				int temp=root(row,col+1);
				int tempRow;
				int tempCol;
				if(temp%N==0){
					tempRow=temp/N-1;
					tempCol=N;					
				}else{
					tempRow=temp/N;
					tempCol=temp%N;
				}
				id[tempRow][tempCol]=mRoot;
			}
					
		}
	}
	public void open(int row,int col){
		if(row==1){
			heigh[row-1][col-1]=MAX;//顶部点的高度为最大值
		}else{
			heigh[row-1][col-1]=1;
		}
		numOpen++;
		int mRoot=maxHeighIndex(row,col);//获取周围点所属根的最大高度
		chRoot(row,col,mRoot);//改变周围点的根
	}
	public boolean isOpen(int row,int col){
		return heigh[row-1][col-1]>0;
	}
	public boolean isFull(int row,int col){
		int r=root(row,col);
		if(r<=N){
			return true;
		}
		return false;
	}
	public int numberOfOpenSites(){
		return numOpen;
	}
	public boolean isPer(){
		for(int i=1;i<=N;i++){
			if(isFull(N,i)){
				return true;
			}
		}
		return false;
	}
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		Percolation pl=new Percolation(num);
		
	}
}