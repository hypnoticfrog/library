package chapterninepointproject;

import java.util.*;
public class Stock {
	private ArrayList<PBook> pstock = new ArrayList<PBook>();
	private ArrayList<EBook> estock = new ArrayList<EBook>();

	public Stock(){
	}

	/* public void giveElec(String title, String author, int year){
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
		
		if (Estock.size() == 0) {
			returnString = "There is no books available";	
		} else {
			for (int i = 0; i < Estock.size(); i++) {
				if (Estock.get(i).getTitle().equalsIgnoreCase(title) && Estock.get(i).getAuthor().equalsIgnoreCase(author)) {
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
	*/
	
	//helper classes for reused code
	
	
	public void setEBook(String title, String author, int year, String url){
		
		estock.add(new EBook(title, author, year, url));
	}
	public void setPBook(String title, String author, int year, boolean issoftcover){
		int type = 0;
		
		if (issoftcover == true) {
			type = 1;
		} else if (issoftcover == false) {
			type = 2;
		}
		
		pstock.add(new PBook(title,author, year, type));
	}
	
	public int getPSize() {
		return pstock.size();
	}
	
	public int getESize() {
		return estock.size();
	}
	
	//used for initial setting of title on buttons
	
	public String getEBookname() {
		return estock.get(estock.size()-1).getTitle();
	}
	
	public String getEBookname(int num) {
		return estock.get(num).getTitle();
	}
	
	public String getPBookname() {
		return pstock.get(pstock.size()-1).getTitle();
	}
	
	public String getPBookname(int num) {
		return pstock.get(num).getTitle();
	}
	
	public void remPBook(int n) {
		pstock.remove(n);
	}
	
	public void remEBook(int n) {
		estock.remove(n);
	}
	
	public String getPAuthor(int n) {
		return pstock.get(n).getAuthor();
	}
	
	public String getEAuthor(int n) {
		return estock.get(n).getAuthor();
	}
	
	public int getPYear(int n) {
		return pstock.get(n).getYear();
	}
	
	public int getEYear(int n) {
		return estock.get(n).getYear();
	}
	
	//used for getting either the type of physical book or the url of ebook
	public String getPType(int n) {
		return pstock.get(n).getType();
	}
	
	public String getEUrl(int n) {
		return estock.get(n).getUrl();
	}
	
	
	
}