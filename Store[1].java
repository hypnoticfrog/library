import java.util.*;
public class Store {
	private ArrayList<PBook> Pstock = new ArrayList<PBook>();
	private ArrayList<EBook> Estock = new ArrayList<EBook>();

	public Store(){
	}

	public void giveElec(String title, String author, int year){
		int tester = 0;
		EBook newBook = helperEBook(title, author,year);
		if(Estock.size() == 0){
			Estock.add(newBook);	
		}else
		{
			for(int i = 0; i < Estock.size(); i++){	
				if(Estock.get(i).getTitle().equalsIgnoreCase(title) && Estock.get(i).getAuthor().equalsIgnoreCase(author)){
					tester++;	
				}
			}
			if(tester == 0){
				Estock.add(newBook);
			}
		}
	}
	public void givePaper(String title, String author, int type, int numOfDonate, int year){
		int tester = 0;
		String cover = helperCover(type);
		PBook newBook = helperPBook(title, author, type, numOfDonate, year);
		
		if(Pstock.size() == 0){
			Pstock.add(newBook);
		}else
		{
			for(int i = 0; i < Pstock.size(); i++){
				if(Pstock.get(i).getTitle().equalsIgnoreCase(title) && Pstock.get(i).getAuthor().equalsIgnoreCase(author)
						&& Pstock.get(i).getType() == cover){
					Pstock.get(i).addStock(numOfDonate);
					tester++;
				}
			}
			if(tester == 0){
				Pstock.add(newBook);
			}
		}
	}
	//takes PBook, tests if it is in the arraylist, if not or list is empty returns error message, if in life returns message
	public String buyPaper(String title, String author, int type){
		int tester = 0;
		String returnString = "";
		String cover = helperCover(type);

		
		if(Pstock.size() == 0){
			returnString = "There is no books available";	
		}else
		{
			for(int i = 0; i < Pstock.size(); i++){
				if(Pstock.get(i).getTitle().equalsIgnoreCase(title) && Pstock.get(i).getAuthor().equalsIgnoreCase(author)
						&& Pstock.get(i).getType() == cover){
					Pstock.get(i).subStock(1);
					tester++;
					returnString = "You got a " + cover + " copy of \"" + title + "\"";
				}
			}
			if(tester == 0){
				return "That is not a valid book";
			}
		}
		return returnString;
	}
	//takes EBook, tests if it is in the arraylist, if not or list is empty returns error message, if in life returns message
	public String buyElec(String title, String author){
		int tester = 0;
		String returnString = "";
		if(Estock.size() == 0){
			returnString = "There is no books available";	
		}else
		{
			for(int i = 0; i < Estock.size(); i++){
				if(Estock.get(i).getTitle().equalsIgnoreCase(title) && Estock.get(i).getAuthor().equalsIgnoreCase(author)){
					tester++;
					returnString = "Your copy of \"" + title + "\" can be accessed by using the access code: " + Estock.get(i).getAccessCode();
				}
			}
			if(tester == 0){
				return "That is not a valid book";
			}
		}
		return returnString;
	}
	
	//arraylist getters, returns string of the list
	public String getLibraryPaper(){
		String pLibrary = "";
		for(int i = 0; i < Pstock.size(); i++){
			pLibrary = pLibrary + "* " + Pstock.get(i) + "* ";
		}
		return pLibrary;
	}
	public String getLibraryElec(){
		String ELibrary = "";
		for(int i = 0; i < Estock.size(); i++){
			ELibrary = ELibrary + "*" + Estock.get(i) + "* ";
		}
		return ELibrary;
	}
	
	//helper classes for reused code
	private String helperCover(int type){
		String cover = "";
		if (type == 1) {
			cover = "softcover";
		} else if (type == 2) {
			cover = "hardcover";
		}
		return cover;
	}
	private EBook helperEBook(String title, String author, int year){
		EBook newBook = new EBook();
		newBook.setTitle(title);
		newBook.setAuthor(author);
		newBook.setYear(year);
		return newBook;
	}
	private PBook helperPBook(String title, String author, int type, int numOfDonate, int year){
		PBook newBook = new PBook();
		newBook.setTitle(title);
		newBook.setAuthor(author);
		newBook.setType(type);
		newBook.setStock(numOfDonate);
		newBook.setYear(year);
		return newBook;
		
	}
}
