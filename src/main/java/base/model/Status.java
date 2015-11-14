package base.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * If Jackson’s XML extension is not available on the classpath, JAXB (provided by default in the JDK) will be used,
 * with the additional requirement to have the annotations below uncommented (to make xml response work).
 */
//@XmlRootElement(name = "status")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Status {
//    @XmlElement
    private String code;
//    @XmlElement
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
