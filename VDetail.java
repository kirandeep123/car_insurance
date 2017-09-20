package carinsurance;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;

public class VDetail extends JFrame implements ActionListener
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
	
	private String selectid = "select * from vehicle_details";
	
	
   
	
	JLabel lid;
	JLabel message;
	JTextField tid;
	JButton ok;
	JButton cancel;
	JPanel panel;
	JFrame frame;
    String p=null;
	public VDetail (String pa)
	{ 
		p=pa;
		
		try
		{
			frame=new JFrame();
		frame.setTitle("VEHICLE DETAILS");
		message=new JLabel("Enter Vehicle Serial No. Here ");
		message.setFont(new Font("Arial",Font.BOLD,30));
		message.setForeground(Color.DARK_GRAY);
		
	    panel=new JPanel(null);
        frame.add(panel);
	    message.setBounds(90,10,500,70);
		panel.add(message);
		lid=new JLabel("Enter Sr No.:");
		lid.setBounds(150,100,120,40);
		lid.setFont(new Font("Arial",Font.BOLD,15));
		tid=new JTextField();
		tid.setBounds(250,110,140,20);
		ok=new JButton("OK");
		ok.setBounds(170,200,80,40);
		ok.setMnemonic('o');
		ok.setToolTipText("Click Ok To View");
		cancel=new JButton("CANCEL");
		cancel.setBounds(350,200,90,40);
		cancel.setMnemonic('c');
		cancel.setToolTipText("Click to Cancel");
		panel.add(lid);
		panel.add(tid);
		panel.add(ok);
		panel.add(cancel);
		
		panel.setBackground(Color.yellow);
		cancel.addActionListener(this);
		ok.addActionListener(this);
		
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		finally
		{
			frame.setVisible(true);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setSize(600,300);
    		frame.setLocation(350,150);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String m=arg0.getActionCommand();
		if(m.equals("OK"))
		{
			try
			{
			Class.forName(driverclass);
			connection=DriverManager.getConnection(url+database,user,password);
			statement=connection.createStatement();
			resultset=statement.executeQuery(selectid);
			boolean flag=false;
			
			while(resultset.next())
			{
				String a=resultset.getString(1);
			    if(a.equalsIgnoreCase(tid.getText()))
					{
			    	  flag=true;
				      frame.setVisible(false);
			    	 // new VDetail(p,tid.getText());
				     
					}
			   
		
			}
			 if(flag==false)
				{
				    tid.setText("");
					JOptionPane.showMessageDialog(null, "Your Sr No. Is Wrong","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		if(m.equals("CANCEL"))
		{
			frame.setVisible(false);
		}
		
		
	}
}

