package View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import objects.*;
import kitpo.*;


public class View extends JFrame {
	  private JLabel jLabel;
	  private JTextField jTextField;
	  private JButton jButtonAdd;
	  private JButton jButtonDelete;
	  private JButton jButtonSort;
	  private JButton jButtonSave;
	  private JButton jButtonLoad;
	  private JComboBox jComboBox;
	  LinkedListFactory factory = new LinkedListFactory();
	  LinkedList list;
	  

	public View()
	   {
	      super();
	      this.setSize(800, 400);
	      this.getContentPane().setLayout(null);
	      JScrollPane panel = new JScrollPane(getJLabel());
	      panel.setBounds(34, 49, 300, 50);
	      this.add(panel);
	      this.add(getJButtonAdd(), null);
	      this.add(getJButtonDelete(), null);
	      this.add(getJButtonSort(), null);
	      this.add(getJButtonSave(), null);
	      this.add(getJButtonLoad(), null);
	      this.add(getJComboBox(),null);
	      this.setTitle("LinkedList");
	      ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
	   }

	   private javax.swing.JLabel getJLabel() {
	      if(jLabel == null) {
	         jLabel = new javax.swing.JLabel();
	         jLabel.setBounds(40, 50, 300, 18);	
	         jLabel.setText(" ");
	      }
	      return jLabel;
	   }

	   private javax.swing.JTextField getJTextField() {
	      if(jTextField == null) {
	         jTextField = new javax.swing.JTextField();
	         jTextField.setBounds(40, 100, 160, 20);
	      }
	      return jTextField;
	   }

	   private javax.swing.JButton getJButtonAdd() {
	      if(jButtonAdd == null) {
	         jButtonAdd = new javax.swing.JButton();
	         jButtonAdd.setBounds(600, 100, 80, 30);
	         jButtonAdd.setText("Add");
	      }
	      jButtonAdd.addActionListener(new ActionListener() {
		    		  public void actionPerformed(ActionEvent e){
	                       list.add(list.getType().create());
	                       jLabel.setText(list.printList());
	                    }
		    	  });
	      return jButtonAdd;
	   }
	   
	   private javax.swing.JButton getJButtonDelete() {
		      if(jButtonDelete == null) {
		    	  jButtonDelete = new javax.swing.JButton();
		    	  jButtonDelete.setBounds(600, 150, 80, 30);
		    	  jButtonDelete.setText("Delete");
		      }
		      jButtonDelete.addActionListener(new ActionListener() {
			    		  public void actionPerformed(ActionEvent e){
		                       list.remove();
		                       jLabel.setText(list.printList());
		                    }
			    	  });
		      return jButtonDelete;
		   }
	   
	   private javax.swing.JButton getJButtonSort() {
		      if(jButtonSort == null) {
		    	  jButtonSort = new javax.swing.JButton();
		    	  jButtonSort.setBounds(600, 200, 80, 30);
		    	  jButtonSort.setText("Sort");
		      }
		      jButtonSort.addActionListener(new ActionListener() {
			    		  public void actionPerformed(ActionEvent e){
		                       list.sort();
		                       jLabel.setText(list.printList());
		                    }
			    	  });
		      return jButtonSort;
		   }
	   
	   private javax.swing.JButton getJButtonSave() {
		      if(jButtonSave == null) {
		    	  jButtonSave = new javax.swing.JButton();
		    	  jButtonSave.setBounds(600, 250, 80, 30);
		    	  jButtonSave.setText("Save");
		      }
		      jButtonSave.addActionListener(new ActionListener() {
			    		  public void actionPerformed(ActionEvent e){
		                       list.save();
		                       jLabel.setText(list.printList());
		                    }
			    	  });
		      return jButtonSave;
		   }
	   
	   private javax.swing.JButton getJButtonLoad() {
		      if(jButtonLoad == null) {
		    	  jButtonLoad = new javax.swing.JButton();
		    	  jButtonLoad.setBounds(600, 300, 80, 30);
		    	  jButtonLoad.setText("Load");
		      }
		      jButtonLoad.addActionListener(new ActionListener() {
			    		  public void actionPerformed(ActionEvent e){
		                       list.load();
		                       jLabel.setText(list.printList());
		                    }
			    	  });
		      return jButtonLoad;
		   }
	   
	   private javax.swing.JComboBox getJComboBox() {
		    	  JComboBox jComboBox = new javax.swing.JComboBox(factory.getList());
		    	  jComboBox.setEditable(true);
		    	  jComboBox.setBounds(35, 150, 300, 40);
		    	  jComboBox.addActionListener(new ActionListener() {
		    		  public void actionPerformed(ActionEvent e){
	                        JComboBox combo = (JComboBox)e.getSource();
	                        String currentQuantity = (String)combo.getSelectedItem();
	                        list = factory.getBuilderByName(currentQuantity);
	                    }
		    	  });

		      return jComboBox;
		   }
}
