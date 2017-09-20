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

public class UpdateCustomerId extends JFrame implements ActionListener
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
	
	
   
	
	JLabel lid;
	JLabel message;
	JTextField tid;
	JButton ok;
	JButton cancel;
	JPanel panel;
	JFrame frame;
	String p=null;
	public UpdateCustomerId (String pa)
	{
		p=pa;
		try
		{
			frame=new JFrame();
		frame.setTitle("UPDATE CUSTOMER ");
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
		ok=new JButton("OK");
		ok.setBounds(150,200,80,40);
		ok.setMnemonic('o');
		ok.setToolTipText("Click Ok To Update");
		cancel=new JButton("CANCEL");
		cancel.setBounds(330,200,90,40);
		cancel.setMnemonic('c');
		cancel.setToolTipText("Click to Cancel");
		panel.add(lid);
		panel.add(tid);
		panel.add(ok);
		panel.add(cancel);
		
		panel.setBackground(Color.yellow);
		cancel.addActionListener(this);
		ok.addActionListener(this);
		tid.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
			   if(e.getKeyChar()>='0'& e.getKeyChar()<='9' || e.getKeyCode()==8)
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
				int a=resultset.getInt(1);
			    if(a==Integer.parseInt(tid.getText()))
					{
			    	  flag=true;
				      frame.setVisible(false);
			    	  new UpdateCustomer(a,p);
				     
					}
			   
		
			}
			 if(flag==false)
				{
				    tid.setText("");
					JOptionPane.showMessageDialog(null, "Your Id No. Is Wrong","Error",JOptionPane.ERROR_MESSAGE);
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
//	public static void main(String[] args) {
//		new UpdateCustomerId();
//	}
//	 

}
