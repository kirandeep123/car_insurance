package carinsurance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;
import java.util.Date;

public class FrontPage extends JFrame implements ActionListener
{
	JPanel panel1;
	JLabel message;
	
	MenuBarTest menubar1;	
	
	JLabel uic;
	JLabel lmessage;
	JLabel lrenew;
	JLabel lname;
	JLabel ldate;
	
	
	JTextField tname;
	JTextField tdate;
	JTextArea text1;
	
	JButton next;
	JButton prev;
	
	Dimension dimension;
	Toolkit toolkit;
	private String driverclass = "com.mysql.jdbc.Driver"; 
	private String user  = "root";
	private String password = "root";
	private String url = "jdbc:mysql://localhost:3306/";
	private String database  = "insurance";
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	private PreparedStatement prepare;
	 Date d=new Date();
	 int date1;
	 String dates;
	 int month;
	 String months;
	 int year;
	 String years;
	

	public FrontPage(String pass)
	{
		try
		{
			 date1=2+d.getDate();
             dates=Integer.toString(date1);
             month=1+d.getMonth();
             if(month>=1 & month<=9)
             {
            	 months=Integer.toString(month);
            	 months="0"+months;
             }
             else
             {
            	 months=Integer.toString(month);
             }
             year=1900+d.getYear();
             years=Integer.toString(year);
             String value=dates+"/"+months+"/"+years;
            
			
			 Class.forName(driverclass);
	    	 connection  = DriverManager.getConnection(url+database,user, password);
	    	 statement=connection.createStatement();
	    	
	    	 resultset=statement.executeQuery("SELECT  name_of_insured ,expiry_date from vehicle_details where expiry_date="+"'"+value+"'");
	    	 
	    	 
	    		
	    	 
			toolkit=Toolkit.getDefaultToolkit();
			
			dimension=toolkit.getScreenSize();
			
			
			setTitle("United Insurance Company Ltd.");
			panel1 = new JPanel(null);
		   
			lmessage = new JLabel();
			lrenew = new JLabel("People Having Insurance Renew Date Within Two Days are :-");
			 
			
			
			lname=new JLabel("Name:");
			tname=new JTextField();
			tname.setEditable(false);
		
			
			ldate=new JLabel("Expiry Date:");
			tdate=new JTextField();
			tdate.setEditable(false);
			
	
			next=new JButton("Next");
			next.setMnemonic('n');
			next.setToolTipText("Click Here To View Next Record");
			
			prev=new JButton("Prev");
			prev.setMnemonic('p');
			prev.setToolTipText("Click Here To View Previous Record");
			
			uic = new JLabel("United Insurance Co. Ltd.");
			panel1.add(uic);

			panel1.add(lmessage);
			panel1.add(lrenew);
			add(panel1);
			
			uic.setFont(new Font("Times New Roman",Font.LAYOUT_LEFT_TO_RIGHT,30));
			panel1.add(uic);
			panel1.add(tdate);
			panel1.add(ldate);
			
			panel1.add(tname);
			panel1.add(lname);
			panel1.add(next);
			panel1.add(prev);
			panel1.setBackground(Color.yellow);
			
			uic.setBounds(350,30,450,200);
			
			lrenew.setFont(new Font("Times New Roman",Font.CENTER_BASELINE,20));
			lrenew.setBounds(100,120,600,200);
			lname.setBounds(150,300,50,30);
			tname.setBounds(220,305,150,20);
			
			ldate.setBounds(470,300,70,30);
			tdate.setBounds(560,305,150,20);
			prev.setBounds(300,400,100,40);
			next.setBounds(500,400,100,40);
			menubar1=new MenuBarTest(pass);
		        panel1.add(menubar1.menubar);
	
		        lmessage.setText("<html><body text=#003399>&copy Copyright : United Insurance Co. Ltd. 2013</body></html>");	      
		        lmessage.setBounds(100,600,1200,50);
		  
			next.addActionListener(this);
			prev.addActionListener(this);
			while(resultset.next())
			{  
				
			
				tname.setText(resultset.getString(1));
				tdate.setText(resultset.getString(2));
				break;
				
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		finally
		{
			        setSize(1000,700);
    		        setLocation(200,30);
    		        setVisible(true);
  		            setDefaultCloseOperation(EXIT_ON_CLOSE);
		}}
		public void actionPerformed(ActionEvent e) 
		{
			String m=e.getActionCommand();
			if(m.equals("Next"))
			{ 
				try {
					if(resultset.next()==true)
					{
						tname.setText(resultset.getString(1));
						tdate.setText(resultset.getString(2));
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "This Is Last Record","LAST RECORD",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				if(m.equals("Prev"))
				{
					try {
						if(resultset.previous()==true)
						{
							tname.setText(resultset.getString(1));
							tdate.setText(resultset.getString(2));
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "This Is First Record","FIRST RECORD",JOptionPane.INFORMATION_MESSAGE);
						}
					} 
					catch (SQLException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			
		}

		
	

//	public static void main(String[] args)
//	{
//		
//           new FrontPage();
//    
//	}

	
	}

	
