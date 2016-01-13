import java.awt.Color;
import java.awt.Graphics2D;
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
    	List<Terminale> t = g.getTerminals();
        Map<Produzione, Set<Terminale>> predict = ll.getPredict();
        Set<Produzione> set = predict.keySet();
        t.add(Simbolo.EOF);
        
        //linee colonne
    	for(int k=0;k<t.size();k++){
    		g2d.setColor(Color.BLACK);
    	    g2d.drawLine(w, 0, w, 40*nt.size()+30);
    	    g2d.drawString(String.valueOf(t.get(k)), 45+w, 15);
    		w+=100;
    	}
    	g2d.drawLine(0, 0, 0, 40*nt.size()+30);
    	g2d.drawLine(30+100*(t.size()), 0, 30+100*(t.size()), 40*nt.size()+30);
    	
    	//linee righe
    	for(int i = 0; i<nt.size(); i++){
    		
    		g2d.setColor(Color.BLACK);
    	    g2d.drawLine(0, x, 30+100*(t.size()), x);
    	    g2d.drawString(nt.get(i).getName(), 10, y);
    		x+=40;
    		y+=40;
    	}
    	g2d.drawLine(0, 0, 30+100*t.size(), 0);
    	g2d.drawLine(0, x, 30+100*(t.size()), x);
	    
    	
    	for(int b = 0; b<t.size();b++){
    		Iterator<Produzione> it = set.iterator();
    	    while(it.hasNext()){
    			y = 55;
    			Produzione z = it.next();
    			if(predict.get(z).contains(t.get(b))){
    	        	for(int a = 0; a<nt.size();a++){
    					if(z.getLHS().equals(nt.get(a))){
    						g2d.drawString(z.getLHS()+"->"+z.getRHS(), 40+100*b, y);
    					}
    					y+=40;
    				}
    			}
    		}
		}
    	t.remove(Simbolo.EOF);
	}	
}
