import java.awt.*;

import org.w3c.dom.Document;

import java.awt.event.*;

import javax.swing.*;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherAdapter;
import org.apache.batik.swing.svg.SVGLoadEventDispatcherEvent;

public class ApriSVG {

	JFrame frame;
    JSVGCanvas canvas;
    Document document;
    Window window;

	@SuppressWarnings("deprecation")
	public ApriSVG(String file, String risp) {
        frame = new JFrame("Parsing Table");
        frame.setLocation(200, 100);
        canvas = new JSVGCanvas();

        canvas.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);
        canvas.addSVGLoadEventDispatcherListener
            (new SVGLoadEventDispatcherAdapter() {
                    public void svgLoadEventDispatchStarted
                        (SVGLoadEventDispatcherEvent e) {
                        	document = canvas.getSVGDocument();
                        	frame.pack();
                    	}
            		});

        frame.addWindowListener(new WindowAdapter() {
                public void windowOpened(WindowEvent e) {
                	if(risp.equals("s")){
                		canvas.setURI("src\\GrammaticheEsterne\\" + file + ".svg");
                	} else canvas.setURI("src\\Grammatiche\\" + file + ".svg");
                }
            });

        frame.getContentPane().add(canvas);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.show();
    }


}

