import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NonTerminale implements Simbolo {
	
	private final String name;
	private static String exp_name="[A-Z]";
	
	public NonTerminale(String name) {
		this.name = name;
	}

	public boolean checkNonTerminale (String name)
    {         
        Pattern pattern = Pattern.compile(exp_name);
        Matcher matcher = pattern.matcher(name);

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

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof NonTerminale)) {
			return false;
		}
		NonTerminale other = (NonTerminale) obj;
		return name.equals(other.name);
	}
}