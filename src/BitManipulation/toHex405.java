package BitManipulation;

//https://leetcode.com/problems/convert-a-number-to-hexadecimal/
public class toHex405 {
	public static void main(String args[]) {
		System.out.println(new toHex405().toHex(26));
	}
	StringBuilder sb=new StringBuilder();
	public String toHex(int num) {
		sub(num);
		return sb.reverse().toString();
	}
	
	public void sub(int n)
	{
		if(n==0){return;}
		int bits[]=new int[4];
		for(int i=0;i<4;i++)
		{
			if((n&(int)Math.pow(2,i))!=0){bits[i]=1;}
		}
		getHexChar(bits);
		sub(n>>>4);
	}
	
	public void getHexChar(int x[])
	{
		int y=0;
		int ans=0;
		for(int i=0;i<4;i++){ans+=Math.pow(2, i)*x[i];}
		if(ans<10){sb.append(ans);}
		else{sb.append((char)(ans-10+'a'));}
	}
}
