import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CreaTabella {
	
	public void paint(Graphics2D g2d, Grammatica g) {
	  	
		ParserLL ll = new ParserLL(g);
		ll.calcFirst();
		ll.calcFollow();
		ll.calcPredict();
    	g2d.setPaint(Color.black);
    	int x = 30, y = 55, w = 30;
    	List<NonTerminale> nt = g.getNonTerminals();
    	//Set<NonTerminale> snt = new HashSet<>();
    	List<Terminale> t = g.getTerminals();
    	//Set<Terminale> st = new HashSet<>();
        List<Produzione> pr = g.getRules();
        Map<Produzione, Set<Terminale>> predict = new HashMap<>();
        predict = ll.getPredict();

    	//linee colonne
    	for(int k=0;k<t.size();k++){
    		g2d.setColor(Color.BLACK);
    	    g2d.drawLine(w, 0, w, 30*(pr.size()+1)+40);
    	    //if(predict.containsValue(f.get(k)));
    	    //g2d.drawString(pr.get(k).getLHS().getName()+"->"+pr.get(k).getRHS(), w-20, 45);
    	    g2d.drawString(String.valueOf(t.get(k)), 45+w, 15);
    		w+=100;
    	}
    	g2d.drawLine(0, 0, 0, 30*(pr.size()+1)+40);
    	g2d.drawLine(30+100*(t.size()), 0, 30+100*(t.size()), 30*(pr.size()+1)+40);
    	
    	//linee righe
    	for(int i = 0; i<nt.size(); i++){
    		
    		g2d.setColor(Color.BLACK);
    	    g2d.drawLine(0, x, 30+100*(t.size()), x);
    	    g2d.drawString(nt.get(i).getName()+"->"+pr.get(i).getRHS(), 40, y);
    	    g2d.drawString(nt.get(i).getName(), 10, y);
    		x+=40;
    		y+=40;
    	}
    	g2d.drawLine(0, 0, 30+100*t.size(), 0);
    	g2d.drawLine(0, x, 30+100*(t.size()), x);
	    
    	
    	/*
    	for(int c = 0; c<pr.size();c++){
    		for(int b = 0; b<t.size();b++){
    			if(predict.get(c).contains(t.get(b)))
    				y = 55;
    	    	for(int a = 0; a<nt.size();a++){
    	    		if(predict.keySet().contains(nt.get(a)))
    	    			g2d.drawString(nt.get(a).getName()+"->"+pr.get(c).getRHS(), 40+100*t.indexOf(b), y);
    	    		y+=40;
    			}
    		}
    	}
    	*/
	}	
}
