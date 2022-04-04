package net.cygnethollowfarm.carldemo;

import java.util.List;
import net.cygnethollowfarm.carldemo.dto.CallListEntry;
import net.cygnethollowfarm.carldemo.dto.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * Basic REST controller for the contact management demo application
 * 
 * @author carl@cygnethollowfarm.net
 */
@RestController
public class ContactsController {
   private static final Logger log = LoggerFactory.getLogger(ContactsServiceImpl.class);

   @Autowired
   private ContactsService contactsService;
   
   @GetMapping("/contacts")
   List<Contact> getContacts() {
      try {
         return contactsService.getAllContacts();
      } catch (Exception ex) {
         log.error("Error retrieving contact list.", ex);
         throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Could not retrieve contacts from database.", ex);
      }
   }
   
   @GetMapping("/contacts/{contactId}")
   Contact getContact(@PathVariable("contactId") Long contactId) {      
      try {
         return contactsService.getContact(contactId);
      } catch (Exception ex) {
         log.error("Error retrieving contact.", ex);
         throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Could not retrieve contact from database.", ex);
      }
   }
   
   @PostMapping("/contacts")
   Contact createContact(@RequestBody Contact contact) {
      try {
         return contactsService.createContact(contact);
      } catch (Exception ex) {
         log.error("Error creating contact.", ex);
         throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Could not create contact in database.", ex);
      }
   }
   
   @DeleteMapping("/contacts/{contactId}")
   void deleteContact(@PathVariable("contactId") Long contactId) {
      try {
         contactsService.deleteContact(contactId);
      } catch (Exception ex) {
         log.error("Error deleting contact.", ex);
         throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Could not delete contact from database.", ex);
      }
   }
   
   @PutMapping("/contacts/{contactId}")
   Contact updateContact(@PathVariable("contactId") Long contactId, @RequestBody Contact contact) {
      try {
         return contactsService.updateContact(contactId, contact);
      } catch (Exception ex) {
         log.error("Error updating contact.", ex);
         throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Could not update contact in database.", ex);
      }
   }
   
   @GetMapping("/contacts/call-list") 
   List<CallListEntry> getCallList() {
      try {
         return contactsService.getCallList();
      } catch (Exception ex) {
         log.error("Error retrieving call list.", ex);
         throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Could not retrieve call list from database.", ex);
      }
   }
}
