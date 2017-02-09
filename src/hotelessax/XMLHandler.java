package hotelessax;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Miguel
 */
public class XMLHandler extends DefaultHandler{
    
    public XMLHandler(){}
    
    
   @Override  
   public void startDocument() throws SAXException {  
      System.out.println("\n-----------------  Start of the document ----------------- ");  
   }  

   @Override  
   public void endDocument() throws SAXException {  
      System.out.println("\n----------------- End of the document ----------------- ");  
   }  

   @Override  
   public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {  
       
      System.out.println("-- Start of the Element -- "+name.toUpperCase());   
      if(attributes.getLength()>0){
          System.out.println("   - Procesing "+attributes.getLength()+" attributes -");  
          for(int i=0;i<attributes.getLength();i++){  
             System.out.println("        "+attributes.getQName(i)+" = "+attributes.getValue(i));  
          }  
      } 
   }  

   @Override  
   public void characters(char[] ch, int start, int length) throws SAXException { 
       
       
       boolean Text=false;

       for(int i=start;i<start+length;i++){
           if((""+ch[i]).matches("[A-z0-9]"))
               Text=true;
       }
       if(Text){
           System.out.println("         - Procesing text inside the tag - ");  
           System.out.println("         Text: "+String.valueOf(ch, start, length));
      }
   }  

   @Override  
   public void endElement(String uri, String localName, String name){  
       
       System.out.println("-- End of the Element -- "+name.toUpperCase());   
       
   }  

}
