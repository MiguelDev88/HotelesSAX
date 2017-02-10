package hotelessax;
import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Miguel
 */
public class HotelesSAX {


    public static void main(String[] args) {
        
        try {  
            
	    XMLReader reader = XMLReaderFactory.createXMLReader();  
	    reader.setContentHandler(new XMLHandler());
            reader.parse(new InputSource(new FileInputStream("hoteles.xml")));
        
        } catch (SAXException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) { 
            System.out.println(e.getMessage());  
	}  
    }
}
