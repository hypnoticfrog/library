import java.util.*;

public class EBook extends Book {

	private final String CODE_VALUES = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String accessCode = "";

	public EBook(){
		super();
		Random ranGen = new Random();
		for(int i = 0; i < 15; i++){
			accessCode = accessCode + CODE_VALUES.charAt(ranGen.nextInt(62));
		}
	}
	public String getAccessCode(){
		return accessCode;
	}
	public String toString(){
		return "\""+ title + "\" by:" + author + " " + accessCode;
	}

}
