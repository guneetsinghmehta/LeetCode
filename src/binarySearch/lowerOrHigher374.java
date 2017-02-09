package binarySearch;

public class lowerOrHigher374 {
	public static void main(String args[]) {
		int n=10;
		
	}
	
	public static int guess(int a)
	{
		int x=6;
		if(x==a){return 0;}
		else if(x>a){return 1;}
		else {return -1;}
	}
	
	public static int sub(int a,int b)
    {
		int mid,x;
        while(a<b)
        {
        	mid=a+(b-a)/2;//important and not (a+b)/2
        	x=guess(mid);
        	if(x==0){return mid;}
        	if(x==1){a=mid+1;}
        	else {b=mid;}
        }
        return a;
    }
}
