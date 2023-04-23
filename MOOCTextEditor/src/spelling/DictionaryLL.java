package spelling;

import java.util.Iterator;
import java.util.LinkedList;
//import java.util.LinkedListNode;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	
    // TODO: Add a constructor
	
	public  DictionaryLL() {
		dict = new LinkedList<String>();
	}

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
//    	System.out.println(this.dict);
    	word =word.toLowerCase();
    	
    	int index = 0;
    	while(index<this.size()){
	    	if(dict.get(index).compareTo(word)==0) {
	    		return false;
	    	}
	    	if(dict.get(index).compareTo(word)>0) {
	    		dict.add(index, word);
	    		return true;
	    	}
	    	index++;
    	}
		dict.add(word);
        return true;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        // TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	if(this.size()==0) {
    		return false;
    	}
    	s=s.toLowerCase();
        //TODO: Implement this method
    	int start  = 0;
    	int end = this.size()-1;
    	int mid;
    	while(start<=end) {
    		mid = (start+end)/2;
    		String gett = dict.get(mid);
    		
    		int res = s.compareTo(gett);
    		if(res < 0) {
    			end = mid - 1;
    		}else if (res > 0) {
    			start = mid + 1;
    		}else {
    			return true;
    		}
    	}
        return false;
    }
  

    
}
