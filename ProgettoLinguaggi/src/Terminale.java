import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Terminale implements Simbolo, Serializable {

	private static final long serialVersionUID = 1L;
	private final String name;
	//definizione dell'espressione regolare per i terminali che possono comprendere da uno a più caratteri purché siano minuscoli
	private static String exp_name = "[^A-Z]+";
	
	public Terminale(String name) {
		this.name = name;
	}
	
	//funzione che fa un controllo sui terminali in modo da scartare quelli non previsti dall'espressione regolare
	public boolean checkTerminale ()
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
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof Terminale)) {
			return false;
		}
		Terminale other = (Terminale) obj;
		return name.equals(other.name);
	}

}