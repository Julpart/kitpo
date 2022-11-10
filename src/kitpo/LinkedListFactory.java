package kitpo;

import java.util.ArrayList;

import objects.MyDot;
import objects.MyVector;
public class LinkedListFactory {

    private IUserType list[] = { new MyVector(), new MyDot() };   
    private LinkedList<IUserType> linkedList = new LinkedList<IUserType>();
    private IUserType listClass = null;

    private IUserType findListClass(String className) {
        for (IUserType classItem : list) {
            if (classItem.getClassName().equals(className)) {
                listClass = classItem;
                return listClass;
            }
        }
        listClass = null;
        return listClass;
    }
    
   public LinkedList<IUserType> getBuilderByName(String className){
	   IUserType type = findListClass(className);
	   LinkedList<IUserType> clone = linkedList.copy();
	   clone.setType(type);
	   return clone;
	   
   }
   
   public String[] getList() {
	   String[] items = new	String[list.length];
	   for (int i = 0; i<list.length; i++) {
		   items[i] = list[i].getClassName();
	   }
	   
	   return items;
   }
   
}