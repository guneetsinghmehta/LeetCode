package Array;
//https://leetcode.com/problems/teemo-attacking/
public class teemoAttacking495 {
	public static void main(String args[]) {
		int x[]={1,4};
		System.out.println(new teemoAttacking495().findPoisonedDuration(x, 2));
	}
	
	public int findPoisonedDuration(int[] attack, int duration) {
		int ans=0;
		if(attack==null||attack.length==0){return 0;}
		int i=0,limit;
		while(i<attack.length)
		{
			limit=attack[i]+duration;
			int j=i+1;
			while(j<attack.length&&attack[j]<=limit)
			{
				limit=attack[j]+duration;
				j++;
			}
			ans+=limit-attack[i];
			i=j;
		}
		return ans;
    }
}
