/**
 * @author Gopikrishna Putti - May 28, 2017
 * Developed by Gopi for personal use.
 *
 */
package com.yaams.dataobj;

public enum ContactType {

	EMAIL,
	MOBILEPHONE,
	LANDPHONE,
	WHATSAPP,
	SKYPE,
	ADDRESS;		
	
	
	public ContactType getType(String val) {
        for(ContactType ct : ContactType.values()) {
            if(ct.name().equalsIgnoreCase(val))
                return ct;
        }
        return ContactType.EMAIL;

	}

}
