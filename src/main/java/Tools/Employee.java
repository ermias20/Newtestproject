package Tools;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

    @XmlRootElement(name = "employee")
    @XmlAccessorType(XmlAccessType.PROPERTY)
    public class Employee implements Serializable {

        private static final long serialVersionUID = 1L;

        private Integer id;
        private String firstName;
        private String lastName;
        //private Department department;

        public Employee() {
            super();
        }

        public Employee(int id, String fName, String lName) {
            super();
            this.id = id;
            this.firstName = fName;
            this.lastName = lName;
            //this.department = department;
        }

        //Setters and Getters

        @Override
        public String toString() {
            return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
        }
    }












