package chapterninepointproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.*;



public class GUI extends JFrame implements ActionListener {
	
	private JMenuBar menubar;
	private JMenu menu1;
	private JMenuItem menuitem1;
	private JLabel title, prompt1, error1, prompt2, prompt3;
	private JPanel content;
	private JButton softcov, hardcov, ebook, donate, takeout, enterinfo, cancel;
	private JTextField name, author, date, url;
	
	public GUI() {
		super("Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700, 500);
		
		//creates the jpanel
		content = new JPanel();
		content.setLayout(null);
		content.setSize(700, 500);
		
		//CREATE GUI ELEMENTS HERE
		menubar = new JMenuBar();
		menu1 = new JMenu("File");
		menu1.setMnemonic(KeyEvent.VK_A);
		menu1.getAccessibleContext().setAccessibleDescription("Tester");
		menubar.add(menu1);
		menuitem1 = new JMenuItem("EXIT");
		menuitem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		menuitem1.getAccessibleContext().setAccessibleDescription("This is another tester");
		menu1.add(menuitem1);
		setJMenuBar(menubar);
		
		title = new JLabel("Welcome to the library!");
		title.setFont(new Font("Comic Sans MS", 20, 15));
		title.setBounds(150, 10, 200, 20);
		content.add(title);
		
		donate = new JButton("Give a book!");
		donate.setBounds(50, 50, 150, 50);;
		donate.setVisible(true);
		content.add(donate);
		
		takeout = new JButton("Take out a book!");
		takeout.setBounds(250, 50, 150, 50);
		takeout.setVisible(true);
		content.add(takeout);
		
		softcov = new JButton("softcover");
		softcov.setBounds(20, 125, 95, 20);
		softcov.setVisible(false);
		content.add(softcov);
		
		hardcov = new JButton("hardcover");
		hardcov.setBounds(125, 125, 95, 20);
		hardcov.setVisible(false);
		content.add(hardcov);
		
		ebook = new JButton("E-book");
		ebook.setBounds(230, 125, 95, 20);
		ebook.setVisible(false);
		content.add(ebook);
		
		prompt1 = new JLabel("Please enter the information of the book below");
		prompt1.setFont(new Font("Comic Sans MS", 20, 12));
		prompt1.setBounds(20, 150, 270, 20);
		prompt1.setVisible(false);
		content.add(prompt1);
		
		name = new JTextField("Enter the title of the book", 20);
		name.setBounds(20,175, 225, 25);
		name.setVisible(false);
		content.add(name);
		
		date = new JTextField("Enter the year the book was published", 20);
		date.setBounds(20,225, 225, 25);
		date.setVisible(false);
		content.add(date);
		
		author = new JTextField("Enter the name of the author", 20);
		author.setBounds(20, 275, 225, 25);
		author.setVisible(false);
		content.add(author);
		
		url = new JTextField("Enter the url of the E-book", 20);
		url.setBounds(20, 325, 225, 25);
		url.setVisible(false);
		content.add(url);
		
		enterinfo = new JButton("Enter");
		enterinfo.setBounds(20, 325, 100, 25);
		enterinfo.setVisible(false);
		content.add(enterinfo);
		
		error1 = new JLabel("*");
		error1.setForeground(Color.red);
		error1.setBounds(15, 225, 225, 25);
		error1.setVisible(false);
		content.add(error1);
		
		prompt2 = new JLabel("Physical Books");
		prompt2.setFont(new Font("Comic Sans MS", 20, 12));
		prompt2.setBounds(400, 120, 150, 20);
		prompt2.setVisible(false);
		content.add(prompt2);
		
		prompt3 = new JLabel("E-books");
		prompt3.setFont(new Font("Comic Sans MS", 20, 12));
		prompt3.setBounds(550, 120, 150, 20);
		prompt3.setVisible(false);
	    content.add(prompt3);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(300, 400, 75, 20);
		cancel.setVisible(false);
		content.add(cancel);
		
		//actionlisteners
		donate.addActionListener(this);
		takeout.addActionListener(this);
		softcov.addActionListener(this);
		hardcov.addActionListener(this);
		ebook.addActionListener(this);
		enterinfo.addActionListener(this);
		cancel.addActionListener(this);
		
		//brings the gui together
		setContentPane(content);
		setVisible(true);
		
		
		
	}

		public void actionPerformed(ActionEvent event) {
			System.out.println("RUNNING");
			
			if (event.getSource() == menuitem1) {
				System.exit(0);
			} else if (event.getSource() == donate) {
				donate.setEnabled(false);
				takeout.setEnabled(false);
				
				softcov.setVisible(true);
				hardcov.setVisible(true);
				ebook.setVisible(true);
				
			} else if (event.getSource() == takeout) {
				donate.setEnabled(false);
				takeout.setEnabled(false);
				
				cancel.setVisible(true);
				prompt2.setVisible(true);
				prompt3.setVisible(true);
			} else if (event.getSource() == softcov) {
				hardcov.setEnabled(false);
				ebook.setEnabled(false);
				
				prompt1.setVisible(true);
				name.setVisible(true);
				date.setVisible(true);
				author.setVisible(true);
				enterinfo.setVisible(true);
				//store info
			} else if (event.getSource() == hardcov) {
				softcov.setEnabled(false);
				ebook.setEnabled(false);
				
				prompt1.setVisible(true);
				name.setVisible(true);
				date.setVisible(true);
				author.setVisible(true);
				enterinfo.setVisible(true);
				//store info
			} else if (event.getSource() == ebook) {
				hardcov.setEnabled(false);
				softcov.setEnabled(false);
				
				prompt1.setVisible(true);
				name.setVisible(true);
				date.setVisible(true);
				author.setVisible(true);
				url.setVisible(true);
				enterinfo.setBounds(20, 375, 100, 25);
				enterinfo.setVisible(true);
			} else if (event.getSource() == enterinfo) {
				//storing of info
				boolean pass = false;
				String name1 = name.getText();
				String date1 = date.getText();
				String author1 = author.getText();
				String url1 = url.getText();
				
				if (date1.length() <= 4 && date1.matches("[0-9]+") == true) {
					System.out.println(date1.matches("[0-9]+"));
					pass = true;
				}
				
				if (pass == true) {
					prompt1.setVisible(false);
					name.setVisible(false);
					date.setVisible(false);
					author.setVisible(false);
					url.setVisible(false);
					enterinfo.setVisible(false);
					enterinfo.setBounds(20, 325, 100, 20);
					softcov.setVisible(false);
					hardcov.setVisible(false);
					ebook.setVisible(false);
					donate.setEnabled(true);
					takeout.setEnabled(true);
					softcov.setEnabled(true);
					hardcov.setEnabled(true);
					ebook.setEnabled(true);
				} else {
					error1.setVisible(true);
				}
				
				pass = false;
			} else if (event.getSource() == cancel) {
				cancel.setVisible(false);
				prompt2.setVisible(false);
				prompt3.setVisible(false);
				
				donate.setEnabled(true);
				takeout.setEnabled(true);
			}
			
		}
		
}

