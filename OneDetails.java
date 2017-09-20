package carinsurance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import java.sql.*;

public class OneDetails extends JFrame implements ActionListener
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
    int i;
    String p=null;
    @SuppressWarnings("deprecation")
	public OneDetails(int idi,String pas)
    { 
    	i=idi;
    	try
    	{
    	
			Class.forName(driverclass);
			connection=DriverManager.getConnection(url+database,user,password);
			statement=connection.createStatement();
			resultset=statement.executeQuery("select * from customer_details where id="+idi);
			while(resultset.next())
			{
		    
    		toolkit=Toolkit.getDefaultToolkit();
    		dimension=toolkit.getScreenSize();
    		
    		frame=new JFrame();
    		frame.setTitle("CUSTOMER DETAILS");
    		message=new JLabel(" Customer Details ");
    		message.setFont(new Font("Arial",Font.BOLD,40));
    		message.setForeground(Color.DARK_GRAY);
    		
    	    panel=new JPanel(null);
            frame.add(panel);
    	    message.setBounds(300,10,900,70);
    		panel.add(message);
    		
    		
    		
    		 date1=d.getDate();
             dates=Integer.toString(date1);
             month=1+d.getMonth();
             months=Integer.toString(month);
             year=1900+d.getYear();
             years=Integer.toString(year);
             String value=dates;
 
            
            lid=new JLabel("Id");
    	    tid=new JTextField();
            tid.setText(String.valueOf(resultset.getInt(1)));    	    
    	    tid.setFont(new Font("Arial",Font.BOLD,10));
    	    tid.setEditable(false);
    		
    	    lname=new JLabel("Name");
	        tname=new JTextField(40);
	        tname.setText(resultset.getString(2));
	        tname.setEditable(false);
           
	        lvehicleno=new JLabel("Father Name");
	        tvehicleno=new JTextField(40); 
	        tvehicleno.setText(resultset.getString(3));
	        tvehicleno.setEditable(false);
	        
	        laddress1=new JLabel("Residential Address");
	        taddress1=new JTextField(40);
	        taddress1.setText(resultset.getString(4));
	        taddress1.setEditable(false);
    		
	        laddress2=new JLabel("Office/Business Address");
	        taddress2=new JTextField(40);
	        taddress2.setText(resultset.getString(5));
	        taddress2.setEditable(false);
	        
	        lphoneno1=new JLabel("Phone No.");
    	    tphoneno1=new JTextField(40);
    	    tphoneno1.setText(resultset.getString(6));
    	    tphoneno1.setEditable(false);
    	    
    	    lphoneno2=new JLabel("Mobile No.");
    	    tphoneno2=new JTextField(40);
    	    tphoneno2.setText(resultset.getString(7));
    	    tphoneno2.setEditable(false);
    	   
    	    ldoj=new JLabel("Date Of Joining");
    	    tdoj=new JTextField(40);
    	    tdoj.setText(resultset.getString(8));
    	    tdoj.setEditable(false);
    	    
    	    lemailid=new JLabel("E-mailId");
    	    temailid=new JTextField(40);
    	    temailid.setText(resultset.getString(9));
    	    temailid.setEditable(false);
    	    
    	    lpincode=new JLabel("Pincode");
    	    tpincode=new JTextField(40);
    	    tpincode.setText(resultset.getString(10));
    	    tpincode.setEditable(false);
    	    
    	    lstate=new JLabel("State");
    	    tstate=new JTextField(40);
    	    tstate.setText(resultset.getString(11));
    	    tstate.setEditable(false);
    	    
    	    ldesignation=new JLabel("Designation");
    	    tdesignation=new JTextField(40);
    	    tdesignation.setText(resultset.getString(12));
    	    tdesignation.setEditable(false);
    	    
			}
    	    
    	  
    	  
    		
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
          	
          	
    		
            exit.setBounds(400,600,140,30);
           
          
           
           
           
          
            exit.addActionListener(this);
           
           
          
            
            
            
            
            
            
    		
           }
        	catch(Exception e)
            { 
    	    JOptionPane.showMessageDialog(null,e,"error",JOptionPane.ERROR_MESSAGE);
    	
    	    }
    	    finally
            {   
    	   
    		frame.setVisible(true);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setSize(1000,700);
    		frame.setLocation(200,30);
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
		   

		 
	
		
		 
		  if(message.equalsIgnoreCase("Exit"))
		  {
				exitframe();
			
		  }
		 
		  
		  }
  	
   

	
 	 
 	 
	

	
	  
	

	public void exitframe()
    {
    	frame.setVisible(false);
    }
    
	
}




