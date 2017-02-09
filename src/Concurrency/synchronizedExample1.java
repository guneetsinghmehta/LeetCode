package Concurrency;

public class synchronizedExample1 {
	private class callMe
	{
		//remove synchronized to see effect
		synchronized void call(String str) throws InterruptedException
		{
			System.out.print('[');
			System.out.print(str);
			Thread.sleep(100);
			System.out.print(']');
			System.out.println();
		}
	}

	private class caller extends Thread
	{
		callMe target;
		String str;
		caller(callMe target,String str)
		{
			super();
			this.target=target;
			this.str=str;
			this.start();
		}
		public void run()
		{
			try {
				target.call(this.str);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void sub()
	{
		callMe target=new callMe();
		caller A=new caller(target,"Guneet");
		caller B=new caller(target,"Singh");
		caller C=new caller(target,"Mehta");
		try
		{
			A.join();
			B.join();
			C.join();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		new synchronizedExample1().sub();
	}
}
