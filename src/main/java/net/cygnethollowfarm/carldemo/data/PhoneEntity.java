package net.cygnethollowfarm.carldemo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import net.cygnethollowfarm.carldemo.dto.Phone;

@Entity
@Table(name = "phone")
public class PhoneEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;
   
   @Column(name = "contact_id")    
   private Long contactId;

   @Column(name = "number")
   private String number;
   
   @Column(name = "type")
   private String type;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getContactId() {
      return contactId;
   }

   public void setContactId(Long contactId) {
      this.contactId = contactId;
   }

//   public ContactEntity getContact() {
//      return contact;
//   }
//
//   public void setContact(ContactEntity contact) {
//      this.contact = contact;
//   }

   public String getNumber() {
      return number;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public Phone asPhone() {
      Phone phone = new Phone();
      phone.setNumber(number);
      phone.setType(type);
      
      return phone;
   }
}
