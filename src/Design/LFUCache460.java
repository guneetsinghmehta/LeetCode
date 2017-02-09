package Design;
//https://leetcode.com/problems/lfu-cache/
import java.util.*;
public class LFUCache460 {
	
	class valueObj
	{
		int key,value,freq,stamp;
		public valueObj(int key,int value)
		{
			this.key=key;
			this.value=value;
			this.freq=1;
			this.stamp=currentOp++;
		}
	}
	HashMap<Integer,valueObj> map=new HashMap<Integer,valueObj>();
	Comparator<valueObj> comp=new Comparator<valueObj>(){
    	public int compare(valueObj a,valueObj b)
    	{
    		if(a.freq>b.freq){return 1;}
    		else if(a.freq<b.freq){return -1;}
    		else 
    		{
    			if(a.stamp>b.stamp){return 1;}
    			else if(a.stamp<b.stamp){return -1;}
    			else {return 0;}
    		}
    	}
    };
    PriorityQueue<valueObj> pq=new PriorityQueue<valueObj>(comp);
    int capacity;
    int currentOp=1;
    
    public LFUCache460(int capacityInput) {
        capacity=capacityInput;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
        	//update freq,stamp and return the value
        	valueObj x=map.get(key);
        	x.freq++;
        	x.stamp=currentOp++;
        	pq.remove(x);
        	pq.add(x);
        	return x.value;
        }
        else
        {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
    	if(capacity==0){return;}
        if(map.containsKey(key))
        {
        	//update value,update freq and last used time
        	map.get(key).value=value;
        	map.get(key).freq++;
        	map.get(key).stamp=currentOp++;
        	valueObj x=map.get(key);
        	pq.remove(x);
        	pq.add(x);
        }
        else
        {
        	if(map.size()<capacity)
        	{
        		map.put(key, new valueObj(key,value));
        		pq.add(map.get(key));
        	}
        	else
        	{
        		valueObj x=pq.remove();
        		map.remove(x.key);
        		map.put(key, new valueObj(key,value));
        		pq.add(map.get(key));
        	}
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */