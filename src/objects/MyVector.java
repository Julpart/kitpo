package objects;

import java.util.Comparator;

import kitpo.IUserType;
import java.io.Serializable;
import java.util.Comparator;

import kitpo.IUserType;
public class MyVector implements IUserType,Serializable{
	
	private final Integer xCordA;
	private final Integer yCordA;
	private final Integer xCordB;
	private final Integer yCordB;
	private final Integer x;
	private final Integer y;
	
	
	public String getA() {
		String  str = "(" + xCordA + ";" + yCordA + ")";
		return str;
	}
	
	public String getB() {
		String  str = "(" + xCordB + ";" + yCordB + ")";
		return str;
	}
	
	public double getLength() {
		double sqrt = Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
		double length = Math.abs(sqrt);
		return length;
	}
	
	public MyVector(Integer xA,Integer yA,Integer xB,Integer yB) {
		this.xCordA = xA;
		this.yCordA = yA;
		this.xCordB = xB;
		this.yCordB = yB;
		this.y = this.yCordB - this.yCordA;
		this.x = this.xCordB - this.xCordA;
		
	}
	
	public MyVector() {
		this.xCordA = (int) (Math.random() * 100) - 100;
		this.yCordA = (int) (Math.random() * 100) - 100;
		this.xCordB = (int) (Math.random() * 100) - 100;
		this.yCordB = (int) (Math.random() * 100) - 100;
		this.y = this.yCordB - this.yCordA;
		this.x = this.xCordB - this.xCordA;
	}
	
	  @Override
	    public String toString() {
	        return "(" + this.x + ";" + this.y + ")";
	    }

	    @Override
	    public IUserType copy() {
	        return new MyVector(this.xCordA, this.yCordA,this.xCordB,this.yCordB);
	    }

	    @Override
	    public IUserType create() {
	        return new MyVector();
	    }

	    @Override
	    public String getClassName() {
	        return this.getClass().getName();
	    }
	    
	    @Override
	    public Comparator getTypeComparator() {
	        return new SortMyVector();
	    }
}
