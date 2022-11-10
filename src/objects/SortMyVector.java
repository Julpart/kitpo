package objects;
import java.util.Comparator;

import kitpo.IUserType;

import java.util.Comparator;

public class SortMyVector implements Comparator<MyVector> {
	 @Override
	    public int compare(MyVector o1, MyVector o2) {
	        return new Double(o1.getLength()).compareTo(o2.getLength());
	    }
}