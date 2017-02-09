package hotelessax;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Miguel
 */
public class XMLHandler extends DefaultHandler{
    
    private String msg;
    
    public XMLHandler(){}
    
    
   @Override  
   public void startDocument() throws SAXException {  
      System.out.println("\nStart of the document...");  
   }  

   @Override  
   public void endDocument() throws SAXException {  
      System.out.println("\nFin del documento...");  
   }  

   @Override  
   public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {  
       System.out.println("\nProcesing Tag...");  

       //checking if the Element has any namespace linked to it
      if(uri.length()>0){
          System.out.println("\tNamespace uri: "+uri);
      }
      //name of the tag
      System.out.println("\tName: "+localName);  
      //name + namespace
      System.out.println("\tName with namespace: "+name);  

      //checking the attributes of the element
      if(attributes.getLength()>0){
          System.out.println("\tProcesing "+attributes.getLength()+" attributes...");  
          //for each attribute we print the name and the value
          for(int i=0;i<attributes.getLength();i++){  
             System.out.println("\t\t"+attributes.getQName(i)+": "+attributes.getValue(i));  
          }  
      }
      //the next its a bit weird, here he searchs for an attribute id, using the getValue method
      //by qname instead of index, then checks if the String is null, and if its not, he prints the value
      //in this excercice we have no id Attribute, so.. it does nothing
      String valorId = attributes.getValue("id");  
      if(valorId!=null){  
         System.out.println("\tId: "+valorId);  
      }  

   }  

   @Override  
   public void characters(char[] ch, int start, int length) throws SAXException {  
       //we have a boolean to check if the text matches the chain we want
       boolean Text=false;

       for(int i=start;i<start+length;i++){
           //for each letter of the text we check if any of the letters matches the textchain 
           //we are interested in
           if((""+ch[i]).matches("[A-z0-9]")){
               //if it does, we set the boolean true
               Text=true;
           }
       }

       if(Text){
      System.out.println("\nProcesing text inside the tag... ");  
      System.out.println("\tText: "+String.valueOf(ch, start, length));  
       }
   }  

   @Override  
   public void endElement(String uri, String localName, String name)  
         throws SAXException {  

      System.out.println("\nEnd of a tag...");  

      if(uri.length()>0){
          System.out.println("\tNamespace uri: "+uri);
      }
      System.out.println("\tName: "+localName);  
      System.out.println("\tName with Namespace: "+name);  
   }  

}
