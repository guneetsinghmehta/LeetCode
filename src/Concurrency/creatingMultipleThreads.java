package Concurrency;
import java.util.*;
public class creatingMultipleThreads {
	public static void main(String args[]) {
		ArrayList<newThread> list=new ArrayList<newThread>();
		for(int i=1;i<5;i++)
		{
			list.add(new newThread(Integer.toString(i)));
		}
		try
		{
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			
		}
		System.out.println("exit");
	}
}
