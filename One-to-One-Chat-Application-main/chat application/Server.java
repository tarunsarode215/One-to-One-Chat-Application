import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

class Server extends JFrame implements ActionListener {

JPanel p1;
JTextField t1;
JButton b1;
static JTextArea ta;

static ServerSocket skt;
static Socket s;
static DataInputStream din;
static DataOutputStream dout;

Server()
{
	//top pannel 9-14
	p1=new JPanel();
	p1.setLayout(null);
	p1.setBackground(new Color(7,94,80));
	p1.setBounds(0,0,450,70);
	add(p1);
	//back arrow
	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
    Image i2=i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel l1=new JLabel(i3);
	l1.setBounds(5,5,30,60);
	p1.add(l1);
	
	//window shut when we click on back arrrow
	l1.addMouseListener(new MouseAdapter()
	{
	public void mouseClicked(MouseEvent ae)
	{
		System.exit(0);
	}	
	});
	
	//image
	ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
    Image i5=i4.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
	ImageIcon i6=new ImageIcon(i5);
	JLabel l2=new JLabel(i6);
	// l2.setBounds(x,y,w,h);
	l2.setBounds(45,5,60,60);
	p1.add(l2);
	
	ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
    Image i8=i7.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
	ImageIcon i9=new ImageIcon(i8);
	JLabel l3=new JLabel(i9);
	// l2.setBounds(x,y,w,h);
	l3.setBounds(300,20,35,35);
	p1.add(l3);
	
	ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
    Image i12=i11.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
	ImageIcon i13=new ImageIcon(i12);
	JLabel l4=new JLabel(i13);
	// l2.setBounds(x,y,w,h);
	l4.setBounds(350,20,35,35);
	p1.add(l4);
	
	ImageIcon i14=new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
    Image i15=i14.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
	ImageIcon i16=new ImageIcon(i15);
	JLabel l5=new JLabel(i16);
	// l2.setBounds(x,y,w,h);
	l5.setBounds(400,20,35,35);
	p1.add(l5);
	
	//name
	JLabel l6=new JLabel("Jarvis");
	l6.setFont(new Font("SAN_SERIF",Font.BOLD,20));
	l6.setForeground(Color.WHITE);
	l6.setBounds(115,10,150,30);
	p1.add(l6);
	
	
	JLabel l7=new JLabel("Active now");
	l7.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
	l7.setForeground(Color.WHITE);
	l7.setBounds(115,32,150,30);
	p1.add(l7);
	
	//to dispaly messages 
	ta=new JTextArea();
	ta.setBounds(5,75,440,520);
	ta.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
	ta.setEditable(false);
	ta.setLineWrap(true);
	ta.setWrapStyleWord(true);
	add(ta);

     t1=new JTextField();
     t1.setBounds(5,600,310,40);
     t1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
     add(t1);	 
	 
	 b1=new JButton("Send");
	 b1.setBounds(320,600,120,40);
	 b1.setBackground(new Color(7,94,84));
	 b1.setForeground(Color.WHITE);
	 b1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
	 b1.addActionListener(this);//when we click On button it go at actionPerformed() Method
	 add(b1);
	 
	getContentPane().setBackground(Color.WHITE);
	setLayout(null);
	setSize(450,650);
    setUndecorated(true);//to remove frame upper border
    setVisible(true);
    setLocation(100,100);
}
public void actionPerformed(ActionEvent ae)
{
	try{
	String out=t1.getText();
	ta.setText(ta.getText()+"\n\t\t\t"+out);
	dout.writeUTF(out);//throw IO Exception
	t1.setText("");
    }
  catch(Exception e){
	  System.out.println(e);
  }  
}
public static void main(String ar[])
{
    new Server().setVisible(true);
     
	 String msginput="";
    try
	{
	skt =new ServerSocket(6001);//port no.we can pass anything which is not occupied
     s=skt.accept();// all data come with the help of socket
	 
    din=new DataInputStream(s.getInputStream());	 
    dout=new DataOutputStream(s.getOutputStream());
	
	msginput=din.readUTF();
	ta.setText(ta.getText()+"\n"+msginput);
	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}