package Array;
//88
//https://leetcode.com/problems/merge-sorted-array/
public class mergeSortedArray88 {
	public static void main(String args[])
	{
		int nums1[]={1,2,4,0,0,0};
		int nums2[]={3,5,6};
		new mergeSortedArray88().merge(nums1, 3, nums2, 3);
		System.out.println(1);
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		//copy all elements in nums1 to last
		for(int i=m-1;i>=0;i--)
		{
			nums1[nums1.length-1-(m-1-i)]=nums1[i];
		}
		//get a pointer a in nums1 and b in nums2
		int a=nums1.length-m;
		int b=0;
		//put the smaller in beginning and advance the pointer
		int i=0;
		while(a<nums1.length&&b<nums2.length)
		{
			if(nums1[a]<nums2[b])
			{
				nums1[i++]=nums1[a++];
			}
			else
			{
				nums1[i++]=nums2[b++];
			}
		}
		while(a<nums1.length){
			nums1[i++]=nums1[a++];
		}
		while(b<nums2.length)
		{
			nums1[i++]=nums2[b++];
		}
		//copy all remaining
    }
}
