public interface Simbolo {
	
	public static final Terminale EPSILON = new Terminale("epsilon");
	public static final Terminale EOF = new Terminale("eof");

	public String getName();

	
}