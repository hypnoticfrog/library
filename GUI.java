package chapterninepointproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.*;



public class GUI extends JFrame implements ActionListener {
	
	private JLabel title, prompt1, error1, prompt2, prompt3;
	private JLabel info, iname, iauthor, idate, iextra;
	private JPanel content;
	private JButton softcov, hardcov, ebook, donate, takeout, enterinfo, cancel, binfo, take ,exit;
	private JButton book1, book2, book3, book4, book5, ebook1, ebook2, ebook3, ebook4, ebook5;
	private JButton up1, up2, down1, down2;
	private JTextField name, author, date, url;
	
	Stock stock = new Stock();
	
	private int bookcount = 0, ebookcount = 0;
	private int numdown1, numdown2;
	private boolean isebook = false;
	private boolean issoftcover = false;
	private boolean takemode = false, infomode = false;
	private int size;
	
	public GUI() {
		super("Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700, 500);
		
		//creates the jpanel
		content = new JPanel();
		content.setLayout(null);
		content.setSize(700, 500);
		
		//creates the stock object
		stock = new Stock();
		
		//CREATE GUI ELEMENTS HERE
		
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
		
		info = new JLabel("INFO");
		info.setFont(new Font("Comic Sans MS", 20, 13));
		info.setBounds(410, 1, 150, 20);
		info.setVisible(false);
		content.add(info);
		
		iname = new JLabel("Title: ");
		iname.setFont(new Font("Comic Sans MS", 20, 12));
		iname.setBounds(410, 20, 150, 20);
		iname.setVisible(false);
		content.add(iname);
		
		iauthor = new JLabel("Author: ");
		iauthor.setFont(new Font("Comic Sans MS", 20, 12));
		iauthor.setBounds(410, 40, 150, 20);
		iauthor.setVisible(false);
		content.add(iauthor);
		
		idate = new JLabel("Year Published: ");
		idate.setFont(new Font("Comic Sans MS", 20, 12));
		idate.setBounds(410, 60, 150, 20);
		idate.setVisible(false);
		content.add(idate);
		
		iextra = new JLabel("Specific info");
		iextra.setFont(new Font("Comic Sans MS", 20, 12));
		iextra.setBounds(410, 80, 150, 20);
		iextra.setVisible(false);
		content.add(iextra);
		
		prompt2 = new JLabel("Physical Books");
		prompt2.setFont(new Font("Comic Sans MS", 20, 12));
		prompt2.setBounds(400, 120, 150, 20);
		prompt2.setVisible(true);
		content.add(prompt2);
		
		prompt3 = new JLabel("E-books");
		prompt3.setFont(new Font("Comic Sans MS", 20, 12));
		prompt3.setBounds(550, 120, 150, 20);
		prompt3.setVisible(true);
	    content.add(prompt3);
	    
	    book1 = new JButton("Book1");
	    book1.setBounds(400, 180, 130, 30);
	    book1.setVisible(false);
	    content.add(book1);
	    
	    book2 = new JButton("Book2");
	    book2.setBounds(400, 220, 130, 30);
	    book2.setVisible(false);
	    content.add(book2);
	    
	    book3 = new JButton("Book3");
	    book3.setBounds(400, 260, 130, 30);
	    book3.setVisible(false);
	    content.add(book3);
	    
	    book4 = new JButton("Book4");
	    book4.setBounds(400, 300, 130, 30);
	    book4.setVisible(false);
	    content.add(book4);
	    
	    book5 = new JButton("Book5");
	    book5.setBounds(400, 340, 130, 30);
	    book5.setVisible(false);
	    content.add(book5);
	    
	    ebook1 = new JButton("ebook1");
	    ebook1.setBounds(550, 180, 130, 30);
	    ebook1.setVisible(false);
	    content.add(ebook1);
	    
	    ebook2 = new JButton("ebook2");
	    ebook2.setBounds(550, 220, 130, 30);
	    ebook2.setVisible(false);
	    content.add(ebook2);
	    
	    ebook3 = new JButton("ebook3");
	    ebook3.setBounds(550, 260, 130, 30);
	    ebook3.setVisible(false);
	    content.add(ebook3);
	    
	    ebook4 = new JButton("ebook4");
	    ebook4.setBounds(550, 300, 130, 30);
	    ebook4.setVisible(false);
	    content.add(ebook4);
	    
	    ebook5 = new JButton("ebook5");
	    ebook5.setBounds(550, 340, 130, 30);
	    ebook5.setVisible(false);
	    content.add(ebook5);
	    
	    up1 = new JButton("*up*");
	    up1.setBounds(400, 140, 130, 30);
	    up1.setVisible(true);
	    up1.setEnabled(false);
	    content.add(up1);
	    
	    up2 = new JButton("*up*");
	    up2.setBounds(550, 140, 130, 30);
	    up2.setVisible(true);
	    up2.setEnabled(false);
	    content.add(up2);
	    
	    down1 = new JButton("*down*");
	    down1.setBounds(400, 380, 130, 30);
	    down1.setVisible(true);
	    down1.setEnabled(false);
	    content.add(down1);
	    
	    down2 = new JButton("*down*");
	    down2.setBounds(550, 380, 130, 30);
	    down2.setVisible(true);
	    down2.setEnabled(false);
	    content.add(down2);
	    
	    take = new JButton("Take");
	    take.setBounds(320, 330, 75, 20);
	    take.setVisible(false);
	    content.add(take);
	    
	    binfo = new JButton("Info");
		binfo.setBounds(320, 360, 75, 20);
		binfo.setVisible(false);
		content.add(binfo);
	    
	    cancel = new JButton("Cancel");
		cancel.setBounds(320, 390, 75, 20);
		cancel.setVisible(false);
		content.add(cancel);
		
		exit = new JButton("Exit");
		exit.setBounds(320, 420, 75, 20);
		exit.setVisible(false);
		content.add(exit);
		
		//actionlisteners
		donate.addActionListener(this);
		takeout.addActionListener(this);
		softcov.addActionListener(this);
		hardcov.addActionListener(this);
		ebook.addActionListener(this);
		enterinfo.addActionListener(this);
		binfo.addActionListener(this);
		take.addActionListener(this);
		cancel.addActionListener(this);
		exit.addActionListener(this);
		
		book1.addActionListener(this);
		book2.addActionListener(this);
		book3.addActionListener(this);
		book4.addActionListener(this);
		book5.addActionListener(this);
		
		ebook1.addActionListener(this);
		ebook2.addActionListener(this);
		ebook3.addActionListener(this);
		ebook4.addActionListener(this);
		ebook5.addActionListener(this);
		
		up1.addActionListener(this);
		up2.addActionListener(this);
		down1.addActionListener(this);
		down2.addActionListener(this);
		
		
		//brings the gui together
		setContentPane(content);
		setVisible(true);
		
		
		
	}

		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == donate) {
				donate.setEnabled(false);
				takeout.setEnabled(false);
				
				softcov.setVisible(true);
				hardcov.setVisible(true);
				ebook.setVisible(true);
				
			} else if (event.getSource() == takeout) {
				donate.setEnabled(false);
				takeout.setEnabled(false);
				
				cancel.setVisible(true);
				take.setVisible(true);
				binfo.setVisible(true);
				exit.setVisible(true);
				prompt2.setVisible(true);
				prompt3.setVisible(true);
				up1.setVisible(true);
				up2.setVisible(true);
				down1.setVisible(true);
				down2.setVisible(true);
				
			} else if (event.getSource() == softcov) {
				hardcov.setEnabled(false);
				ebook.setEnabled(false);
				
				prompt1.setVisible(true);
				name.setVisible(true);
				date.setVisible(true);
				author.setVisible(true);
				enterinfo.setVisible(true);
				//store info
				isebook = false;
				issoftcover = true;
			} else if (event.getSource() == hardcov) {
				softcov.setEnabled(false);
				ebook.setEnabled(false);
				
				prompt1.setVisible(true);
				name.setVisible(true);
				date.setVisible(true);
				author.setVisible(true);
				enterinfo.setVisible(true);
				//store info
				isebook = false;
				issoftcover = false;
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
				
				isebook = true;
			} else if (event.getSource() == enterinfo) {
				//storing of info
				boolean pass = false;
				String name1 = name.getText();
				String datestr = date.getText();
				String author1 = author.getText();
				String url1 = url.getText();
				
				
				if (datestr.length() <= 4 && datestr.matches("[0-9]+") == true) {
					pass = true;
				}
				
				error1.setVisible(false);
				
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
					
					int date1 = Integer.parseInt(date.getText());
					
					if (isebook == true) {
						ebookcount++;
						
						stock.setEBook(name1, author1, date1, url1);
					} else if (isebook == false) {
						bookcount++;
						
						stock.setPBook(name1, author1, date1, issoftcover);
					}
					
					switch (bookcount) {
					case 1: book1.setVisible(true);
							book1.setText(stock.getPBookname());
					break;
					case 2: book2.setVisible(true);
							book2.setText(stock.getPBookname());
					break;
					case 3: book3.setVisible(true);
							book3.setText(stock.getPBookname());
					break;
					case 4: book4.setVisible(true);
							book4.setText(stock.getPBookname());
					break;
					case 5: book5.setVisible(true);
							book5.setText(stock.getPBookname());
					break;
					}
					
					switch (ebookcount) {
					case 1: ebook1.setVisible(true);
							ebook1.setText(stock.getEBookname());
					break;
					case 2: ebook2.setVisible(true);
							ebook2.setText(stock.getEBookname());
					break;
					case 3: ebook3.setVisible(true);
							ebook3.setText(stock.getEBookname());
					break;
					case 4: ebook4.setVisible(true);
							ebook4.setText(stock.getEBookname());
					break;
					case 5: ebook5.setVisible(true);
							ebook5.setText(stock.getEBookname());
					break;
					
					}
				} else {
					error1.setVisible(true);
				}
				
