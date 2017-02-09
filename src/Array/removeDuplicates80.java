package Array;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class removeDuplicates80 {
	public static void main(String args[])
	{
		int x[]={1,1};
		System.out.println(new removeDuplicates80().removeDuplicates(x));
	}
	
	int nums[];
	int read,write;
	public int removeDuplicates(int[] x) {
		nums=x;
		if(nums.length<=2){return nums.length;}
		read=0;
		write=0;
		sub();
		return write;
    }
	
	public void sub()
	{
		if(read>=nums.length){return;}
		nums[write]=nums[read];
		if(read+1<nums.length&&nums[read+1]==nums[read])
		{
			nums[write+1]=nums[read+1];
			read=read+2;
			write=write+2;
			while(read<nums.length&&nums[read]==nums[read-1])
			{
				read++;
			}
		}
		else
		{
			read++;
			write++;
		}
		sub();
	}
}
