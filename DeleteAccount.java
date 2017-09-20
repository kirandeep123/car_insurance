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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class DeleteAccount extends JFrame implements ActionListener
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
	
	
	private String selectid = "select * from account_manager";
	
	
   
	
	JLabel lname;
	JLabel lpass;
	JLabel lrpass;
	JLabel message;
	JTextField tname;
	JPasswordField tpass;
	JPasswordField trpass;
	JButton login;
	JButton cancel;
	JPanel panel;
	JFrame frame;
	public DeleteAccount() 
	{
	 try
		{
		 frame=new JFrame();
		frame.setTitle("DELETE ACCOUNT");
		message=new JLabel("Enter Name And Password Here To Delete An Account");
		message.setFont(new Font("Arial",Font.BOLD,20));
		message.setForeground(Color.DARK_GRAY);
		
	    panel=new JPanel(null);
        frame.add(panel);
	    message.setBounds(30,10,550,70);
		panel.add(message);
		lname=new JLabel("Enter Name:");
		lname.setBounds(150,100,100,40);
		lname.setFont(new Font("Arial",Font.BOLD,15));
		tname=new JTextField();
		tname.setBounds(300,110,130,20);
		lpass=new JLabel("Enter Password:");
		lpass.setBounds(150,150,130,40);
		lpass.setFont(new Font("Arial",Font.BOLD,15));
		tpass=new JPasswordField();
		tpass.setBounds(300,160,130,20);
		tpass.setEchoChar('*');
		lrpass=new JLabel("Re-Enter Password:");
		lrpass.setBounds(150,200,150,40);
		lrpass.setFont(new Font("Arial",Font.BOLD,15));
		trpass=new JPasswordField();
		trpass.setBounds(300,210,130,20);
		trpass.setEchoChar('*');
		login=new JButton("DELETE");
		login.setBounds(160,280,80,40);
		login.setMnemonic('d');
		login.setToolTipText("Click Ok To Delete");
		cancel=new JButton("CANCEL");
		cancel.setBounds(330,280,90,40);
		cancel.setMnemonic('c');
		cancel.setToolTipText("Click to Cancel");
		panel.add(lname);
		panel.add(tname);
		panel.add(lpass);
		panel.add(tpass);
		panel.add(lrpass);
		panel.add(trpass);
		panel.add(login);
		panel.add(cancel);
		panel.setBackground(Color.yellow);
		cancel.addActionListener(this);
		login.addActionListener(this);
		tname.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
			   if(e.getKeyChar()>='A'& e.getKeyChar()<='Z' ||e.getKeyChar()>='a'& e.getKeyChar()<='z'|| e.getKeyCode()==8 || e.getKeyCode()==32)
			   {
				   
			   }
			   else
			   {
				   
			  JOptionPane.showMessageDialog(null, "Numeric Values Are Not Allowed","Error",JOptionPane.ERROR_MESSAGE);
			
			   }
			}
		});
		
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e,"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		finally
		{
			frame.setVisible(true);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.setSize(600,400);
    		frame.setLocation(350,150);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String m=arg0.getActionCommand();
		if(m.equals("DELETE"))
		{
			if(tpass.getText().equals(trpass.getText()))
			{
				
            String pass=tpass.getText();				
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
				String b=resultset.getString(2);
			    if(a.equalsIgnoreCase(tname.getText()) &  b.equalsIgnoreCase(tpass.getText()) )
					{
			    	 flag=true;
			    	prepare=connection.prepareStatement("delete  from account_manager where name="+"'"+tname.getText()+"'"+"and password="+"'"+tpass.getText()+"'");
				     int r=prepare.executeUpdate();
				     if(r>0)
				     {
				    	 
				    	 JOptionPane.showMessageDialog(null, "Account Deleted","DELETE",JOptionPane.INFORMATION_MESSAGE);
				    	 frame.setVisible(false);
					 }
				     }
			   
		
			}
			 if(flag==false)
				{
				    tname.setText("");
				    tpass.setText("");
				    trpass.setText("");
					JOptionPane.showMessageDialog(null, "You Are Not An Valid User","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			}
			else
			{
				tpass.setText("");
				trpass.setText("");
				JOptionPane.showMessageDialog(null, "Password And Re-enter Password Are Not Equal","NOT EQUAL",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(m.equals("CANCEL"))
		{
			frame.setVisible(false);
		}
		
		
	}
  

	public static void main(String[] args) 
	{
		new DeleteAccount();
	}


