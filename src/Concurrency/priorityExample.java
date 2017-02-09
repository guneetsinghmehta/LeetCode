package Concurrency;

class counter extends Thread
{
	boolean runFlag=true;
	volatile int accumulator=1;
	counter(String name,int priority)
	{
		this.setName(name);
		this.setPriority(priority);
		this.start();
	}
	public void run()
	{
		while(runFlag)
		{
			accumulator++;
		}
		System.out.println(this+" "+accumulator);
	}
	public void stopThread()
	{
		runFlag=false;
	}
}

public class priorityExample {
	public static void main(String args[]) throws InterruptedException{
		int a=1;
		counter A=new counter("A",Thread.NORM_PRIORITY+4);
		counter B=new counter("B",Thread.NORM_PRIORITY-4);
		Thread.sleep(10000);
		A.stopThread();
		B.stopThread();
		A.join();
		B.join();
	}
}
