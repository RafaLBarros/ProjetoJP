package model;
import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
  
 
public class ScoreDocumentFilter extends DocumentFilter {
	public void replace(FilterBypass fb, int offset, int length,String str, AttributeSet attr) throws BadLocationException {
		if ((fb.getDocument().getLength() + str.length()) <= 3)
	        fb.replace(offset, length, str.toUpperCase(), attr);
		else 
	        Toolkit.getDefaultToolkit().beep();
	}
}
