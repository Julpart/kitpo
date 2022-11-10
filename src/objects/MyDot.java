package objects;
import java.io.Serializable;
import java.util.Comparator;

import kitpo.IUserType;
public class MyDot implements IUserType,Serializable{
	
	private final Integer xCord;
	private final Integer yCord;
	
	
	public Integer getX() {
		return this.xCord;
	}
	
	public Integer getY() {
		return this.yCord;
	}
	
	public Integer getRange() {
		int range = Math.abs(this.xCord) + Math.abs(this.yCord);
		return range;
	}
	
	public MyDot(Integer x,Integer y) {
		this.xCord = x;
		this.yCord = y;
		
	}
	
	public MyDot() {
		this.xCord = (int) (Math.random() * 100) - 100;
		this.yCord = (int) (Math.random() * 100) - 100;
	}
	
	  @Override
	    public String toString() {
	        return "X: " + this.xCord + " Y: " + this.yCord;
	    }

	    @Override
	    public IUserType copy() {
	        return new MyDot(this.xCord, this.yCord);
	    }

	    @Override
	    public IUserType create() {
	        return new MyDot();
	    }

	    @Override
	    public String getClassName() {
	        return this.getClass().getName();
	    }
	    
	    @Override
	    public Comparator getTypeComparator() {
	        return new SortMyDot();
	    }
}


