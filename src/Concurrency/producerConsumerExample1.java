package Concurrency;
//This example makes a queue and a producer and a consumer.
//ideally a consumer should consume after something has been produced
//and a producer must produce after something has been consumed
public class producerConsumerExample1 {
	private class Q
	{
		int number;
		Q()
		{
			number=1;
		}
		synchronized int get()
		{
			System.out.println("GET "+Integer.toString(this.number));
			return this.number;
		}
		synchronized void put(int n)
		{
			System.out.println("PUT "+Integer.toString(n));
			this.number=n;
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
				q.put(i++);
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
			while(true)
			{
				q.get();
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
		new producerConsumerExample1().sub();
	}
}
