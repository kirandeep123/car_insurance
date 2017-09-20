package carinsurance;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;

public class DeleteCustomer extends JFrame implements ActionListener
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
	JLabel message;
	JTextField tid;
	JButton ok;
	JButton cancel;
	JPanel panel;
	JFrame frame;
	String p=null;
	public DeleteCustomer (String pa)
	{
		p=pa;
		try
		{
			frame=new JFrame();
		frame.setTitle("DELETE CUSTOMER ");
		message=new JLabel("Enter Customer Id No. Here ");
		message.setFont(new Font("Arial",Font.BOLD,30));
		message.setForeground(Color.DARK_GRAY);
		
	    panel=new JPanel(null);
       frame.add(panel);
	    message.setBounds(100,10,500,70);
		panel.add(message);
		lid=new JLabel("Enter Id:");
		lid.setBounds(150,100,70,40);
		lid.setFont(new Font("Arial",Font.BOLD,15));
		tid=new JTextField();
		tid.setBounds(300,110,130,20);
		ok=new JButton("DELETE");
		ok.setBounds(150,200,80,40);
		ok.setMnemonic('d');
		ok.setToolTipText("Click Ok To Delete");
		cancel=new JButton("CANCEL");
		cancel.setBounds(330,200,90,40);
		cancel.setMnemonic('c');
		cancel.setToolTipText("Click to Cancel");
		panel.setBackground(Color.yellow);
		panel.add(lid);
		panel.add(tid);
		panel.add(ok);
		panel.add(cancel);
		cancel.addActionListener(this);
		ok.addActionListener(this);
		tid.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
			   if(e.getKeyChar()>='0'& e.getKeyChar()<='9' || e.getKeyCode()==8 || e.getKeyCode()==45)
			   {
				   
			   }
			   else
				   JOptionPane.showMessageDialog(null, "Alphabets Are Not Allowed","Error",JOptionPane.ERROR_MESSAGE);
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
			frame.setSize(600,300);
    		frame.setLocation(350,150);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String m=arg0.getActionCommand();
		if(m.equals("DELETE"))
		{
			try
			{
			Class.forName(driverclass);
			connection=DriverManager.getConnection(url+database,user,password);
			statement=connection.createStatement();
			resultset=statement.executeQuery("select * from customer_details");
			boolean flag=false;
			
			while(resultset.next())
			{
				int a=resultset.getInt(1);
			    if(a==Integer.parseInt(tid.getText()))
					{
			    	  flag=true;
			    	  prepare=connection.prepareStatement("delete  from customer_details where id="+a);
			    	  prepare.executeUpdate();
				     JOptionPane.showMessageDialog(null, "Data is deleted","Message",JOptionPane.INFORMATION_MESSAGE);
			    	  frame.setVisible(false);
				     
					}
			   
		
			}
			 if(flag==false)
				{ 
				    tid.setText("");
					JOptionPane.showMessageDialog(null, "Your Id No. Is Wrong","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(m.equals("CANCEL"))
		{
			frame.setVisible(false);
		}
		
		
	}
//	public static void main(String[] args) {
//		new DeleteCustomer();
//	}
//	 

}
