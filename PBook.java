package chapterninepointproject;

public class PBook extends Book {

	private String type;
	
	public PBook() {
		
	}
	
	public void setType(int i) {
		if (i == 1) {
			type = "softcover";
		} else if (i == 2) {
			type = "hardcover";
		}
	}
	
}
