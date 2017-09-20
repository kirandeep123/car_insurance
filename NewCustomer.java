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


import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.Date;




public class NewCustomer extends JFrame implements ActionListener
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
		
	
		private String tablecraete = "create table if not exists customer_details(id int,name varchar(50),fathername varchar(50),address1 varchar(50),adress2 varchar(50),phnno1 varchar(20),phnno2 varchar(15),doj varchar(50),emailid varchar(50),pincode varchar(50),state varchar(50),designation varchar(50),primary key(id)) ";
		private String insert = "insert into customer_details values(?,?,?,?,?,?,?,?,?,?,?,?)";
		private String selectid = "select * from customer_details where id = ?";
		
		
       
		
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
	   
	    JButton new;
	    JButton save;
	   
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
		public NewCustomer(String pas)
	    {
	    	try
	    	{
	    		toolkit=Toolkit.getDefaultToolkit();
	    		dimension=toolkit.getScreenSize();
	    		
	    		frame=new JFrame();
	    		message=new JLabel(" Enter New Customer Details here ");
	    		message.setFont(new Font("Arial",Font.BOLD,30));
	    		message.setForeground(Color.DARK_GRAY);
	    		
	    		frame.setTitle("NEW CUSTOMER ");
	    	    panel=new JPanel(null);
	            frame.add(panel);
	    	    message.setBounds(250,10,900,70);
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
	    		
	    	    lname=new JLabel("Name");
		        tname=new JTextField(40);
	           
		        lvehicleno=new JLabel("Father Name");
		        tvehicleno=new JTextField(40); 
		        
		        laddress1=new JLabel("Residential Address");
		        taddress1=new JTextField(40);
	    		
		        laddress2=new JLabel("Office/Business Address");
		        taddress2=new JTextField(40);
		        
		        lphoneno1=new JLabel("Phone No.");
	    	    tphoneno1=new JTextField(40);
		        
	    	    lphoneno2=new JLabel("Mobile No.");
	    	    tphoneno2=new JTextField(40);
	    	   
	    	    ldoj=new JLabel("Date Of Joining");
	    	    tdoj=new JTextField(40);
	    	    
	    	    lemailid=new JLabel("E-mailId");
	    	    temailid=new JTextField(40);
	    	    
	    	    lpincode=new JLabel("Pincode");
	    	    tpincode=new JTextField(40);
	    	    
	    	    lstate=new JLabel("State");
	    	    tstate=new JTextField(40);
	    	    
	    	    ldesignation=new JLabel("Designation");
	    	    tdesignation=new JTextField(40);
	    	    
	    
	    	    
	    	  
	    	    
		        newaccount=new JButton("New");
		        newaccount.setMnemonic('n');
		        newaccount.setToolTipText("Click here For New Record");
	    		save=new JButton("Save");
	    		save.setMnemonic('s');
	    		save.setToolTipText("Click here For Save");
	    		
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
		    	
		    
		    	
		    	panel.add(newaccount);
	    		panel.add(save);
	    		
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
              	
              	newaccount.setBounds(200,600,140,30);
	    		save.setBounds(400,600,140,30);
	           
	            exit.setBounds(600,600,140,30);
	           
	           
	            newaccount.addActionListener(this);
	            save.addActionListener(this);
	            
	            exit.addActionListener(this);
	           
	          
	            tid.addKeyListener(new KeyAdapter()
	    		{
	    			public void keyPressed(KeyEvent EVT)
	    			{
	    				String value=tid.getText();
	    				int l=value.length();
	    			 
	    				if(EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' || EVT.getKeyCode()==8 )
	    				{
	    				}
	    				else
	    				{
	    						JOptionPane.showMessageDialog(null,"Id Does Not Cointain Alphabetic Value ","ERROR",JOptionPane.ERROR_MESSAGE);
	    						tid.setText("");
	    				}
	    			}
	    		});
	    		
	            
	            tname.addKeyListener(new KeyAdapter()
	    		{
	    			public void keyPressed(KeyEvent EVT)
	    			{
	    				String value=tname.getText();
	    				int l=value.length();
	    			 
	    				if(EVT.getKeyChar() >= 'A' && EVT.getKeyChar() <= 'Z' || EVT.getKeyChar() >= 'a' && EVT.getKeyChar() <= 'z' || EVT.getKeyCode()==8 || EVT.getKeyCode()==32)
	    				{
	    				}
	    				else
	    				{
	    						JOptionPane.showMessageDialog(null,"Name Does Not Contain Digit or Special Charactor ","ERROR",JOptionPane.ERROR_MESSAGE);
	    						tname.setText("");
	    				}
	    			}
	    		});
	    		
	           
	            
	            tvehicleno.addKeyListener(new KeyAdapter()
	    		{
	    			public void keyPressed(KeyEvent EVT)
	    			{
	    				String value=tvehicleno.getText();
	    				int l=value.length();
	    			 
	    				if(EVT.getKeyChar() >= 'A' && EVT.getKeyChar() <= 'Z' || EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9'||EVT.getKeyChar()>='a' & EVT.getKeyChar()<='z' || EVT.getKeyCode()==8 || EVT.getKeyCode()==32)
	    				{
	    				}
	    				else
	    				{
	    						JOptionPane.showMessageDialog(null,"Father Name Does Not Cointain Digit or Special Charactor ","ERROR",JOptionPane.ERROR_MESSAGE);
	    						tvehicleno.setText("");
	    				}
	    			}
	    		});
	    		
	            tphoneno1.addKeyListener(new KeyAdapter()
	    		{
	    			public void keyPressed(KeyEvent EVT)
	    			{
	    				String value=tphoneno1.getText();
	    				int l=value.length();
	    			 
	    				if(EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' || EVT.getKeyCode()==8 || EVT.getKeyCode()==45 )
	    				{
	    				}
	    				else
	    				{
	    						JOptionPane.showMessageDialog(null,"phoneno Does Not Cointain Albhabetic Value ","ERROR",JOptionPane.ERROR_MESSAGE);
	    						tphoneno1.setText("");
	    				}
	    			}
	    		});
	    		
	            tphoneno2.addKeyListener(new KeyAdapter()
	    		{
	    			public void keyPressed(KeyEvent EVT)
	    			{
	    				String value=tphoneno2.getText();
	    				int l=value.length();
	    			 
	    				if(EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' || EVT.getKeyCode()==8 || EVT.getKeyCode()==45 )
	    				{
	    				}
	    				else
	    				{
	    						JOptionPane.showMessageDialog(null,"Mobileno Does Not Cointain Albhabetic Value ","ERROR",JOptionPane.ERROR_MESSAGE);
	    						tphoneno2.setText("");
	    				}
	    			}
	    		});
	            
	            tpincode.addKeyListener(new KeyAdapter()
	    		{
	    			public void keyPressed(KeyEvent EVT)
	    			{
	    				String value=tpincode.getText();
	    				int l=value.length();
	    			 
	    				if(EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' || EVT.getKeyCode()==8 || EVT.getKeyCode()==45 )
	    				{
	    				}
	    				else
	    				{
	    						JOptionPane.showMessageDialog(null,"Pincode Does Not Cointain Albhabetic Value ","ERROR",JOptionPane.ERROR_MESSAGE);
	    						tpincode.setText("");
	    				}
	    			}
	    		});
	            
	        
	           
	            tstate.addKeyListener(new KeyAdapter()
	    		{
	    			public void keyPressed(KeyEvent EVT)
	    			{
	    				String value=tstate.getText();
	    				int l=value.length();
	    			 
	    				if(EVT.getKeyChar() >= 'A' && EVT.getKeyChar() <= 'Z' || EVT.getKeyChar() >= 'a' && EVT.getKeyChar() <= 'z' || EVT.getKeyCode()==8 || EVT.getKeyCode()==32)
	    				{
	    				}
	    				else
	    				{
	    						JOptionPane.showMessageDialog(null,"State Does Not Cointain Digit or Special Charactor ","ERROR",JOptionPane.ERROR_MESSAGE);
	    						tstate.setText("");
	    				}
	    			}
	    		});
	            
	           
	            
	            
	            
	            
	            
	            
	    		
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
			   

			  if(message.equalsIgnoreCase("New"))
			  {
		          newaccount();
					
			  }
		
			  else if(message.equalsIgnoreCase("Save"))
			  {
		          save();
					
			  }
			 
			  else if(message.equalsIgnoreCase("Exit"))
			  {
					exitframe();
				
			  }
			
			  }
	  	
	   

		public void newaccount()
	     {
	    	
	   	 tid.setText("");
	     tname.setText("");
     	 tvehicleno.setText("");
     	 taddress1.setText("");
     	 taddress2.setText("");
     	 tphoneno1.setText("");
     	 tphoneno2.setText("");
     	 tdoj.setText("");
     	 temailid.setText("");
     	 tpincode.setText("");
     	 tstate.setText("");
     	 tdesignation.setText("");
     	 
	     }
     	 
     	   public void save()
		   {
			try
			{
				Class.forName(driverclass);
				connection  = DriverManager.getConnection(url+database,user, password);
				statement=connection.createStatement();
				int r=statement.executeUpdate(tablecraete);
				prepare=connection.prepareStatement(insert);
				
				if(tid.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null,"Please enter ID Number","ERROR",JOptionPane.INFORMATION_MESSAGE);
				     return;
				}
				
			
				if(tname.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null,"Please enter Name","ERROR",JOptionPane.INFORMATION_MESSAGE);
				     return;
				}
				
			
				if(tvehicleno.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null,"Please enter Father / Husband Name","ERROR",JOptionPane.INFORMATION_MESSAGE);
				     return;
				}
				
				if(taddress1.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null,"Please enter Residential Address","ERROR",JOptionPane.INFORMATION_MESSAGE);
				     return;
				}
				
				if(taddress2.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null,"Please enter Office or Business Address","ERROR",JOptionPane.INFORMATION_MESSAGE);
				     return;
				}
			
				if(tphoneno1.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null,"Please enter Telephoneno","ERROR",JOptionPane.INFORMATION_MESSAGE);
				     return;
				}
			
				if(tdoj.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null,"Please enter D_O_B","ERROR",JOptionPane.INFORMATION_MESSAGE);
				     return;
				}
				
				id=Integer.parseInt(tid.getText());
		        name=tname.getText();
				fathername=tvehicleno.getText();
				address1=taddress1.getText();
				address2=taddress2.getText();
				phoneno1=tphoneno1.getText();
				phoneno2=tphoneno2.getText();
				doj=tdoj.getText();
				emailid=temailid.getText();
				pincode=tpincode.getText();
				state=tstate.getText();
				designation=tdesignation.getText();
			
				
				
			
				prepare.setInt(1,id);
				prepare.setString(2,name);
				prepare.setString(3,fathername);
				prepare.setString(4,address1);
				prepare.setString(5,address2);
				prepare.setString(6,phoneno1);
				prepare.setString(7,phoneno2);
				prepare.setString(8,doj);
				prepare.setString(9,emailid);
				prepare.setString(10,pincode);
				prepare.setString(11,state);
				prepare.setString(12,designation);
			
			
				prepare.executeUpdate();
			
		     JOptionPane.showMessageDialog(null,"Record Saved in DataBase","save",JOptionPane.INFORMATION_MESSAGE);
		     
		     tid.setText("");
		     tname.setText("");
	     	 tvehicleno.setText("");
	     	 taddress1.setText("");
	     	 taddress2.setText("");
	     	 tphoneno1.setText("");
	     	 tphoneno2.setText("");
	     	 tdoj.setText("");
	     	 temailid.setText("");
	     	 tpincode.setText("");
	     	 tstate.setText("");
	     	 tdesignation.setText("");
	     	 
		     
				new VehicleDetails(p);
				frame.setVisible(false);
			}
			catch(Exception e)
			{
				 JOptionPane.showMessageDialog(null,e,"error",JOptionPane.ERROR_MESSAGE);
			
				
			}
			finally
			{
				try
				{
					prepare.close();
					connection.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
				}
			
				
			}
		
	
		

		public void exitframe()
	    {
	    	frame.setVisible(false); 
	    }
	    
//		public static void main(String[] args)
//		{
//			new NewCustomer();
//		}
	}


	

