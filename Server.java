package chatapplication;
import javax.swing.*;
import java.net.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Server extends JFrame implements ActionListener{
	JPanel p1;
	JButton b1;
	JTextField t1;
     static	JTextArea a1;
	static ServerSocket skt;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	Server()
	{
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7,94,84));
		p1.setBounds(0, 0, 450 ,50);
		add(p1);
	    ImageIcon icon=new ImageIcon("C:\\Users\\hp\\Downloads\\3.png");
		Image i2=icon.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel label1=new JLabel(i3);
		label1.setBounds(5,5,30,40);
	    add(label1);
	   p1.add(label1);
	   
	   label1.addMouseListener(new MouseAdapter()
	   {
		   public void mouseClicked(MouseEvent ae)
		   {
			   System.exit(0);
		   }
	   });
	   ImageIcon icon1=new ImageIcon("C:\\Users\\hp\\Pictures\\shizuka.png");
		Image i4=icon1.getImage().getScaledInstance(40,60,Image.SCALE_DEFAULT);
		ImageIcon i5= new ImageIcon(i4);
		JLabel label2=new JLabel(i5);
		label2.setBounds(35,10,60,40);
	    add(label2);
	   p1.add(label2);
	    
	    JLabel label3=new JLabel("Shizuka");
	   // label3.setText("Nobita");
	    label3.setFont(new Font("arial",Font.PLAIN,18));
	    label3.setForeground(Color.WHITE);
	    label3.setBounds(100,10,100,18);
	    p1.add(label3);
	    
	    
	    JLabel label4=new JLabel("Active Now");
	    label4.setFont(new Font("arial",Font.PLAIN,10));
	    label4.setForeground(Color.WHITE);
	    label4.setBounds(105,32,80,10);
	    p1.add(label4);
	    
	    
	    
	    ImageIcon icon2=new ImageIcon("C:\\Users\\hp\\Downloads\\3icon.png");
		Image i6=icon2.getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT);
		ImageIcon i7= new ImageIcon(i6);
		JLabel label5=new JLabel(i7);
		label5.setBounds(400,10,10,30);
	   // add(label5);
	   p1.add(label5);
	    
	   ImageIcon icon3=new ImageIcon("C:\\Users\\hp\\Downloads\\phone.png");
			Image i8=icon3.getImage().getScaledInstance(23,23,Image.SCALE_DEFAULT);
			ImageIcon i9= new ImageIcon(i8);
			JLabel label6=new JLabel(i9);
			label6.setBounds(350,10,50,30);
		    add(label6);
		   p1.add(label6);
		    
		    
		   ImageIcon icon4=new ImageIcon("C:\\Users\\hp\\Downloads\\video.png");
				Image i10=icon4.getImage().getScaledInstance(23,23,Image.SCALE_DEFAULT);
				ImageIcon i11= new ImageIcon(i10);
				JLabel label7=new JLabel(i11);
				label7.setBounds(310,10,50,30);
			    add(label7);
			   p1.add(label7);
	   
			   
			 t1=new JTextField();
			 t1.setBounds(5,560,310,40);
			 t1.setFont(new Font("ARIAL",Font.PLAIN,20));
			 add(t1);
	   
			 
			 b1=new JButton("Send");
			 b1.setForeground(Color.WHITE);
			 b1.setBounds(320,560,124,40);
				b1.setBackground(new Color(7,94,84));
				 b1.setFont(new Font("ARIAL",Font.PLAIN,15));
				 b1.addActionListener(this);
			 add(b1);
			 
			 
			 a1=new JTextArea();
			 a1.setBounds(3,51,450,505);
			 a1.setBackground(Color.WHITE);
			 a1.setFont(new Font("ARIAL",Font.PLAIN,16));
			 a1.setEditable(false);
			 add(a1);
			 
			 
		setSize(450,600);
		setLayout(null);
		setLocation(100,100);
		 Container c= getContentPane();
		   c.setBackground(Color.WHITE);
		   setUndecorated(true);
		   setVisible(true);
		
		
		
	}

	   public void actionPerformed(ActionEvent ae)
	   {
		   try {
		   String out="";
				 out=  t1.getText();
		   a1.setText(a1.getText()+"\n\t\t\t"+out);
		   t1.setText("");
		   dout.writeUTF(out);
		  
		   }catch(Exception e) {}
		   
	   }
	public static void main(String[] args)
	{
		Server obj=new Server();
		String msginput="";
		try {
			skt=new ServerSocket(1201);
			s=skt.accept();
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
	while(!msginput.equals("exit"))
{
	msginput=din.readUTF();
	a1.setText(a1.getText()+"\n"+msginput);
}
		
			
		
			}catch(Exception e) {}

	}

}
