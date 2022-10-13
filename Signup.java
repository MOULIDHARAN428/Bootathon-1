//package declaration
package Bootathon;
//import package
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.util.regex.*;

//Extending JFrame and implements ActionListener for signup class
public class Signup extends JFrame implements ActionListener {
		//Creating Jframe object and keeps reference on frame
		
//		Declaring the variables for login frame
		private Container container;
	    private JLabel title;
	    private JLabel userIDLabel;
	    private JTextField userIDText;
	    private JLabel emailLabel;
	    private JTextField usernameText;
	    private JLabel usernameLabel;
	    private JTextField emailText;
	    private JLabel passwordLabel;
	    private JTextField passwordText;
	    private JButton submitButton;
//	    constructor
	    public Signup()
	    {

	        setTitle("Sign-Up");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	        //Assigning getContentPane() method to container
	        container = getContentPane();
	        container.setLayout(null);
	        
	        //Labeling the GUI
	        title = new JLabel("Sign-Up");
	        title.setFont(new Font("Arial", Font.PLAIN, 30));
	        title.setSize(300, 30);
	        title.setLocation(200, 30);
	        container.add(title);//Add title into container
	        
	        //Labeling the userID
	        userIDLabel = new JLabel("UserID");
	        userIDLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        userIDLabel.setSize(100, 20);
	        userIDLabel.setLocation(100, 100);
	        container.add(userIDLabel);//Add userIDLabel into container
	        //TextField for userID
	        userIDText = new JTextField();
	        userIDText.setFont(new Font("Arial", Font.PLAIN, 15));
	        userIDText.setSize(190, 20);
	        userIDText.setLocation(200, 100);
	        container.add(userIDText);//Add userIDText into container
	        
	        //Labeling the userID
	        usernameLabel = new JLabel("Username");
	        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        usernameLabel.setSize(100, 20);
	        usernameLabel.setLocation(100, 150);
	        container.add(usernameLabel);//Add userIDLabel into container
	        //TextField for userID
	        usernameText = new JTextField();
	        usernameText.setFont(new Font("Arial", Font.PLAIN, 15));
	        usernameText.setSize(190, 20);
	        usernameText.setLocation(200, 150);
	        container.add(usernameText);//Add userIDText into container
	        
	        //Labeling the email
	        emailLabel = new JLabel("Email");
	        emailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        emailLabel.setSize(100, 20);
	        emailLabel.setLocation(100, 200);
	        container.add(emailLabel);//Add emailLabel into container
	        //TextField for email
	        emailText = new JTextField();
	        emailText.setFont(new Font("Arial", Font.PLAIN, 15));
	        emailText.setSize(190, 20);
	        emailText.setLocation(200, 200);
	        container.add(emailText);//Add emailText into container
	        
	        //Labeling the password
	        passwordLabel = new JLabel("Password");
	        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        passwordLabel.setSize(100, 20);
	        passwordLabel.setLocation(100, 250);
	        container.add(passwordLabel);//Add passwordLabel into container
	        //TextField for password
	        passwordText = new JTextField();
	        passwordText.setFont(new Font("Arial", Font.PLAIN, 15));
	        passwordText.setSize(190, 20);
	        passwordText.setLocation(200, 250);
	        container.add(passwordText);//Add passwordText into container
	        
	        //Button for submission
	        submitButton = new JButton("Submit");
	        submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
	        submitButton.setSize(100, 20);
	        submitButton.setLocation(200, 300);
	        submitButton.addActionListener(this);
	        container.add(submitButton);//Add submission button into container
	        //Setting true for visible
	        setVisible(true);
	    }

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == submitButton) {
				
				//Validation
				int isValid=1;
				String errorMsg="";
				
				//Username
				
				String username = usernameText.getText();
				
				if(username.length()<3 || username.length()>13) {
					errorMsg="User name should be >3 & <13 characters";
					isValid=0;
				}
				else if(!Pattern.matches("[a-zA-Z]+", username)) {
					errorMsg="Special characters and numbers are not allowed in username";
					isValid=0;
				}
				
				if(isValid==1) {
					String email = emailText.getText();
					if(!Pattern.matches("[a-z0-9]{3,15}@{1}[a-z]{3,10}.{1}[a-z]{3}",email)) {
						errorMsg="Email is not valid!";
						isValid=0;
					}
				}
				
				if(isValid==1) {
					String password = passwordText.getText();
					if(password.length()<8) {
						errorMsg="Password length should be greater than 8";
						isValid=0;
					}
					else if(Pattern.matches("^[0-9]{1,}", password) || Pattern.matches("^[a-zA-Z0-9]{1,}", password)) {
						errorMsg="Password should contains number and special characters";
						isValid=0;
					}
				}
				if(isValid==1) {
					Database database = new Database();
					database.connect();
					String result = database.registerUser(userIDText.getText(),usernameText.getText(),emailText.getText(),passwordText.getText());
					database.closeConnection();
					if(!result.equals("1")) {
						new RegistrationFailed(result);
					}
					else {
						new Login();
					}
				}
				else {
					new RegistrationFailed(errorMsg);
				}
			 }
		}
}
