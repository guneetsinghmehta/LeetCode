package Stack;
import java.util.*;
public class towerOfHanoi {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Stack<Integer> main=new Stack<Integer>();
		main.push(3);
		main.push(2);
		main.push(1);
		Stack<Integer> dest=new Stack<Integer>();
		Stack<Integer> aux=new Stack<Integer>();
		towerOfHanoi(3,main,dest,aux);
		System.out.println(dest);
		System.out.println(main);
		System.out.println(aux);
	}
	
	public static void towerOfHanoi(int n,Stack<Integer> main,Stack<Integer> dest,Stack<Integer> aux)
	{
		if(n==0) return;
		towerOfHanoi(n-1,main,aux,dest);
		//System.out.printf("Transfer %d from %s to %s\n",main.peek(),main,dest);
		dest.push(main.pop());
		towerOfHanoi(n-1,aux,dest,main);
	}
}
