import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NonTerminale implements Simbolo, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String name;
	private static String exp_name="[A-Z]";
	
	public NonTerminale(String name) {
		this.name = name;
	}

	public boolean checkNonTerminale ()
    {         
        Pattern pattern = Pattern.compile(exp_name);
        Matcher matcher = pattern.matcher(this.name);

        if (matcher.matches())
           return true;
        else
           return false;
    } 
	
	@Override
	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return getName();
	}

}