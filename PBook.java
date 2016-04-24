package chapterninepointproject;

public class PBook extends Book {

	private String type ;

	public PBook(String title, String author, int year, int type) {
		super(title, author, year);
		
		if (type == 1) {
			this.type = "softcover";
		} else if (type == 2) {
			this.type = "hardcover";
		}
	}

	public String getType(){
		return type;
	}
	
}