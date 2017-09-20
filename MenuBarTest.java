package carinsurance;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MenuBarTest
{
	JMenuBar menubar;

	
	
	JMenu  madmin;
	JMenu  mcustomer;
	JMenu  mviewrecord;
	
	
	
	JMenuItem mnewaccount;
	JMenuItem mupdateaccount;
	JMenuItem mdeleteaccount;
	
	JMenuItem mnewcustomer;
	JMenuItem mdeletecustomer;
	JMenuItem mupdatecustomer;
	JMenuItem mupdatevehicle;
	JMenuItem mshowdetail;
	JMenuItem mshowall;
	
	
	JMenuItem mcustomerview;
	JMenuItem mvehicleview;
	
	
	
	JTextArea Text1;
	String pas=null;
	public MenuBarTest(String pass)
	{
		pas=pass;

		menubar=new JMenuBar();
		menubar.setBounds(0,30,986,40);
		menubar.setBackground(Color.magenta);	
		
		
		
		
		madmin=new JMenu("     Administrative Detail           " );
		madmin.setBounds(1000,0,100,50);
		madmin.setFont(new Font("Times New Roman",Font.BOLD,20));
		madmin.setForeground(Color.WHITE);
		menubar.add(madmin);
		
	    mcustomer=new JMenu("    Customer Record          ");
	    mcustomer.setBounds(2000,0,100,50);
		mcustomer.setFont(new Font("Times New Roman",Font.BOLD,20));
		mcustomer.setForeground(Color.WHITE);
		menubar.add(mcustomer);
		
		
	    mviewrecord=new JMenu("     View Record        ");
		mviewrecord.setBounds(3000,0,100,50);
		mviewrecord.setFont(new Font("Times New Roman",Font.BOLD,20));
		mviewrecord.setForeground(Color.WHITE);
		menubar.add(mviewrecord);
		
		
		
		
		
		mnewaccount=new JMenuItem("       Open Account                                   ");
		mupdateaccount=new JMenuItem("       Modify Account                            ");
		mdeleteaccount=new JMenuItem("       Delete Account                                  ");
		
		mnewcustomer=new JMenuItem("       Add New Customer  ");
		mdeletecustomer=new JMenuItem("       Delete Customer                     ");
		mupdatecustomer=new JMenuItem("       Update Customer Details");
		mupdatevehicle=new JMenuItem("       Update Vehicle Details ");
		
		mshowall = new JMenuItem("       Show All Customer Details     ");
		mshowdetail = new JMenuItem("       Show Customer Details     ");
		
		
		mcustomerview=new JMenuItem("       Customer Details                 ");
		mvehicleview=new JMenuItem("       Vehicle Details      ");
		
		
		madmin.add(mnewaccount);
		madmin.add(mupdateaccount);
		madmin.add(mdeleteaccount);
		
		mcustomer.add(mnewcustomer);
		mcustomer.add(mupdatecustomer);
		mcustomer.add(mupdatevehicle);
		mcustomer.add(mdeletecustomer);
		
	   
	    mviewrecord.add(mvehicleview);
	    mviewrecord.add(mshowall);
	    mviewrecord.add(mshowdetail);
	    
		
	 
	    
	   
	 mnewaccount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.CTRL_MASK));
	
     mnewaccount.addActionListener(new ActionListener()
    
     {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new NewAccount(pas);
			
		}
     
     }
     );
     mupdateaccount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.CTRL_MASK));
     
     mupdateaccount.addActionListener(new ActionListener()
     
     {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new UpdateAccount();
			
		}
     
     }
     );
     
     mdeleteaccount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,ActionEvent.CTRL_MASK));
     
     mdeleteaccount.addActionListener(new ActionListener()
     
     {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new DeleteAccount();
		
			
		}
     
     }
     );
     mnewcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,ActionEvent.CTRL_MASK));
     
  mnewcustomer.addActionListener(new ActionListener()
     
     {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
		    new NewCustomer(pas);
		    
			
		}
     
     }
     );
     
  mdeletecustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6,ActionEvent.CTRL_MASK));
  
     mdeletecustomer.addActionListener(new ActionListener()
     {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			new DeleteCustomer(pas);
			
		}
		}
     
     );
     mupdatecustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7,ActionEvent.CTRL_MASK));
     
     mupdatecustomer.addActionListener(new ActionListener()
     {

		@Override
		public void actionPerformed(ActionEvent e)
		{
		   new UpdateCustomerId(pas);
		   
		
		}
		
     
}     );
 mupdatevehicle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7,ActionEvent.CTRL_MASK));
     
     mupdatevehicle.addActionListener(new ActionListener()
     {

		@Override
		public void actionPerformed(ActionEvent e)
		{
		   new UpdateVehicleSr(pas);
		   
		
		}
		}
     
     );
     mshowall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8,ActionEvent.CTRL_MASK));
     
     mshowall.addActionListener(new ActionListener()
     
     {

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
		  new AllDetails(pas);
			
		}
     
     });
     mshowdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9,ActionEvent.CTRL_MASK));
     
     mshowdetail.addActionListener(new ActionListener()
    
     {

		@Override
		public void actionPerformed(ActionEvent e)
		{

         new OneDetailid(pas);
			
		}
     
     }
     
     
     );
     
    
     mcustomerview.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
     
     mcustomerview.addActionListener(new ActionListener()
    
     {

		@Override
		public void actionPerformed(ActionEvent e)
		{

         new OneDetailid(pas);
			
		}
     }
     
     
     );
     mvehicleview.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK));
     
     mvehicleview.addActionListener(new ActionListener()
     {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new VDetail(pas);
		}}
     );
     
   
     
    
	}
	
	
	
}

