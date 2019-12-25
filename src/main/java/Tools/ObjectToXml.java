package Tools;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class ObjectToXml
{
    public static void create()
    {
        //Java object. We will convert it to XML.
        Employee employee = new Employee(1, "Lokesh", "Gupta");

        //Method which uses JAXB to convert object to XML
        jaxbObjectToXML(employee);
    }

    private static void jaxbObjectToXML(Employee employee)
    {
        try
        { //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print XML String to Console
            StringWriter sw = new StringWriter();

            //Write XML to StringWriter
            jaxbMarshaller.marshal(employee, sw);

            //Verify XML Content
            String xmlContent = sw.toString();
            System.out.println( xmlContent );

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
