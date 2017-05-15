/**
 * @author Gopikrishna Putti - Apr 14, 2017
 * Developed by Gopi for personal use.
 *
 */
package com.yaams.dataobj;

import static com.yaams.dataobj.CONSTANTS.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class User {
	
	String fname = null;
	String mname = null;
	String lname = null; 
	List<Contact> contacts = new ArrayList<Contact>();
	
	public User(String fname, Contact contact) {
		this.fname = fname; 
		contacts.add(contact);
	}
	
	
	
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}



	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}



	/**
	 * @return the mname
	 */
	public String getMname() {
		return mname;
	}



	/**
	 * @param mname the mname to set
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}



	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}



	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}



	/**
	 * @return the contacts
	 */
	public List<Contact> getContacts() {
		return contacts;
	}



	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}



	@Override
	public String toString( ) {
		return fname + SINGLE_SPACE + lname + contacts.get(0).toString();
	}
	
	

}
