package kitpo;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;




class Node<V> {
    V data;
    Node<V> next;
    Node<V> prev;
    
    Node (V data,Node<V> next,Node<V> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
        
    }
}

interface Consumer<V> {
	void accept(V data);

}
public class LinkedList<V extends IUserType> {
	Comparator comparatorType;
	
	
	public void forEach(Consumer<V> action) {
		Objects.requireNonNull(action);
		Node<V> currNode = this.head.next;
        while (currNode != this.head) {
            action.accept(currNode.data);
            currNode = currNode.next;
        }
	}
  
    private Node<V> head = new Node<V>(null,null,null);
    private transient int size = 0;
    private IUserType type = null;
    public LinkedList() {
        head.next = head.prev = head;
    }
    
    public LinkedList<IUserType> copy() {
    	return new LinkedList<IUserType>();
    }
    
    public void setType(IUserType type) {
    	this.type = type;
    	this.comparatorType = type.getTypeComparator();
    }
    
    public IUserType getType() {
    	return this.type;
    }
    
    public int size() {
        return size;
    }
    
    public boolean add(V data) {
    	if(type != null) {
    		if(data.getClassName().equals(type.getClassName())) {
    			addBefore(data, this.head);
    	        return true;
    		}else return false;
    		
    	}else {
    		addBefore(data, this.head);
    		return true;
    	}
    }
    
    public boolean addByIndex(V data,int index) {
    	if(type != null) {
    		if(data.getClassName().equals(type.getClassName())) {
    			addBefore(data, index(index));
    	        return true;
    		}else return false;
    		
    	}else {
    		addBefore(data, index(index));
    		return true;
    	}
    }
    	
    public boolean remove() {
        remove(head.prev);
        return true;
    }
    
    public boolean removeByIndex(int index) {
    	remove(index(index));
        return true;
    }
    
    public void clean() {
    	for(int i=0;i<this.size;i++) {
    		remove(head.prev);
    	}
    	this.type = null;
    	this.comparatorType = null;
    }
    
    public V get(int index) {
        return index(index).data;
    }
    
    public V set(int index, V data) {
        Node<V> node = index(index);
        V oldVal = node.data;
        node.data = data;
        return oldVal;
    }
    
    private Node<V> addBefore(V data,Node<V> node) {
    	Node<V> new_node = new Node<V>(data,node,node.prev);
    	new_node.prev.next = new_node;
    	new_node.next.prev = new_node;
    	size++;
    	return new_node;
    }
    
    private boolean remove(Node<V> node){
    	if (node == head)
            throw new NoSuchElementException();
    	node.prev.next = node.next;
    	node.next.prev = node.prev;
    	node.next = node.prev = null;
    	node.data = null;
    	size--;
    	return true;
    	
    }
    
    private Node<V> index(int index){
    	if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    	Node<V> node = head;
    	
    	if (index < (size >> 1)) {
            for (int i = 0; i <= index; i++)
                node = node.next;
        } else {
            for (int i = size; i > index; i--)
                node = node.prev;
        }
        return node;
    }
    
    public String printList() {
        Node<V> currNode = this.head.next;
        String str = "";
        int i = 0;
        while (currNode != this.head) {
        	i++;
        	str += i +": " + currNode.data + "; ";
            currNode = currNode.next;
        }
        return str;
    }
    
    private void heapify(int length, int i) {
    	int leftChild = 2*i+1;
    	int rightChild = 2*i+2;
    	int largest = i;
    	
    	if (leftChild < length && this.comparatorType.compare(this.get(leftChild),this.get(largest)) > 0 ) {
            largest = leftChild;
        }
    	
    	if (rightChild < length && this.comparatorType.compare(this.get(rightChild),this.get(largest)) > 0) {
    	        largest = rightChild;
    	    }
    	if (largest != i) {
    	        V temp = this.get(i);
    	        this.set(i, this.get(largest));
    	        this.set(largest, temp);
    	        heapify(length, largest);
    	    }
    	
    }
    
    public void sort() {
    	if (this.size == 0) return;
    	
    	for (int i = this.size / 2-1; i >= 0; i--)
            heapify(this.size, i);
    	
    	 for (int i = this.size-1; i >= 0; i--) {
    	        V temp = this.get(0);
    	        this.set(0, this.get(i));
    	        this.set(i, temp);

    	        heapify(i, 0);
    	    }
    }
    
    public void save() {
         
         try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("LinkedList.dat")))
         {
        	 Node<V> currNode = this.head.next;
             while (currNode != this.head) {
            	 oos.writeObject(currNode.data);
                 currNode = currNode.next;
             }
         }
         catch(Exception ex){
              
             System.out.println(ex.getMessage());
         } 
    }
    
    public void load() {
    	this.clean();
    	V currNode = null;
    	try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("LinkedList.dat")))
        {
    		
    		boolean bool = true;
             while(bool) {
            	 currNode = (V) ois.readObject();
            	 this.add(currNode);
             }
        }
        catch(Exception ex){
             this.setType(currNode); 
        } 
    }
    
    public void exportToXML()  {
    	FileOutputStream fos;
		try {
			fos = new FileOutputStream("data.xml");
			XMLEncoder encoder = new XMLEncoder(fos); 
			encoder.writeObject(this);
			encoder.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  
    }
            
   
}