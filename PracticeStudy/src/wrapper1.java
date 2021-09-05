package Object2;

public class wrapper1 {
	public static void main(String[] args) {
		Integer num = new Integer(17);	// ¹Ú½Ì
		int n = num.intValue();			// ¾ğ¹Ú½Ì
		System.out.println(n);
				
		Character ch = 'X';		// Character ch = new Character('X'); : ¿ÀÅä¹Ú½Ì
		char c = ch;			// char c = ch.charValue();           : ¿ÀÅä¾ğ¹Ú½Ì
		System.out.println(c);
	}
}
