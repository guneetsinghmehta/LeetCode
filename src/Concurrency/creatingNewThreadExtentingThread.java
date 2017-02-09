package Concurrency;
//create a new thread by extending the Thread class
class extendThread extends Thread
{
	extendThread(String threadName)
	{
		super(threadName);
		System.out.println("new thread"+this);
		start();
	}
	
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			try
			{
				System.out.println(this+Integer.toString(i));
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				System.out.println("Error in child");
			}
		}
	}
}

public class creatingNewThreadExtentingThread {
	public static void main(String args[]) {
		extendThread t=new extendThread("child Thread");
		for(int i=0;i<5;i++)
		{
			try
			{
				System.out.println("In main");
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println("main thread interrupted");
			}
		}
		System.out.println("end");
	}
}
