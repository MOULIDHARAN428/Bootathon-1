package Bootathon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginFailed extends JFrame implements ActionListener {
		private Container container;
    	private JLabel titleLabel;
    	private JLabel errorLabel;
    	private JButton returnHome;
	    
	    public LoginFailed(String errorMsg)
	    {
	    	setTitle("Log In");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	        
	        //Assigning getContentPane() method to container
	        container = getContentPane();
	        container.setLayout(null);
	        
	        //Labeling the GUI
	        titleLabel = new JLabel("Login Failed");
	        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
	        titleLabel.setSize(300, 30);
	        titleLabel.setLocation(200, 30);
	        container.add(titleLabel); //Adding titleLabel into the container
	        
	        errorLabel = new JLabel(errorMsg);
	        errorLabel.setFont(new Font("Arial", Font.PLAIN, 30));
	        errorLabel.setSize(300, 30);
	        errorLabel.setLocation(200, 100);
	        container.add(errorLabel); //Adding titleLabel into the container
	        
	        //Button for submission
	        returnHome = new JButton("Home");
	        returnHome.setFont(new Font("Arial", Font.PLAIN, 15));
	        returnHome.setSize(100, 20);
	        returnHome.setLocation(200, 150);
	        returnHome.addActionListener(this);
	        container.add(returnHome);//Add submission button into container
	        
	        setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == returnHome) {
			 new Home();
		 }
	}
}

