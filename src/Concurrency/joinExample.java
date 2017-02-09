package Concurrency;
//spawns multiple threads and waits on them
import java.util.*;
public class joinExample {
	public static void main(String args[]) throws InterruptedException {
		ArrayList<extendThread> list=new ArrayList<extendThread>();
		for(int i=0;i<2;i++)
		{
			list.add(new extendThread(Integer.toString(i)));
		}
		for(int i=0;i<list.size();i++)
		{
			list.get(i).join();
		}
		System.out.println("master ends");
	}
}
