package Bootathon;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class RegistrationFailed extends JFrame implements ActionListener {
		private Container container;
    	private JLabel titleLabel;
    	private JLabel errorLabel;
    	private JButton returnHome;
	    
	    public RegistrationFailed(String errorMsg)
	    {
	    	setTitle("Registration");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	        
	        //Assigning getContentPane() method to container
	        container = getContentPane();
	        container.setLayout(null);
	        
	        //Labeling the GUI
	        titleLabel = new JLabel("Registration Failed");
	        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
	        titleLabel.setSize(300, 30);
	        titleLabel.setLocation(300, 50);
	        container.add(titleLabel); //Adding titleLabel into the container
	        
	        errorLabel = new JLabel(errorMsg);
	        errorLabel.setFont(new Font("Arial", Font.PLAIN, 30));
	        errorLabel.setSize(700, 50);
	        errorLabel.setLocation(100, 100);
	        container.add(errorLabel); //Adding titleLabel into the container
	        
	        //Button for submission
	        returnHome = new JButton("Home");
	        returnHome.setFont(new Font("Arial", Font.PLAIN, 15));
	        returnHome.setSize(100, 20);
	        returnHome.setLocation(350, 220);
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

