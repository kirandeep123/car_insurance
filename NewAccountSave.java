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

public class NewAccountSave extends JFrame implements ActionListener 
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
	
	private String insert="insert into account_manager values(?,?)";
	
	
   
	
	JLabel lid;
	JLabel message;
	JPasswordField tid;
	JButton ok;
	JButton cancel;
	JPanel panel;
	JFrame frame;
	String name=null, npass=null,opass=null;
	public NewAccountSave (String apass,String nam ,String pass1)
	{
		opass=apass;
		name=nam;
		npass=pass1;
		try
		{
			frame=new JFrame();
		frame.setTitle("SAVE NEW ACCOUNT ");
		message=new JLabel("Enter Currently Login Account Password");
		message.setFont(new Font("Arial",Font.BOLD,30));
		message.setForeground(Color.DARK_GRAY);
		
	    panel=new JPanel(null);
        frame.add(panel);
	    message.setBounds(50,10,700,70);
		panel.add(message);
		lid=new JLabel("Enter Password:");
		lid.setBounds(200,100,120,40);
		lid.setFont(new Font("Arial",Font.BOLD,15));
		tid=new JPasswordField();
		tid.setBounds(350,100,90,30);
		tid.setEchoChar('*');
		ok=new JButton("OK");
		ok.setBounds(220,180,80,40);
		ok.setMnemonic('o');
		ok.setToolTipText("Click Ok To Save");
		cancel=new JButton("CANCEL");
		cancel.setBounds(350,180,90,40);
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
			frame.setSize(700,300);
    		frame.setLocation(350,150);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String m=arg0.getActionCommand();
		if(m.equals("OK"))
		{
			if(opass.equals(tid.getText()))
			{
			try
			{
			Class.forName(driverclass);
			connection=DriverManager.getConnection(url+database,user,password);
			prepare=connection.prepareStatement(insert);
			
			boolean flag=false;
			prepare.setString(1, name);
			prepare.setString(2, npass);
			
			prepare.executeUpdate();
			  JOptionPane.showMessageDialog(null, "Account Created","SAVED",JOptionPane.INFORMATION_MESSAGE);
			  frame.setVisible(false);
			}
		
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
			else
			{
				tid.setText("");
				JOptionPane.showMessageDialog(null,"Login Password Is Not Correct","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(m.equals("CANCEL"))
		{
			frame.setVisible(false);
		}
		
		
	}
//	public static void main(String[] args) {
//		new UpdateCustomerId();
//	}
	 

}

