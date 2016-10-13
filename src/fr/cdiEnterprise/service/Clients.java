/**
 * 
 */
package fr.cdiEnterprise.service;

import java.util.ArrayList;

import fr.cdiEnterprise.control.MpClient;

/**
 * Class is going to hold all the Users that are registered on the Messaging
 * Server.
 * 
 * @author nicolas Tarral
 * @version 13-10-2016
 */
public class Clients extends ArrayList<MpClient> {

	
	/**
	 * This method is going to provide the name of the box that may be in the box containers
	 * 
	 * @param box
	 * @return the box.
	 */
	public MpClient getClient(String box) {
		MpClient theClient = null;
		for (MpClient current : this) {
			if (current.getBox().equals(box)) {
				theClient = current;
			}
		}
		return theClient;
	}

}
