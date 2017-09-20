package carinsurance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.EOFException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AllDetails extends JFrame implements ActionListener
{
	private String driverclass = "com.mysql.jdbc.Driver"; 
	private String user  = "root";
	private String password = "root";
	private String url = "jdbc:mysql://localhost:3306/";
	private String database  = "insurance";
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	private PreparedStatement prepare;
	

	
	private String selectid = "select * from customer_details";
	
	
   
	
    int id=0; 
    String name="";
    String fathername="";
    String address1="";
    String address2="";
    String phoneno1="";
    String phoneno2="";
    String doj="";
    String emailid="";
    String pincode="";
    String state="";
    String designation="";
   
    
    
    JLabel lid;
    JLabel lname;
    JLabel lvehicleno;
    JLabel laddress1;
    JLabel laddress2;
    JLabel lphoneno1;
    JLabel lphoneno2;
    JLabel ldoj;
    JLabel lemailid;
    JLabel lpincode;
    JLabel lstate;
  
    JLabel ldesignation;
 
    
    Dimension dimension;
    Toolkit toolkit;
    
    JTextField tid;
    JTextField tname;
    JTextField tvehicleno;
    JTextField taddress1;
    JTextField taddress2;
    JTextField tphoneno1;
    JTextField tphoneno2;
    JTextField tdoj;
    JTextField temailid;
    JTextField tpincode;
    JTextField tstate;
    JTextField tdesignation;
  
    
    JPanel panel;
    JFrame frame;
    JLabel message;
   
    JButton next;
    JButton prev;
    JButton exit;
   
    
    JLabel Date;
    JLabel dateod;
    JTextArea area;
    Date d=new Date();
    int date1;
    String dates;
    int month;
    String months;
    int year;
    String years;
    
    String p=null;
    @SuppressWarnings("deprecation")
	public AllDetails(String pas1)
    {
    	p=pas1;
    	try
    	{  
    		
    		toolkit=Toolkit.getDefaultToolkit();
    		dimension=toolkit.getScreenSize();
    		frame=new JFrame();
    		frame.setTitle("ALL CUSTOMER DETAILS");
    		message=new JLabel(" All Customers Details  ");
    		message.setFont(new Font("Arial",Font.BOLD,30));
    		message.setForeground(Color.DARK_GRAY);
    	    panel=new JPanel(null);
    	    frame.add(panel);
    	    message.setBounds(350,10,900,70);
    		panel.add(message);
    		
    		
    		
    		 date1=d.getDate();
             dates=Integer.toString(date1);
             month=1+d.getMonth();
             months=Integer.toString(month);
             year=1900+d.getYear();
             years=Integer.toString(year);
             String value=dates;
 
    		
            lid=new JLabel("Id");
    	    tid=new JTextField(40);
    	    tid.setFont(new Font("Arial",Font.BOLD,10));
    		tid.setEditable(false);
    		
    	    lname=new JLabel("Name");
	        tname=new JTextField(40);
            tname.setEditable(false);
            
	        lvehicleno=new JLabel("Father Name");
	        tvehicleno=new JTextField(40); 
	        tvehicleno.setEditable(false);
	        
	        laddress1=new JLabel("Residential Address");
	        taddress1=new JTextField(40);
    		taddress1.setEditable(false);
    		
	        laddress2=new JLabel("Office/Business Address");
	        taddress2=new JTextField(40);
	        taddress2.setEditable(false);
	        
	        lphoneno1=new JLabel("Phone No.");
    	    tphoneno1=new JTextField(40);
    	    tphoneno1.setEditable(false);
    	   
	        
    	    lphoneno2=new JLabel("Mobile No.");
    	    tphoneno2=new JTextField(40);
    	    tphoneno2.setEditable(false);
    	   
    	    ldoj=new JLabel("Date Of Joining");
    	    tdoj=new JTextField(40);
    	    tdoj.setEditable(false);
    	    
    	    lemailid=new JLabel("E-mailId");
    	    temailid=new JTextField(40);
    	    temailid.setEditable(false);
    	    
    	    lpincode=new JLabel("Pincode");
    	    tpincode=new JTextField(40);
    	    tpincode.setEditable(false);
    	    
    	    lstate=new JLabel("State");
    	    tstate=new JTextField(40);
    	    tstate.setEditable(false);
    	    
    	    ldesignation=new JLabel("Designation");
    	    tdesignation=new JTextField(40);
    	    tdesignation.setEditable(false);
    	    
    	    
    	    
    	    Class.forName(driverclass);
    		connection  = DriverManager.getConnection(url+database,user, password);
    		statement=connection.createStatement();
    	    resultset=statement.executeQuery(selectid);
    	    
    	   while(resultset.next())
    	   {
    		 
       	     tid.setText(String.valueOf(resultset.getInt(1)));
             tname.setText(resultset.getString(2));
     	     tvehicleno.setText(resultset.getString(3));
     	     taddress1.setText(resultset.getString(4));
     	     taddress2.setText(resultset.getString(5));
     	     tphoneno1.setText(resultset.getString(6));
     	     tphoneno2.setText(resultset.getString(7));
     	     tdoj.setText(resultset.getString(8));
     	     temailid.setText(resultset.getString(9));
     	     tpincode.setText(resultset.getString(10));
     	     tstate.setText(resultset.getString(11));
     	     tdesignation.setText(resultset.getString(12));
     	     
     	     break;
    		 
    	   }
    	  
    	    
	        next=new JButton("Next");
	        next.setMnemonic('n');
	        next.setToolTipText("Click here For Next Record");
    		prev=new JButton("Prev");
    		prev.setMnemonic('p');
    		prev.setToolTipText("Click here For Previous Record");
    		
    		exit=new JButton("Exit");
    		exit.setMnemonic('e');
    		exit.setToolTipText("Click here For Exit");
    		
    		
    		 Date=new JLabel("DATE");
             Date.setFont(new Font("Courier New",Font.BOLD,25));
             dateod= new JLabel();
             dateod.setFont(new Font("Courier New",Font.BOLD,25));
             dateod.setText(dates+"/"+months+"/"+years);
             area=new JTextArea();
    		
             
             
             
    		panel.add(lid);
    		panel.add(tid);
    		
    		panel.add(lname);
    		panel.add(tname);
    		
    		panel.add(lvehicleno);
    		panel.add(tvehicleno);
    		
    		panel.add(laddress1);
    		panel.add(taddress1);
    		
    		panel.add(laddress2);
    		panel.add(taddress2);
    		
    		panel.add(lphoneno1);
    		panel.add(tphoneno1);
    		
    		panel.add(lphoneno2);
    		panel.add(tphoneno2);
    	
    		panel.add(ldoj);
    		panel.add(tdoj);
    		
    		panel.add(lemailid);
    		panel.add(temailid);
    		
    		panel.add(lpincode);
    		panel.add(tpincode);
    		
    		panel.add(lstate);
    		panel.add(tstate);
    		
    		
	    	
	    	panel.add(ldesignation);
	    	panel.add(tdesignation);
	    	
	    
	    	
	    	panel.add(next);
    		panel.add(prev);
    		
    		panel.add(exit);
    		
   
    		panel.add(Date);
            panel.add(dateod);
            panel.setBackground(Color.yellow);
    		
    		Date.setBounds(10,100,120,30);
            dateod.setBounds(100,100 ,180 ,30 );
      
    		
    		lid.setBounds(20,200,200,20);
    		tid.setBounds(170,200,300,17);
    		
    		lvehicleno.setBounds(20,250,200,20);
    		tvehicleno.setBounds(170,250,300,17);
    		
    		laddress2.setBounds(20,300,200,20);
    		taddress2.setBounds(170,300,300,17);
    		
    		lphoneno2.setBounds(20,350,200,20);
          	tphoneno2.setBounds(170,350,300,17);
          
          	lemailid.setBounds(20,400,200,20);
          	temailid.setBounds(170,400,300,17);
          	
          
    		
            ldesignation.setBounds(20,450,200,20);
            tdesignation.setBounds(170,450,300,17);
    		
      
          	
          	
    		lname.setBounds(530,200,200,20);
    		tname.setBounds(650,200,300,17);
    		
            laddress1.setBounds(530,250,200,20);
    		taddress1.setBounds(650,250,300,17);
    		
    		lphoneno1.setBounds(530,300,200,20);
    		tphoneno1.setBounds(650,300,300,17);
    		
          	ldoj.setBounds(530,350,200,20);
          	tdoj.setBounds(650,350,300,17);
	    	
          	lpincode.setBounds(530,400,200,20);
          	tpincode.setBounds(650,400,300,17);
	    	
        	lstate.setBounds(530,450,200,20);
          	tstate.setBounds(650,450,300,17);
          	
          	next.setBounds(200,600,140,30);
    		prev.setBounds(400,600,140,30);
            
            exit.setBounds(600,600,140,30);
           
            
            
            next.addActionListener(this);
            prev.addActionListener(this);
           
            exit.addActionListener(this);
           
          
          
            
           
            
            
            
            
    		
           }
        	catch(Exception e)
            { 
    	    JOptionPane.showMessageDialog(null,e,"error",JOptionPane.ERROR_MESSAGE);
    	
    	    }
    	    finally
            {   
    	    
    		frame.setSize(1000,700);
    		frame.setLocation(200,30);
    		frame.setVisible(true);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
            }
    
	        private Font newFont(String string)
	       {
	       return null;
	       }

    
  	@Override
          public void actionPerformed(ActionEvent event) 
    	  {
		  String message=event.getActionCommand();
		   

		  if(message.equalsIgnoreCase("Next"))
		  {
	          next();
				
		  }
	
		  else if(message.equalsIgnoreCase("Prev"))
		  {
	          prev();
				
		  }
		  
		  else if(message.equalsIgnoreCase("Exit"))
		  {
				exitframe();
			
		  }
		  
		  }
  	
   

	public void next()
     {
		
		try
		{
		
	    if(resultset.next()==true)
	    {
   	     tid.setText(String.valueOf(resultset.getInt(1)));
         tname.setText(resultset.getString(2));
 	     tvehicleno.setText(resultset.getString(3));
 	     taddress1.setText(resultset.getString(4));
 	     taddress2.setText(resultset.getString(5));
 	     tphoneno1.setText(resultset.getString(6));
 	     tphoneno2.setText(resultset.getString(7));
 	     tdoj.setText(resultset.getString(8));
 	     temailid.setText(resultset.getString(9));
 	     tpincode.setText(resultset.getString(10));
 	     tstate.setText(resultset.getString(11));
 	     tdesignation.setText(resultset.getString(12));
	    }
	    else
	    	JOptionPane.showMessageDialog(null, "This Is Last Record","LAST RECORD",JOptionPane.INFORMATION_MESSAGE);
	   
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
     }
 	 
 	   public void prev()
	   {
 		   
		
 		  try
 			{
 			
 		    if(resultset.previous()==true)
 		    {
 	   	     tid.setText(String.valueOf(resultset.getInt(1)));
 	         tname.setText(resultset.getString(2));
 	 	     tvehicleno.setText(resultset.getString(3));
 	 	     taddress1.setText(resultset.getString(4));
 	 	     taddress2.setText(resultset.getString(5));
 	 	     tphoneno1.setText(resultset.getString(6));
 	 	     tphoneno2.setText(resultset.getString(7));
 	 	     tdoj.setText(resultset.getString(8));
 	 	     temailid.setText(resultset.getString(9));
 	 	     tpincode.setText(resultset.getString(10));
 	 	     tstate.setText(resultset.getString(11));
 	 	     tdesignation.setText(resultset.getString(12));
 		    }
 		    else
 		     JOptionPane.showMessageDialog(null, "This Is First Record","FIRST RECORD",JOptionPane.INFORMATION_MESSAGE);
 		   
 			}
 			catch(Exception e)
 			{
 				System.out.println(e);
 			}
		}
	


	public void exitframe()
    {
    	frame.setVisible(false);
    }
    
//	public static void main(String[] args)
//	{
//		new AllDetails();
//	}

}
