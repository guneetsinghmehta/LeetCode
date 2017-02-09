package Design;
import java.util.*;
//https://leetcode.com/problems/peeking-iterator/
class peekingIterator284 implements Iterator<Integer> {
	List<Integer> list=new ArrayList<Integer>();
	Iterator<Integer> iterator;
	public peekingIterator284 (Iterator<Integer> iter) {
	    // initialize any member here.
		iterator=iter;
	    if(iterator.hasNext())
	    {
	    	list.add(iterator.next());
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(list.size()==1)
        {
        	return list.get(0);
        }
        return null;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
	    if(list.size()>0)
	    {
	    	int x=list.get(0);
	    	list.remove(0);
	    	if(iterator.hasNext())
		    {
		    	list.add(iterator.next());
		    }
	    	return x;
	    }
	    return null;
	}

	public boolean hasNext() {
	    if(list.size()>0){return true;}
	    return false;
	}
}