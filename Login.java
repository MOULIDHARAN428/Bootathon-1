//Package declaration
package Bootathon;
//Importing pacakages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login  extends JFrame implements ActionListener{
		//Creating JFrame object and keeps reference on frame
		
		//Declaring the variables for login frame
		private Container container;
	    private JLabel titleLabel;
	    private JLabel userIDLabel;
	    private JLabel passwordLabel;
	    private JLabel ipLabel;
	    private JTextField ipText;
	    private JTextField userIDText;
	    private JTextField passwordText;
	    private JButton submitButton;
	    
	    //Constructor
	    public Login(){
	    	//Setting up the title of the GUI frame
	        setTitle("Log In");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	        
	        //Assigning getContentPane() method to container
	        container = getContentPane();
	        container.setLayout(null);
	        
	        //Labeling the GUI
	        titleLabel = new JLabel("Log In");
	        titleLabel.setFont(new Font("Arial", Font.PLAIN, 30));
	        titleLabel.setSize(300, 30);
	        titleLabel.setLocation(200, 30);
	        container.add(titleLabel); //Adding titleLabel into the container
	        
	        //Label for the userID
	        userIDLabel = new JLabel("User ID");
	        userIDLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        userIDLabel.setSize(100, 20);
	        userIDLabel.setLocation(100, 150);
	        container.add(userIDLabel); //Adding emailLabel into the container
	        //Text field for the userID
	        userIDText = new JTextField();
	        userIDText.setFont(new Font("Arial", Font.PLAIN, 15));
	        userIDText.setSize(190, 20);
	        userIDText.setLocation(200, 150);
	        container.add(userIDText); //Adding emailText into the container
	        
	        //Label for the password
	        passwordLabel = new JLabel("Password");
	        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        passwordLabel.setSize(100, 20);
	        passwordLabel.setLocation(100, 200);
	        container.add(passwordLabel); //Adding passwordLabel into the container
	        //Text field for the password
	        passwordText = new JTextField();
	        passwordText.setFont(new Font("Arial", Font.PLAIN, 15));
	        passwordText.setSize(190, 20);
	        passwordText.setLocation(200, 200);
	        container.add(passwordText); //Adding passwordText into the container
	        //Label for the password
	        ipLabel = new JLabel("IP");
	        ipLabel.setFont(new Font("Arial", Font.PLAIN, 20));
	        ipLabel.setSize(100, 20);
	        ipLabel.setLocation(100, 250);
	        container.add(ipLabel); //Adding passwordLabel into the container
	        //Text field for the password
	        ipText = new JTextField();
	        ipText.setFont(new Font("Arial", Font.PLAIN, 15));
	        ipText.setSize(190, 20);
	        ipText.setLocation(200, 250);
	        container.add(ipText); //Adding passwordText into the container
	        //Submit button
	        submitButton = new JButton("Submit");
	        submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
	        submitButton.setSize(100, 20);
	        submitButton.setLocation(200, 350);
	        container.add(submitButton); //Adding submitButton into the container
	        submitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					Database database = new Database();
	 	           database.connect();
	 	           String isLogin = database.loginUser(userIDText.getText(),passwordText.getText());
	 	           database.closeConnection();
	 	           if(isLogin.equals("1")) {
	 	        	   try {
		 	        	  Game g=new Game(userIDText.getText());
		 	        	  g.setIp(ipText.getText());
		 	        	  g.findPorts();
		 	        	  g.connect();
	 	        	   }
	 	        	   catch(Exception e) {}
	 	           }
	 	           else {
	 	        	   new LoginFailed("User ID or Password is incorrect");
	 	        	   System.out.println("Failed");
	 	           }
				}
			});
	        //Setting visible as true
	        setVisible(true);
	    }
	    public void actionPerformed(ActionEvent e) {
		} 
	
	
}
