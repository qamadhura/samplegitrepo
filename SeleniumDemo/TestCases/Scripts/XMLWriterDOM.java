package Scripts;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
 
public class XMLWriterDOM {
 
    public static void WriteXml() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
          
            Element rootElement =
                doc.createElementNS("https://www.neovasolutions.com/employee", "Employees");
          
            doc.appendChild(rootElement);
 
           
            rootElement.appendChild(getEmployee(doc, "1", "Madhura", "29", "Java Developer", "Female"));
 
           
            rootElement.appendChild(getEmployee(doc, "2", "Darshana", "35", "Manager", "Female"));
 
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
           
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
 
          
      //      StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("D:\\Java_Test\\SeleniumDemo\\Files\\xmldemo.xml"));
 
     
       //     transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
 
    private static Node getEmployee(Document doc, String id, String name, String age, String role,
            String gender) {
        Element employee = doc.createElement("Employee");
 
      
        employee.setAttribute("id", id);
 
       
        employee.appendChild(getEmployeeElements(doc, employee, "name", name));
 
       
        employee.appendChild(getEmployeeElements(doc, employee, "age", age));
 
       
        employee.appendChild(getEmployeeElements(doc, employee, "role", role));
 
       
        employee.appendChild(getEmployeeElements(doc, employee, "gender", gender));
 
        return employee;
    }
 
 
  
    private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
    public static void ReadXml() {
    	 try {  
   		  
  		   File xmlFile = new File("D:\\Java_Test\\SeleniumDemo\\Files\\xmldemo.xml");  
  		   DocumentBuilderFactory documentFactory = DocumentBuilderFactory  
  		     .newInstance();  
  		   DocumentBuilder documentBuilder = documentFactory  
  		     .newDocumentBuilder();  
  		   Document doc = documentBuilder.parse(xmlFile);  
  		  
  		   doc.getDocumentElement().normalize();  
  		   NodeList nodeList = doc.getElementsByTagName("Employee");  
  		  
  		   System.out.println("Root element :"  
  		     + doc.getDocumentElement().getNodeName());  
  		  
  		   for (int i = 0; i < nodeList.getLength(); i++) {  
  		    Node node = nodeList.item(i);  
  		  
  		    System.out.println("\nElement type :" + node.getNodeName());  
  		  
  		    if (node.getNodeType() == Node.ELEMENT_NODE) {  
  		  
  		     Element employee = (Element) node;  
  		  
  		     System.out.println("employee id : "  
  		       + employee.getAttribute("id"));  
  		     System.out.println("Name : "  
  		       + employee.getElementsByTagName("name").item(0)  
  		         .getTextContent());  
  		     System.out.println("Age : "  
  		       + employee.getElementsByTagName("age").item(0)  
  		         .getTextContent());  
  		     System.out.println("Role : "  
  		       + employee.getElementsByTagName("role").item(0)  
  		         .getTextContent());  
  		     System.out.println("Gender : "  
  		       + employee.getElementsByTagName("gender").item(0)  
  		         .getTextContent());  
  		  
  		    }  
  		   }  
  		  } catch (Exception e) {  
  		   e.printStackTrace();  
  		  }  
    }
    public static void main(String[] args) {
    	WriteXml();
    	ReadXml();
    }
 
}