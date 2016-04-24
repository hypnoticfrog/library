package chapterninepointproject;

import java.util.*;

public class EBook extends Book {
	
	

	private final String CODE_VALUES = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String accessCode = "";
	private String url;

	public EBook(String title, String author, int year, String url){
		super(title, author, year);
		this.url = url;
		
	}
	
	public String getUrl() {
		return url;
	}
	public String getAccessCode(){
		return accessCode;
	}
	
	/*Random ranGen = new Random();
	for(int i = 0; i < 15; i++){
		accessCode = accessCode + CODE_VALUES.charAt(ranGen.nextInt(62));
	}
	*/
}