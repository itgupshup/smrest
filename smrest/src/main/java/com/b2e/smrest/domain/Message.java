package com.b2e.smrest.domain;

public class Message {
	 
	private Long id;
	private String name;
	private String text;
    
    public Message(){
    	
    }
 
    public Message(Long id, String name, String text) {
    	this.id = id;
        this.name = name;
        this.text = text;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
    
     
}



//With JAXB
//In case jackson-dataformat-xml.jar is not available, and you still want to get the XML response, 
//just by adding JAXB annotations on model class (Message), we can enable XML output support. 
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
// 
//@XmlRootElement(name = "player")
//public class Message {
// 
//    String name;
//    String text;
// 
//    public Message(){
//         
//    }
//     
//    public Message(String name, String text) {
//        this.name = name;
//        this.text = text;
//    }
// 
//    @XmlElement
//    public String getName() {
//        return name;
//    }
//     
//    @XmlElement
//    public String getText() {
//        return text;
//    }
// 
//}