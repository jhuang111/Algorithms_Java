import org.apache.commons.collections.Bag;
import java.util.*;
public class bagTest{
	public static void  main(String [] args){
		Bag<Double> bag=new Bag<Double>();
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			bag.add(sc.nextDouble());
		}
		double sum=0.0;
		for(double x:bag){
			System.out.println("The number is :"+x);
			sum+=x;
		}
		System.out.println("The sum is: "+sum);
	}
}
