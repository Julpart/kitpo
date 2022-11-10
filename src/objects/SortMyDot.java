package objects;

import java.util.Comparator;

public class SortMyDot implements Comparator<MyDot> {
	 @Override
	    public int compare(MyDot o1, MyDot o2) {
	        return o1.getRange().compareTo(o2.getRange());
	    }
}