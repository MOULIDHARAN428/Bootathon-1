package Bootathon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener{
	public  void home() {
		JFrame frame=new JFrame("Home");
		
		
	    JButton signupButton=new JButton("Sign Up");  
	    signupButton.setBounds(380,80,150,60);
	    signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new Signup();
			}
		});
	    
	    JButton loginButton=new JButton("Log In");  
	    loginButton.setBounds(380,180,150,60);
	    loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				new Login();
			}
		});
	    
	    
	    JButton exitButton=new JButton("Exit");  
	    exitButton.setBounds(380,280,150,60);
	    exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
				System.exit(0);
			}
		});
	    
	    
	    
	    frame.add(loginButton);
	    frame.add(signupButton);
	    frame.add(exitButton);
	    
	    frame.setSize(900,600);
	    frame.setLocation(300, 90);
	    frame.setLayout(null);  
	    frame.setVisible(true);
	}
	public Home() {
		home();
	}
	public static void main(String args[]) {
		Home home = new Home();
		home.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
	} 
}
