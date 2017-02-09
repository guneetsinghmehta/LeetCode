package Concurrency;
//makes a class that implements the runnable interface
class newThread implements Runnable
{
	Thread t;
	newThread(String name)
	{
		t=new Thread(this,name);
		System.out.println("child thread"+t);
		t.start();
	}
	
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			try
			{
				System.out.println("In child");
				Thread.sleep(500);
			}
			catch(Exception e)
			{
				System.out.println("child thread interrupted");
			}
		}
	}
}

public class creatingNewThreadUsingRunnable {
	public static void main(String args[]) {
		new newThread("child Thread");
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
