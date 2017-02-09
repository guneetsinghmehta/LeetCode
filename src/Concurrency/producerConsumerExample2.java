package Concurrency;

//This example makes a queue and a producer and a consumer.
//ideally a consumer should consume after something has been produced
//and a producer must produce after something has been consumed
public class producerConsumerExample2 {
	private class Q
	{
		int number;
		boolean valueSet=true;
		Q()
		{
			number=1;
		}
		synchronized void get() throws InterruptedException
		{
			while(!valueSet)
			{
				wait();
			}
			valueSet=false;
			System.out.println("GET "+Integer.toString(this.number));
			notify();
		}
		synchronized void put(int n) throws InterruptedException
		{
			while(valueSet)
			{
				wait();
			}
			valueSet=true;
			System.out.println("PUT "+Integer.toString(n));
			this.number=n;
			notify();
		}
	}
	private class Producer extends Thread
	{
		Q q;
		Producer(Q q)
		{
			super("Producer");
			this.q=q;
			this.start();
		}
		public void run()
		{
			int i=0;
			while(true)
			{
				try {
					q.put(i++);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	private class Consumer extends Thread
	{
		Q q;
		Consumer(Q q)
		{
			super("Consumer");
			this.q=q;
			this.start();
		}
		public void run()
		{
			t
			while(true)
			{
				try {
					q.get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	private void sub() throws InterruptedException
	{
		Q q=new Q();
		Producer P=new Producer(q);
		Consumer C=new Consumer(q);
		P.join();
		C.join();
	}
	public static void main(String args[]) throws InterruptedException {
		new producerConsumerExample2().sub();
	}
}
