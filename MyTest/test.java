import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.lang.*;
public class test{
	public static void main(String [] args){
		String []s=readFromConsole();
		for(String temp:s){
			System.out.println(s);
		}
	}
	 public static String[] readFromConsole() {
		  Scanner scanner = new Scanner(System.in);
		  String str = scanner.nextLine();
		  String content = "";
		  // 随机分隔符
		  String sepator = (new Date()).getTime() + "-"
		    + java.util.UUID.randomUUID().toString();
		  // 当输入#EXIT#按换行键就结束输入字符串
		  while (!str.equals("#EXIT#")) {
		   content += str + sepator;
		   str = scanner.nextLine();
		  }
		  return content.split(sepator);
 	}	
}
