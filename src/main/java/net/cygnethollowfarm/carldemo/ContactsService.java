package net.cygnethollowfarm.carldemo;

import java.util.List;
import net.cygnethollowfarm.carldemo.dto.CallListEntry;
import net.cygnethollowfarm.carldemo.dto.Contact;

/**
 *
 * @author carl@cygnethollowfarm.net
 */
public interface ContactsService {

   /**
    * Create this contact in the database.
    * 
    * @param contact
    * @return 
    */
   Contact createContact(Contact contact);

   /**
    * Retrieve a list of all contacts.
    * @return list of contacts
    */
   List<Contact> getAllContacts();

   /**
    * Retrieve a single contact by id.
    * 
    * @param contactId
    * @return the retrieved contact
    */
   Contact getContact(Long contactId);

   /**
    * Delete a contact with the given id.
    * @param contactId
    */
   void deleteContact(Long contactId);

   /**
    * Update the contact with the given id with the new data.
    * 
    * @param contactId
    * @param pContact
    * @return the updated contact
    */
   Contact updateContact(Long contactId, Contact pContact);

   /**
    * Retrieve a call list containing all contacts that have a home phone number.
    * @return the call list
    */
   List<CallListEntry> getCallList();
   
}
