import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GestoreFileEsterni {
	private String nameFile;
	private File f;
	private LinkedList<String> lis;
 	
	public GestoreFileEsterni(String name) throws IOException{
		this.nameFile=name;
		f=new File("src\\GrammaticheEsterne\\"+name);
	}
	
	public GestoreFileEsterni(LinkedList<String> lis){
		this.lis=lis;
	}
	
	public void stampaFile(Grammatica g){
		System.out.println("Terminali: " + g.getTerminals());
		System.out.println("Non terminali: " + g.getNonTerminals());
		System.out.println("Start Symbol: " + g.getStart());
		List<Produzione> lis = g.getRules();
		ListIterator<Produzione> prod = lis.listIterator();
		while(prod.hasNext()){
			System.out.println(prod.next());
		 }
	}
	
	public void scriviAltroFile(Grammatica g){
		ObjectOutputStream os= null;
        
        try{
            os = new ObjectOutputStream(new FileOutputStream(f));
            os.writeObject(g);
            os.flush();
            os.close();
        }
        catch(Exception e){
            System.out.println("Errore nella scrittura del file !!");
        }
	}
	
	public void scriviFile(Grammatica g){
		PrintWriter w= null;
        
        try{
        	w = new PrintWriter (new FileWriter(f), true);
			w.println(g.getTerminals());
			w.println(g.getNonTerminals());
			w.println(g.getStart());
			w.println(g.getRules());
        }
        catch(Exception e){
            System.out.println("Errore nella scrittura del file !!");
        }
	}
	
	public LinkedList<String> visualizzaFileEsterno(){
        File dir = new File("src\\GrammaticheEsterne\\");
        LinkedList<String> ll = new LinkedList<>();
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Directory errata");
        }else{
            for(int i=0;i<files.length;i++){
                String st = files[i].getName();
                if(files[i].getName().endsWith("txt")){
                    ll.add(st);
                }
            }
        }
        return ll;
    } 
	
	public void stampaFile(LinkedList<String> ll){
        System.out.println("Lista delle grammatiche");
        for (int i=0; i<ll.size();i++){
            System.out.println(i + " - " + ll.get(i));
        }
    }
	

	public Grammatica leggiFileEsterno(){
		String in;
		String str = "";
        Grammatica g = new Grammatica();
        boolean context = true;
        Grammatica gr = null;
        try {
            BufferedReader br= new BufferedReader(new FileReader (f));
            
            in = br.readLine();
            for(int index = 0; index<in.length();index++){
            	String str1 = null;
            	str = "";
            	do{
        			str1 = String.valueOf(in.charAt(index));
            		if(!(str1.equals(",")) && (!(str1.equals(";")))){
            			str = str.concat(str1);
            			index++;
            		}
            	}while(!(str1.equals(",")) && !(str1.equals(";")));
            	Terminale t = new Terminale(str);
                g.getTerminals().add(t);
            }
            in = br.readLine();
            for(int j = 0; j<in.length();j++){
            	str = String.valueOf(in.charAt(j));
            	j++;
            	NonTerminale nt = new NonTerminale(str);
                g.getNonTerminals().add(nt);
            }
            NonTerminale st = new NonTerminale(br.readLine());
            g.getNonTerminals().add(0,st);
            
            NonTerminale lhs;
        	List<Simbolo> rhs = new LinkedList<Simbolo>();
        	Produzione p;
        	while((in = br.readLine())!=null){
            			str = String.valueOf(in.charAt(0));
                		lhs = new NonTerminale(str);
                		g.getLhss().add(lhs);
    					if(!String.valueOf(in.charAt(1)).equals("-")){
        					context = false;
        					System.out.println("ERRORE: GRAMMATICA NON CONTESTUALE");
        					System.out.println("Interruzione della lettura del file selezionato");
        					break;
    					} else{
        					rhs = new LinkedList<Simbolo>();
    						for(int j = 3; j<in.length();j++){
    							str = String.valueOf(in.charAt(j));
        						String str2 = "";
    			            	do{
    			        			str = String.valueOf(in.charAt(j));
    			            		if(!(str.equals(",")) && (!(str.equals(";")))){
    			            			str2 = str2.concat(str);
    			            			j++;
    			            		}
    			            	}while(!(str.equals(",")) && !(str.equals(";")));
        						NonTerminale ntsym;
        						Terminale tsym;
        						ntsym = new NonTerminale(str2);
        						tsym = new Terminale(str2);
        						if(g.getNonTerminals().contains(ntsym)){
        							rhs.add(ntsym);
        						} else if(g.getTerminals().contains(tsym)){
        							rhs.add(tsym);
        						}
        	            	}
        					p = new Produzione(lhs, rhs);        					
        					g.getRules().add(p);
        				}
        		}                
        	gr = new Grammatica(st, g.getRules(), g.getLhss(), g.getNonTerminals(), g.getTerminals());
        	gr.setIsContextFree(context);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gr;
	}
}
