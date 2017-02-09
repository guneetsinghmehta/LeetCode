package Design;

import java.util.HashMap;

//https://leetcode.com/problems/lru-cache/
/*
 * 1. Define a Doubly Linked List Node - Node(val,left,right)
 * 2. Define a map that stores key,Node pairs
 * 3. Keep a Doubly Linked list to get the order of removal
 * 4. when put is used - remove element if present already, add Node to the end with changed value
 * 5. when get is used - remove element if present already, add Node to the end
 * 6. when capacity is reached - remove the head of list and add other to end
 */
public class LRUCache {
	public static void main(String args[]) {
		LRUCache c=new LRUCache(1);
		c.put(2, 1);
		System.out.println(c.get(2));
		c.put(3, 2);
		System.out.println(c.get(2));
		System.out.println(c.get(3));
		/*
		LRUCache cache=new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
		*/
	}
	class node
	{
		int key;
		int val;
		node left,right;
		node(int key,int val)
		{
			this.key=key;
			this.val=val;
		}
	}
	
	class nodeList
	{
		node head;
		node tail;
		int size=0;
		//add to end
		void addToEnd(node x)
		{
			x.left=null;
			x.right=null;
			if(size==0)
			{
				head=x;
				tail=x;
			}
			else
			{
				x.left=tail;
				tail.right=x;
				tail=x;
			}
			size++;
		}
		//remove - from front,end and mid
		int remove(node x)
		{
			//Assumption the node will always be in the list
			//from front
			node A=x.left;
			node B=x.right;
			if(x==head)
			{
				head=B;
				if(B!=null)
				{
					B.left=null;
				}
				if(head==null){tail=null;}
			}
			//from end
			else if(x==tail)
			{
				tail=A;
				if(A!=null)
				{
					A.right=null;
				}
				if(tail==null){head=null;}
			}
			//between
			else
			{
				A.right=B;
				B.left=A;
			}
			x.left=null;
			x.right=null;
			size--;
			return x.key;
		}
		
		int removeHead()
		{
			return remove(head);
		}
	}
	
	HashMap<Integer,node> map=new HashMap<Integer,node>();
	nodeList q=new nodeList();
	int capacity;
	
	public LRUCache(int capacity) {
		this.capacity=capacity;
    }
    
    public int get(int key) {
    	if(map.containsKey(key))
    	{
    		node x=map.get(key);
    		q.remove(x);
    		q.addToEnd(x);
    		return x.val;
    	}
    	else
    	{
    		return -1;
    	}
    }
    
    public void put(int key, int value) {
    	node x;
    	if(map.containsKey(key))
    	{
    		x=map.get(key);
    		q.remove(x);
    		q.addToEnd(x);
    		x.val=value;
    	}
    	else
    	{
    		x=new node(key,value);
    		if(q.size==capacity)
    		{
    			int tempKey=q.removeHead();
    			map.remove(tempKey);
    		}
    		q.addToEnd(x);
    	}
    	map.put(key,x);
    }
}