				pass = false;
				
				if (bookcount > 5) {
					up1.setEnabled(false);
					down1.setEnabled(true);
				}
				
				if (ebookcount > 5) {
					up2.setEnabled(false);
					down2.setEnabled(true);
				}
				
			} else if (event.getSource() == take) {
				
				takemode = true;
				
				take.setEnabled(false);
				
			} else if (event.getSource() == cancel) {
				
				info.setVisible(false);
				iname.setVisible(false);
				iauthor.setVisible(false);
				idate.setVisible(false);
				iextra.setVisible(false);
				
				takemode = false;
				infomode = false;
				
				take.setEnabled(true);
				binfo.setEnabled(true);
			} else if (event.getSource() == binfo) {
				binfo.setEnabled(false);
				
				info.setVisible(true);
				iname.setVisible(true);
				iauthor.setVisible(true);
				idate.setVisible(true);
				iextra.setVisible(true);
				
				infomode = true;
			} else if (event.getSource() == exit) {
				info.setVisible(false);
				iname.setVisible(false);
				iauthor.setVisible(false);
				idate.setVisible(false);
				iextra.setVisible(false);
				
				takemode = false;
				infomode = false;
				
				donate.setEnabled(true);
				takeout.setEnabled(true);
				
				cancel.setVisible(false);
				take.setVisible(false);
				binfo.setVisible(false);
				exit.setVisible(false);
			} else if (event.getSource() == down1) {
				numdown1++;
				
				book1.setText(book2.getText());
				book2.setText(book3.getText());
				book3.setText(book4.getText());
				book4.setText(book5.getText());
				
				book5.setText(stock.getPBookname(numdown1+4));
				
				size = stock.getPSize();
				
				if (size <= (numdown1 + 5)) {
					down1.setEnabled(false);
				}
				
				if (numdown1 >= 1) {
					up1.setEnabled(true);
				}
				
			} else if (event.getSource() == down2) {
				numdown2++;
				
				ebook1.setText(ebook2.getText());
				ebook2.setText(ebook3.getText());
				ebook3.setText(ebook4.getText());
				ebook4.setText(ebook5.getText());
				
				ebook5.setText(stock.getEBookname(numdown2+4));
				
				size = stock.getESize();
				
				if (size <= (numdown2 + 5)) {
					down2.setEnabled(false);
				}
				
				if (numdown2 >= 1) {
					up2.setEnabled(true);
				}
			} else if (event.getSource() == up1) {
				numdown1--;
				
				
				book5.setText(book4.getText());
				book4.setText(book3.getText());
				book3.setText(book2.getText());
				book2.setText(book1.getText());
				
				book1.setText(stock.getPBookname(numdown1));
				
				if (numdown1 == 0) {
					up1.setEnabled(false);
				}
				
				down1.setEnabled(true);
			} else if (event.getSource() == up2) {
				numdown2--;
				
				ebook5.setText(ebook4.getText());
				ebook4.setText(ebook3.getText());
				ebook3.setText(ebook2.getText());
				ebook2.setText(ebook1.getText());
				
				ebook1.setText(stock.getEBookname(numdown2));
				
				if (numdown2 == 0) {
					up2.setEnabled(false);
				}
				
				down2.setEnabled(true);
			} else if (event.getSource() == book1) {
				if (takemode == true) {
					stock.remPBook(numdown1);
					
					System.out.println("Bookcount:" + bookcount);
					
					bookcount--;
					numdown1 = 0;
					
					up1.setEnabled(false);
					
					if (bookcount < 6) {
						down1.setEnabled(false);
					} else {
						down1.setEnabled(true);
					}
					
					
					switch (bookcount) {
					case 0: book1.setVisible(false);
							book2.setVisible(false);
							book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
					break;
					case 1: book2.setVisible(false);
							book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
					break;
					case 2: book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
					break;
					case 3: book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
					break;
					case 4: book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
							book4.setText(stock.getPBookname(3));
					break;
					case 5:	book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
							book4.setText(stock.getPBookname(3));
							book5.setText(stock.getPBookname(4));
							
					break;
					default: book1.setText(stock.getPBookname(0));
							 book2.setText(stock.getPBookname(1));
							 book3.setText(stock.getPBookname(2));
							 book4.setText(stock.getPBookname(3));
							 book5.setText(stock.getPBookname(4));
					break;
					}
					
					takemode = false;
				} else if (infomode == true) {
					iname.setText("Title: " + stock.getPBookname(numdown1));
					iauthor.setText("Author: " + stock.getPAuthor(numdown1));
					idate.setText("Year Published: " + stock.getPYear(numdown1));
					iextra.setText("Type: " + stock.getPType(numdown1));
					
					infomode = false;
				}
				take.setEnabled(true);
				binfo.setEnabled(true);
			} else if (event.getSource() == book2) {
				if (takemode == true) {
					stock.remPBook(numdown1 + 1);
					
					bookcount--;
					numdown1 = 0;
					
					up1.setEnabled(false);
					
					if (bookcount < 6) {
						down1.setEnabled(false);
					} else {
						down1.setEnabled(true);
					}
					
					
					switch (bookcount) {
					case 0: book1.setVisible(false);
							book2.setVisible(false);
							book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
					break;
					case 1: book2.setVisible(false);
							book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
					break;
					case 2: book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
					break;
					case 3: book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
					break;
					case 4: book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
							book4.setText(stock.getPBookname(3));
					break;
					case 5:	book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
							book4.setText(stock.getPBookname(3));
							book5.setText(stock.getPBookname(4));
							
					break;
					default: book1.setText(stock.getPBookname(0));
							 book2.setText(stock.getPBookname(1));
							 book3.setText(stock.getPBookname(2));
							 book4.setText(stock.getPBookname(3));
							 book5.setText(stock.getPBookname(4));
					break;
					}
					
					takemode = false;
				} else if (infomode == true) {
					iname.setText("Title: " + stock.getPBookname(numdown1+1));
					iauthor.setText("Author: " + stock.getPAuthor(numdown1+1));
					idate.setText("Year Published: " + stock.getPYear(numdown1+1));
					iextra.setText("Type: " + stock.getPType(numdown1+1));
					
					infomode = false;
				}
				take.setEnabled(true);
				binfo.setEnabled(true);
			} else if (event.getSource() == book3) {
				if (takemode == true) {
					stock.remPBook(numdown1+2);
					
					bookcount--;
					numdown1 = 0;
					
					up1.setEnabled(false);
					
					if (bookcount < 6) {
						down1.setEnabled(false);
					} else {
						down1.setEnabled(true);
					}
					
					
					switch (bookcount) {
					case 0: book1.setVisible(false);
							book2.setVisible(false);
							book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
					break;
					case 1: book2.setVisible(false);
							book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
					break;
					case 2: book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
					break;
					case 3: book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
					break;
					case 4: book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
							book4.setText(stock.getPBookname(3));
					break;
					case 5:	book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
							book4.setText(stock.getPBookname(3));
							book5.setText(stock.getPBookname(4));
							
					break;
					default: book1.setText(stock.getPBookname(0));
							 book2.setText(stock.getPBookname(1));
							 book3.setText(stock.getPBookname(2));
							 book4.setText(stock.getPBookname(3));
							 book5.setText(stock.getPBookname(4));
					break;
					}
					takemode = false;
				} else if (infomode == true) {
					iname.setText("Title: " + stock.getPBookname(numdown1+2));
					iauthor.setText("Author: " + stock.getPAuthor(numdown1+2));
					idate.setText("Year Published: " + stock.getPYear(numdown1+2));
					iextra.setText("Type: " + stock.getPType(numdown1+2));
					
					infomode = false;
				}
				take.setEnabled(true);
				binfo.setEnabled(true);
			} else if (event.getSource() == book4) {
				if (takemode == true) {
					stock.remPBook(numdown1+3);
					
					bookcount--;
					numdown1 = 0;
					
					up1.setEnabled(false);
					
					if (bookcount < 6) {
						down1.setEnabled(false);
					} else {
						down1.setEnabled(true);
					}
					
					
					switch (bookcount) {
					case 0: book1.setVisible(false);
							book2.setVisible(false);
							book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
					break;
					case 1: book2.setVisible(false);
							book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
					break;
					case 2: book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
					break;
					case 3: book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
					break;
					case 4: book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
							book4.setText(stock.getPBookname(3));
					break;
					case 5:	book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
							book4.setText(stock.getPBookname(3));
							book5.setText(stock.getPBookname(4));
							
					break;
					default: book1.setText(stock.getPBookname(0));
							 book2.setText(stock.getPBookname(1));
							 book3.setText(stock.getPBookname(2));
							 book4.setText(stock.getPBookname(3));
							 book5.setText(stock.getPBookname(4));
					break;
					}
					takemode = false;
				} else if (infomode == true) {
					iname.setText("Title: " + stock.getPBookname(numdown1+3));
					iauthor.setText("Author: " + stock.getPAuthor(numdown1+3));
					idate.setText("Year Published: " + stock.getPYear(numdown1+3));
					iextra.setText("Type: " + stock.getPType(numdown1+3));
					
					infomode = false;
				}
				take.setEnabled(true);
				binfo.setEnabled(true);
			} else if (event.getSource() == book5) {
				if (takemode == true) {
					stock.remPBook(numdown1+4);
					
					bookcount--;
					numdown1 = 0;
					
					up1.setEnabled(false);
					
					if (bookcount < 6) {
						down1.setEnabled(false);
					} else {
						down1.setEnabled(true);
					}
					
					
					switch (bookcount) {
					case 0: book1.setVisible(false);
							book2.setVisible(false);
							book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
					break;
					case 1: book2.setVisible(false);
							book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
					break;
					case 2: book3.setVisible(false);
							book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
					break;
					case 3: book4.setVisible(false);
							book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
					break;
					case 4: book5.setVisible(false);
							
							book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
							book4.setText(stock.getPBookname(3));
					break;
					case 5:	book1.setText(stock.getPBookname(0));
							book2.setText(stock.getPBookname(1));
							book3.setText(stock.getPBookname(2));
							book4.setText(stock.getPBookname(3));
							book5.setText(stock.getPBookname(4));
							
					break;
					default: book1.setText(stock.getPBookname(0));
							 book2.setText(stock.getPBookname(1));
							 book3.setText(stock.getPBookname(2));
							 book4.setText(stock.getPBookname(3));
							 book5.setText(stock.getPBookname(4));
					break;
					}
					takemode = false;
				} else if (infomode == true) {
					iname.setText("Title: " + stock.getPBookname(numdown1+4));
					iauthor.setText("Author: " + stock.getPAuthor(numdown1+4));
					idate.setText("Year Published: " + stock.getPYear(numdown1+4));
					iextra.setText("Type: " + stock.getPType(numdown1+4));
					
					infomode = false;
				}
				take.setEnabled(true);
				binfo.setEnabled(true);
			} else if (event.getSource() == ebook1) {
				if (takemode == true) {
					stock.remEBook(numdown2);
					
					ebookcount--;
					numdown2 = 0;
					
					up2.setEnabled(false);
					
					if (ebookcount < 6) {
						down2.setEnabled(false);
					} else {
						down2.setEnabled(true);
					}
					
					
					switch (ebookcount) {
					case 0: ebook1.setVisible(false);
							ebook2.setVisible(false);
							ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
					break;
					case 1: ebook2.setVisible(false);
							ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
					break;
					case 2: ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
					break;
					case 3: ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
					break;
					case 4: ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
							ebook4.setText(stock.getEBookname(3));
					break;
					case 5:	ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
							ebook4.setText(stock.getEBookname(3));
							ebook5.setText(stock.getEBookname(4));
							
					break;
					default: ebook1.setText(stock.getEBookname(0));
							 ebook2.setText(stock.getEBookname(1));
							 ebook3.setText(stock.getEBookname(2));
							 ebook4.setText(stock.getEBookname(3));
							 ebook5.setText(stock.getEBookname(4));
					break;
					}
					takemode = false;
				} else if (infomode == true) {
					iname.setText("Title: " + stock.getEBookname(numdown2));
					iauthor.setText("Author: " + stock.getEAuthor(numdown2));
					idate.setText("Year Published: " + stock.getEYear(numdown2));
					iextra.setText("URL: " + stock.getEUrl(numdown2));
					
					infomode = false;
				}
				take.setEnabled(true);
				binfo.setEnabled(true);
			} else if (event.getSource() == ebook2) {
				if (takemode == true) {
					stock.remEBook(numdown2+1);
					
					ebookcount--;
					numdown2 = 0;
					
					up2.setEnabled(false);
					
					if (ebookcount < 6) {
						down2.setEnabled(false);
					} else {
						down2.setEnabled(true);
					}
					
					
					switch (ebookcount) {
					case 0: ebook1.setVisible(false);
							ebook2.setVisible(false);
							ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
					break;
					case 1: ebook2.setVisible(false);
							ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
					break;
					case 2: ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
					break;
					case 3: ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
					break;
					case 4: ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
							ebook4.setText(stock.getEBookname(3));
					break;
					case 5:	ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
							ebook4.setText(stock.getEBookname(3));
							ebook5.setText(stock.getEBookname(4));
							
					break;
					default: ebook1.setText(stock.getEBookname(0));
							 ebook2.setText(stock.getEBookname(1));
							 ebook3.setText(stock.getEBookname(2));
							 ebook4.setText(stock.getEBookname(3));
							 ebook5.setText(stock.getEBookname(4));
					break;
					}
					takemode = false;
				} else if (infomode == true) {
					iname.setText("Title: " + stock.getEBookname(numdown2+1));
					iauthor.setText("Author: " + stock.getEAuthor(numdown2+1));
					idate.setText("Year Published: " + stock.getEYear(numdown2+1));
					iextra.setText("URL: " + stock.getEUrl(numdown2+1));
					
					infomode = false;
				}
				take.setEnabled(true);
				binfo.setEnabled(true);
			} else if (event.getSource() == ebook3) {
				if (takemode == true) {
					stock.remEBook(numdown2+2);
					
					ebookcount--;
					numdown2 = 0;
					
					up2.setEnabled(false);
					
					if (ebookcount < 6) {
						down2.setEnabled(false);
					} else {
						down2.setEnabled(true);
					}
					
					
					switch (ebookcount) {
					case 0: ebook1.setVisible(false);
							ebook2.setVisible(false);
							ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
					break;
					case 1: ebook2.setVisible(false);
							ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
					break;
					case 2: ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
					break;
					case 3: ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
					break;
					case 4: ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
							ebook4.setText(stock.getEBookname(3));
					break;
					case 5:	ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
							ebook4.setText(stock.getEBookname(3));
							ebook5.setText(stock.getEBookname(4));
							
					break;
					default: ebook1.setText(stock.getEBookname(0));
							 ebook2.setText(stock.getEBookname(1));
							 ebook3.setText(stock.getEBookname(2));
							 ebook4.setText(stock.getEBookname(3));
							 ebook5.setText(stock.getEBookname(4));
					break;
					}
					takemode = false;
				} else if (infomode == true) {
					iname.setText("Title: " + stock.getEBookname(numdown2+2));
					iauthor.setText("Author: " + stock.getEAuthor(numdown2+2));
					idate.setText("Year Published: " + stock.getEYear(numdown2+2));
					iextra.setText("URL: " + stock.getEUrl(numdown2+2));
					
					infomode = false;
				}
				take.setEnabled(true);
				binfo.setEnabled(true);
			} else if (event.getSource() == ebook4) {
				if (takemode == true) {
					stock.remEBook(numdown2 + 3);
					
					ebookcount--;
					numdown2 = 0;
					
					up2.setEnabled(false);
					
					if (ebookcount < 6) {
						down2.setEnabled(false);
					} else {
						down2.setEnabled(true);
					}
					
					
					switch (ebookcount) {
					case 0: ebook1.setVisible(false);
							ebook2.setVisible(false);
							ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
					break;
					case 1: ebook2.setVisible(false);
							ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
					break;
					case 2: ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
					break;
					case 3: ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
					break;
					case 4: ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
							ebook4.setText(stock.getEBookname(3));
					break;
					case 5:	ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
							ebook4.setText(stock.getEBookname(3));
							ebook5.setText(stock.getEBookname(4));
							
					break;
					default: ebook1.setText(stock.getEBookname(0));
							 ebook2.setText(stock.getEBookname(1));
							 ebook3.setText(stock.getEBookname(2));
							 ebook4.setText(stock.getEBookname(3));
							 ebook5.setText(stock.getEBookname(4));
					break;
					}
					takemode = false;
				} else if (infomode == true) {
					iname.setText("Title: " + stock.getEBookname(numdown2+3));
					iauthor.setText("Author: " + stock.getEAuthor(numdown2+3));
					idate.setText("Year Published: " + stock.getEYear(numdown2+3));
					iextra.setText("URL: " + stock.getEUrl(numdown2+3));
					
					infomode = false;
				}
				take.setEnabled(true);
				binfo.setEnabled(true);
			} else if (event.getSource() == ebook5) {
				if (takemode == true) {
					stock.remEBook(numdown2 + 4);
					
					ebookcount--;
					numdown2 = 0;
					
					up2.setEnabled(false);
					
					if (ebookcount < 6) {
						down2.setEnabled(false);
					} else {
						down2.setEnabled(true);
					}
					
					
					switch (ebookcount) {
					case 0: ebook1.setVisible(false);
							ebook2.setVisible(false);
							ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
					break;
					case 1: ebook2.setVisible(false);
							ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
					break;
					case 2: ebook3.setVisible(false);
							ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
					break;
					case 3: ebook4.setVisible(false);
							ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
					break;
					case 4: ebook5.setVisible(false);
							
							ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
							ebook4.setText(stock.getEBookname(3));
					break;
					case 5:	ebook1.setText(stock.getEBookname(0));
							ebook2.setText(stock.getEBookname(1));
							ebook3.setText(stock.getEBookname(2));
							ebook4.setText(stock.getEBookname(3));
							ebook5.setText(stock.getEBookname(4));
							
					break;
					default: ebook1.setText(stock.getEBookname(0));
							 ebook2.setText(stock.getEBookname(1));
							 ebook3.setText(stock.getEBookname(2));
							 ebook4.setText(stock.getEBookname(3));
							 ebook5.setText(stock.getEBookname(4));
					break;
					}
					takemode = false;
				} else if (infomode == true) {
					iname.setText("Title: " + stock.getEBookname(numdown2+4));
					iauthor.setText("Author: " + stock.getEAuthor(numdown2+4));
					idate.setText("Year Published: " + stock.getEYear(numdown2+4));
					iextra.setText("URL: " + stock.getEUrl(numdown2+4));
					
					infomode = false;
				}
				take.setEnabled(true);
				binfo.setEnabled(true);
			}
			
		}
		
}

