/**
 * @author Gopikrishna Putti - Apr 14, 2017
 * Developed by Gopi for personal use.
 * 
 * This is the most fundamental object contains 
 * all contact info.
 *
 */
package com.yaams.dataobj;

import javax.persistence.*;


@Entity
@Table(name="contacts")
public class Contact {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long id;	
	public String value = null;
	public String type = ContactType.EMAIL.name();
	
	public Contact() {
		
	}
	
	public Contact(String value ) {
		this(value, ContactType.EMAIL.name());
	}
	
	public Contact(String value, String type ) {
		this.value = value;
		this.type = type;
	}
	
	public static Contact create(String val) {
		Contact c = null;
		if( val.contains("@")  || val.contains("\\.") ) {
			c = new Contact(val, ContactType.EMAIL.name());
		} else {
			c = new Contact(val, ContactType.MOBILEPHONE.name());
		}
		return c;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString( ) {
		return "id:" + id + "; type: " + type + " : " + value;
	}

}
