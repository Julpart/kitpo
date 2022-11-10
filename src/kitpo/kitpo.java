package kitpo;

import javax.swing.JFrame;

import View.View;
import objects.MyDot;
import objects.MyVector;


public class kitpo {
	
	 public static void main(String[] args) {
		 /*
		LinkedListFactory factory = new LinkedListFactory();
		IUserType dot1 = new MyDot(1,1);
		IUserType dot2 = new MyDot(0,0);
		IUserType dot3 = new MyDot(-1,2);
		LinkedList list = factory.getBuilderByName(dot1.getClassName());
		list.add(dot1);
		list.add(dot2);
		list.add(dot3);
		list.printList();
		list.forEach((a)->{  System.out.println(a); }); 
		list.sort();
		list.remove();
		list.printList();
		list.save();
		list.load();
		list.printList();
		list.exportToXML();
		*/
			MyVector dot1 = new MyVector(-10,12,7,3);
			System.out.println(dot1.getLength());
	              View w = new View();
	      	      w.setVisible(true);
	          
	    }
}

