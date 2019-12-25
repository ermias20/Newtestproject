package Tools;


import io.testproject.java.sdk.v2.enums.ExecutionResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class CreateXml  {
    Document doc;
    public String Company="";
    public String Date="";
    public String Time="";
    public String ID="";
    public String Tr="";
    public String FirstName="";
    public String MiddleName="";
    public String LastName="";
    public String Gender="";
    public String Birthday="";



        public  void writexml(String path){

       // public ExecutionResult execute(AndroidTestHelper helper) throws FailureException {
            ExecutionResult executionResult;

            try {
                DocumentBuilderFactory dbFactory =
                        DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                 doc = dBuilder.newDocument();




                    // root element
                Element rootElement = doc.createElement("optic");
                doc.appendChild(rootElement);

                // root element
                Element optometry = doc.createElement("optometry");
                rootElement.appendChild(optometry);

                // carname element
                Element company = doc.createElement("compagny");
                company.appendChild(doc.createTextNode(Company));
                optometry.appendChild(company);

                Element carname = doc.createElement("model_name");
                carname.appendChild(doc.createTextNode("VX160"));
                optometry.appendChild(carname);

                Element machine = doc.createElement("machine_no");
                machine.appendChild(doc.createTextNode("01"));
                optometry.appendChild(machine);

                Element version = doc.createElement("version");
                version.appendChild(doc.createTextNode("1.402b"));
                optometry.appendChild(version);

                Element date = doc.createElement("date");
                date.appendChild(doc.createTextNode(Date));
                optometry.appendChild(date);

                Element time = doc.createElement("time");
                time.appendChild(doc.createTextNode(Time));
                optometry.appendChild(time);

                Element patient = doc.createElement("patient");
                optometry.appendChild(patient);
                rootElement.appendChild(optometry);

                Element iD = doc.createElement("ID");
                iD.appendChild(doc.createTextNode(ID));
                patient.appendChild(iD);

                Element TR = doc.createElement("tr");
                TR.appendChild(doc.createTextNode(Tr));
                patient.appendChild(TR);


                Element Firstname = doc.createElement("first_name");
                Firstname.appendChild(doc.createTextNode(FirstName));
                patient.appendChild(Firstname);

                Element middlename = doc.createElement("middle_name");
                middlename.appendChild(doc.createTextNode(MiddleName));
                patient.appendChild(middlename);

                Element lastname = doc.createElement("last_name");
                lastname.appendChild(doc.createTextNode(LastName));
                patient.appendChild(lastname);

                Element gender = doc.createElement("gender");
                gender.appendChild(doc.createTextNode(Gender));
                patient.appendChild(gender);

                Element birthday = doc.createElement("birthday");
                birthday.appendChild(doc.createTextNode(Birthday));
                patient.appendChild(birthday);

                Element Adress = doc.createElement("address");
                //Adress.appendChild(doc.createTextNode("cxc"));
                patient.appendChild(Adress);

                Element Street = doc.createElement("street");
                //Street.appendChild(doc.createTextNode("cxc"));
                Adress.appendChild(Street);

                Element Street2 = doc.createElement("street2");
                //Street2.appendChild(doc.createTextNode("cxc"));
                Adress.appendChild(Street2);

                Element City = doc.createElement("city");
                //ID.appendChild(doc.createTextNode("cxc"));
                Adress.appendChild(City);

                Element Contact = doc.createElement("contact");
                //ID.appendChild(doc.createTextNode("cxc"));
                patient.appendChild(Contact);

                Element Phone = doc.createElement("phone");
                //ID.appendChild(doc.createTextNode("cxc"));
                Contact.appendChild(Phone);

                Element Mobilephone = doc.createElement("mobile_phone");
                //ID.appendChild(doc.createTextNode("cxc"));
                Contact.appendChild(Mobilephone);

                 Element Fax = doc.createElement("fax");
                //ID.appendChild(doc.createTextNode("cxc"));
                Contact.appendChild(Fax);
                Element Email = doc.createElement("email");
                //ID.appendChild(doc.createTextNode("cxc"));
                Contact.appendChild(Email);


                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);

                //transformerFactory.setAttribute("indent-number", indent);
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                StreamResult result = new StreamResult(new File(path));
                transformer.transform(source, result);

                // Output to console for testing
                StreamResult consoleResult = new StreamResult(System.out);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }





