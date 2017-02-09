package Concurrency;
//changes name of the thread and prints it
public class mainThread {
	public static void main(String args[]) {
		Thread t=Thread.currentThread();
		System.out.println(t);
		t.setName("kipper");
		System.out.println(t);
		
		for(int i=0;i<5;i++)
		{
			try
			{Thread.sleep(1000);}
			catch(Exception e)
			{
				System.out.println("Main Thread interrupted");
			}
		}
		System.out.println("Main thread exiting");
	}
}
