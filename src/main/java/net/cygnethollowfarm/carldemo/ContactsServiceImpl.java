package net.cygnethollowfarm.carldemo;

import net.cygnethollowfarm.carldemo.data.ContactEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.cygnethollowfarm.carldemo.data.AddressEntity;
import net.cygnethollowfarm.carldemo.data.NameEntity;
import net.cygnethollowfarm.carldemo.data.PhoneEntity;
import net.cygnethollowfarm.carldemo.dto.CallListEntry;
import net.cygnethollowfarm.carldemo.dto.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Implementation for the ContactsService interface. This implementation is 
 * currently only used by the ContactsController, but could be used by other
 * controllers or services as needed.
 * 
 * @author carl@cygnethollowfarm.net
 */
@Service
public class ContactsServiceImpl implements ContactsService {

   private static final Logger log = LoggerFactory.getLogger(ContactsServiceImpl.class);
   
   @Autowired
   private ContactsRepository contactsRepository;
   
   @Autowired 
   private PhoneRepository phoneRepository;
   
   @Override
   public List<Contact> getAllContacts() {
      List<ContactEntity> contactList = contactsRepository.findAll();
      List<Contact> contacts = new ArrayList();
      contactList.forEach((c) -> {
         contacts.add(c.asContact());         
      });
      
      return contacts;
   }
   
   @Override
   public Contact getContact(Long contactId) {
      ContactEntity contact = contactsRepository.getById(contactId);
      return contact.asContact();
   }
   
   @Override
   public void deleteContact(Long contactId) {
      contactsRepository.deleteById(contactId);
   }
   
   @Override
   public Contact createContact(Contact pContact) {
      ContactEntity contact = new ContactEntity();
      
      contact.setEmail(pContact.getEmail());
      
      NameEntity name = new NameEntity();
      name.setContact(contact);
      name.setFirst(pContact.getName().getFirst());
      name.setMiddle(pContact.getName().getMiddle());
      name.setLast(pContact.getName().getLast());
      contact.setName(name);
      
      AddressEntity address = new AddressEntity();
      address.setContact(contact);
      address.setCity(pContact.getAddress().getCity());
      address.setState(pContact.getAddress().getState());
      address.setStreet(pContact.getAddress().getStreet());
      address.setZip(pContact.getAddress().getZip());
      contact.setAddress(address);
      
      ArrayList<PhoneEntity> phoneList = new ArrayList();
      pContact.getPhone().forEach((p) -> {
         PhoneEntity phone = new PhoneEntity();
         phone.setNumber(p.getNumber());
         phone.setType(p.getType());
         phoneList.add(phone);
      });
      contact.setPhone(phoneList);
      
      return contactsRepository.save(contact).asContact();
   }
   
   @Override
   public Contact updateContact(Long contactId, Contact pContact) {
      ContactEntity contactToUpdate = contactsRepository.getById(contactId);
      if(contactToUpdate != null) {      
         contactToUpdate.setEmail(pContact.getEmail());

         NameEntity name = contactToUpdate.getName();
         name.setContact(contactToUpdate);
         name.setFirst(pContact.getName().getFirst());
         name.setMiddle(pContact.getName().getMiddle());
         name.setLast(pContact.getName().getLast());
         contactToUpdate.setName(name);

         AddressEntity address = contactToUpdate.getAddress();
         address.setContact(contactToUpdate);
         address.setCity(pContact.getAddress().getCity());
         address.setState(pContact.getAddress().getState());
         address.setStreet(pContact.getAddress().getStreet());
         address.setZip(pContact.getAddress().getZip());
         contactToUpdate.setAddress(address);

         //This could be better; it shouldn't replace unchanged phone entries
         List<PhoneEntity> phoneList = contactToUpdate.getPhone();
         phoneList.clear();
         pContact.getPhone().forEach((p) -> {
            PhoneEntity phone = new PhoneEntity();
            phone.setNumber(p.getNumber());
            phone.setType(p.getType());
            phoneList.add(phone);
         });
         contactToUpdate.setPhone(phoneList);

         return contactsRepository.save(contactToUpdate).asContact();
      }
      
      return null;
   }
   
   @Override
   public List<CallListEntry> getCallList() {
      List<CallListEntry> callList = new ArrayList();
      Collection<PhoneEntity> homePhones = phoneRepository.findAllHomePhones();
      homePhones.forEach((p) -> {
         ContactEntity contact = contactsRepository.getById(p.getContactId());
         CallListEntry entry = new CallListEntry();
         entry.setName(contact.getName().asName());
         entry.setPhone(p.getNumber());
         callList.add(entry);
      });
      
      return callList;
   }
}
