
public class PBook extends Book {

	private int numOfStock;
	private String type ;

	public PBook() {
		super();
	}

	public void setStock(int stock){
		this.numOfStock = stock;
	}
	public int getStock(){
		return numOfStock;
	}
	public void addStock(int add){
		this.numOfStock = this.numOfStock + add;
	}
	public void subStock(int sub){
		this.numOfStock = this.numOfStock - sub;
	}

	public void setType(int i) {
		if (i == 1) {
			type = "softcover";
		} else if (i == 2) {
			type = "hardcover";
		}
	}
	public String getType(){
		return type;
	}
	public String toString(){
		return type+ " \"" + title + "\" by:" + author;
	}
	
}