package carinsurance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class VehicleDetails extends JFrame implements ActionListener 
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
	

	private String tablecraete = "create table if not exists vehicle_details(sr_no varchar(50),vehicle_no varchar(50),year_of_mfg varchar(50),engine_no varchar(50),chasis_no varchar(50),mobno varchar(20),name_of_insured varchar(15),Address_of_insured varchar(50),start_date_of_ins varchar(50),total_amount varchar(50),expiry_date varchar(50),date_of_issue varchar(50),primary key(sr_no)) ";
	private String insert = "insert into vehicle_details values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private String selectid = "select * from vehicle_details where id = ?";
	
	
   

    String srno=""; 
    String vehicleno="";
    String yrofmfg="";
    String engno="";
    String chasisno="";
    String mobno="";
    String name="";
    String address="";
    String start_date="";
    String totalamt="";
    String exp_date="";
    String iss_date="";
   
    
    
    JLabel lsrno;
    JLabel lvhno;
    JLabel lyrmfg;
    JLabel lengno;
    JLabel lchano;
    JLabel lmobno;
    JLabel lname;
    JLabel ladd;
    JLabel lst;
    JLabel ltot;
    JLabel lexp;
    JLabel letyp;
    JLabel liss;
 
    
    Dimension dimension;
    Toolkit toolkit;
    
    JTextField tsrno;
    JTextField tvhno;
    JTextField tyrmfg;
    JTextField tengno;
    JTextField tchano;
    JTextField tmobno;
    JTextField tname;
    JTextField tadd;
    JTextField tst;
    JTextField ttot;
    JTextField texp;
    JTextField tiss;
  
    
    JPanel panel;
    JFrame frame;
    JLabel message;
   
   
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
	public VehicleDetails(String pa)
    {
    	p=pa;
    	try
    	{
    		toolkit=Toolkit.getDefaultToolkit();
    		dimension=toolkit.getScreenSize();
    		
    		frame=new JFrame();
    		frame.setTitle("VEHICLE DETAILS ");
    		message=new JLabel(" Enter Vehicle Details here ");
    		message.setFont(new Font("Arial",Font.BOLD,30));
    		message.setForeground(Color.DARK_GRAY);
    		
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
         
    		
            lsrno=new JLabel("Sr No.");
    	    tsrno=new JTextField(40);
    	    tsrno.setFont(new Font("Arial",Font.BOLD,10));
    		
    	    lname=new JLabel("Name Of Insuree");
	        tname=new JTextField(40);
           
	        lvhno=new JLabel("Vehicle No.");
	        tvhno=new JTextField(40); 
	        
	        lyrmfg=new JLabel("Year Of Manufacturing");
	        tyrmfg=new JTextField(40);
    		
	        lchano=new JLabel("Chasis No.");
	        tchano=new JTextField(40);
	        
	        lengno=new JLabel("Engine No.");
    	    tengno=new JTextField(40);
	        
    	    lmobno=new JLabel("Mobile No.");
    	    tmobno=new JTextField(40);
    	   
    	    ladd=new JLabel("Adress Of Insuree");
    	    tadd=new JTextField(40);
    	    
    	    lst=new JLabel("Start Date");
    	    tst=new JTextField(40);
    	    
    	    ltot=new JLabel("Total Amount");
    	    ttot=new JTextField(40);
    	    
    	    lexp=new JLabel("Expiry Date");
    	    texp=new JTextField(40);
    	    letyp=new JLabel("  Input Expiry Date As DD/MM/YYYY ");
    	    
    	    liss=new JLabel("Issue Date");
    	    tiss=new JTextField(40);
    	    
    
    	    
    	  
    	    
	      
    		save=new JButton("Save");
    		save.setMnemonic('s');
    		save.setToolTipText("Click here For Save");
    	
    		exit=new JButton("Exit");
    		exit.setMnemonic('e');
    		exit.setToolTipText("Click Here Go To Home Page");
    		
    		
    		 Date=new JLabel("DATE");
             Date.setFont(new Font("Courier New",Font.BOLD,25));
             dateod= new JLabel();
             dateod.setFont(new Font("Courier New",Font.BOLD,25));
             dateod.setText(dates+"/"+months+"/"+years);
             area=new JTextArea();
    		
             
             
             
    		panel.add(lsrno);
    		panel.add(tsrno);
    		
    		panel.add(lname);
    		panel.add(tname);
    		
    		panel.add(lvhno);
    		panel.add(tvhno);
    		
    		panel.add(lyrmfg);
    		panel.add(tyrmfg);
    		
    		panel.add(lchano);
    		panel.add(tchano);
    		
    		panel.add(lengno);
    		panel.add(tengno);
    		
    		panel.add(lmobno);
    		panel.add(tmobno);
    	
    		panel.add(lst);
    		panel.add(tst);
    		
    		panel.add(ladd);
    		panel.add(tadd);
    		
    		panel.add(liss);
    		panel.add(tiss);
    		
    		panel.add(ltot);
    		panel.add(ttot);
    		panel.add(letyp);
    		
	    	
	    	panel.add(lexp);
	    	panel.add(texp);
	    	
	    
	    	
	    	
    		panel.add(save);
    		
    		panel.add(exit);
    		
   
    		panel.add(Date);
            panel.add(dateod);
            
            panel.setBackground(Color.yellow);
    		
    		Date.setBounds(10,100,120,30);
            dateod.setBounds(100,100 ,180 ,30 );
      
    		
    		lsrno.setBounds(20,200,200,20);
    		tsrno.setBounds(170,200,300,17);
    		
    		lvhno.setBounds(20,250,200,20);
    		tvhno.setBounds(170,250,300,17);
    		
    		ladd.setBounds(20,300,200,20);
    		tadd.setBounds(170,300,300,17);
    		
    		lname.setBounds(20,350,200,20);
          	tname.setBounds(170,350,300,17);
          
          	lchano.setBounds(20,400,200,20);
          	tchano.setBounds(170,400,300,17);
          	
          
    		
            lengno.setBounds(20,450,200,20);
            tengno.setBounds(170,450,300,17);
    		
      
          	
          	
    		lmobno.setBounds(530,200,200,20);
    		tmobno.setBounds(670,200,300,17);
    		
            lst.setBounds(530,250,200,20);
    		tst.setBounds(670,250,300,17);
    		
    		lexp.setBounds(530,300,200,20);
    		texp.setBounds(670,300,300,17);
    		letyp.setBounds(670,310,300,30);
    		
          	ltot.setBounds(530,350,200,20);
          	ttot.setBounds(670,350,300,17);
	    	
          	liss.setBounds(530,400,200,20);
          	tiss.setBounds(670,400,300,17);
	    	
        	lyrmfg.setBounds(530,450,200,20);
          	tyrmfg.setBounds(670,450,300,17);
          	
         
    		save.setBounds(300,600,140,30);
            
            exit.setBounds(600,600,140,30);
            
           
           
            save.addActionListener(this);
            
            exit.addActionListener(this);
         
          
            
    		
            
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
    						JOptionPane.showMessageDialog(null,"Name Does Not Cointain Digit or Special Charactor ","ERROR",JOptionPane.ERROR_MESSAGE);
    						tname.setText("");
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
		   

		
	
		  if(message.equalsIgnoreCase("Save"))
		  {
	          save();
				
		  }
		 
		  if(message.equalsIgnoreCase("Exit"))
		  {
				frame.setVisible(false);
			
		  }
		
		  
		  }
  	
   
 	   public void save()
	   {
		try
		{
			Class.forName(driverclass);
			connection = DriverManager.getConnection(url+database,user, password);
			statement=connection.createStatement();
			int r=statement.executeUpdate(tablecraete);
			prepare=connection.prepareStatement(insert);
			
			if(tsrno.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(null,"Please enter Serial Number","ERROR",JOptionPane.INFORMATION_MESSAGE);
			     return;
			}
			
		
			if(tname.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(null,"Please enter Name","ERROR",JOptionPane.INFORMATION_MESSAGE);
			     return;
			}
			
		
			if(tvhno.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(null,"Please enter Vehicle Number","ERROR",JOptionPane.INFORMATION_MESSAGE);
			     return;
			}
			
			if(tadd.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(null,"Please enter Residential Address","ERROR",JOptionPane.INFORMATION_MESSAGE);
			     return;
			}
			
			if(texp.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(null,"Please enter Insurance Expiry Date","ERROR",JOptionPane.INFORMATION_MESSAGE);
			     return;
			}
		
			if(tmobno.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(null,"Please enter Mobile Number","ERROR",JOptionPane.INFORMATION_MESSAGE);
			     return;
			}
		
			if(tiss.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(null,"Please enter Issue Date","ERROR",JOptionPane.INFORMATION_MESSAGE);
			     return;
			}
			
			srno=tsrno.getText();
	        name=tname.getText();
			chasisno=tchano.getText();
			address=tadd.getText();
			mobno=tmobno.getText();
			vehicleno=tvhno.getText();
			yrofmfg=tyrmfg.getText();
			engno=tengno.getText();
			start_date=tst.getText();
			totalamt=ttot.getText();
			exp_date=texp.getText();
			iss_date=tiss.getText();
		
			
			
		
			prepare.setString(1,srno);
			prepare.setString(2,vehicleno);
			prepare.setString(3,yrofmfg);
			prepare.setString(4,engno);
			prepare.setString(5,chasisno);
			prepare.setString(6,mobno);
			prepare.setString(7,name);
			prepare.setString(8,address);
			prepare.setString(9,start_date);
			prepare.setString(10,totalamt);
			prepare.setString(11,exp_date);
			prepare.setString(12,iss_date);
		
		
			prepare.executeUpdate();
		
	     JOptionPane.showMessageDialog(null,"Record Saved in DataBase","save",JOptionPane.INFORMATION_MESSAGE);
	     
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
			{}
			
			}
		
			
		}
	

	

	public void exitframe()
    {
    frame.setVisible(false);
    }
    
//	public static void main(String[] args)
//	{
//		new VehicleDetails();
//	}
}

