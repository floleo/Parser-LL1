import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;
//import org.jfree.graphics2d.svg.SVGGraphics2D;

public class MainSVG {

  public void paint(Graphics2D g2d) {
	  
	g2d.setPaint(Color.black);
	int i = 0, x = 0, y = 0, w = 25, h = 0;
	List<Integer> l = new LinkedList<>();
	for(int j=0;j<101;j++)
		l.add(j);
	for(i = 0; i<101; i++){
		g2d.setColor(Color.BLACK);
	    g2d.drawLine(0, x, 325, x);
	    g2d.drawLine(0, 0, 0, 100);
	    g2d.drawLine(w, 0, w, 100);
	    g2d.drawString(String.valueOf(l.get(i))+"->"+"rhs", 30, y);
	    g2d.drawString(String.valueOf(l.get(i)), 3, y);
	    g2d.setColor(Color.BLACK);
		//g2d.drawString("D", w, h);
		i+=19;
		x+=20;
		y+=20;
		w+=60;
		//h+=10;
		
	}
    //g2d.fill(new Rectangle(10, 10, 100, 100));
  }

  public static void main(String[] args) throws IOException {

    // Get a DOMImplementation.
    DOMImplementation domImpl =
      GenericDOMImplementation.getDOMImplementation();

    // Create an instance of org.w3c.dom.Document.
    String svgNS = "http://www.w3.org/TR/SVG11/";
    Document document = domImpl.createDocument(svgNS, "svg", null);
    
    // Create an instance of the SVG Generator.
    SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
    // Ask the test to render into the SVG Graphics2D implementation.
    MainSVG test = new MainSVG();
    test.paint(svgGenerator);

    // Finally, stream out SVG to the standard output using
    // UTF-8 encoding.
    boolean useCSS = true; // we want to use CSS style attributes
    File f = new File("svgFile.svg");
    OutputStream outputStream = new FileOutputStream(f);
    Writer out = new OutputStreamWriter(outputStream, "UTF-8");
    svgGenerator.stream(out, useCSS);  
    outputStream.flush();
    outputStream.close();
  }
}