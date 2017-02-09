package Greedy;
//https://leetcode.com/problems/gas-station/
public class gasStation134 {
	public static void main(String args[]) {
		int gas[]={2,4};
		int cost[]={3,4};
		System.out.println(new gasStation134().canCompleteCircuit(gas, cost));
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int i=0,N=gas.length,tank,j;
		while(i<N&&gas[i]-cost[i]<0){i++;}
		while(i<N)
		{
			tank=gas[i]-cost[i];
			j=(i+1)%N;
			while(tank>=0&&j!=i)
			{
				tank+=gas[j]-cost[j];
				j=(j+1)%N;
			}
			if(i==j&&tank>=0){return i;}
			if(j<=i){return -1;}
			else{i=j;}
		}
		return -1;
    }
}
