package net.cygnethollowfarm.carldemo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import net.cygnethollowfarm.carldemo.dto.Name;

@Entity
@Table(name = "name")
public class NameEntity {

   @Id
   @Column(name = "contact_id")    
   private Long contactId;
   
   @OneToOne
   @MapsId
   @JoinColumn(name = "contact_id")
   private ContactEntity contact;
   
   @Column(name = "first")
   private String first;
   
   @Column(name = "middle")
   private String middle;
   
   @Column(name = "last")
   private String last;

   public Long getContactId() {
      return contactId;
   }

   public void setContactId(Long contactId) {
      this.contactId = contactId;
   }

   public ContactEntity getContact() {
      return contact;
   }

   public void setContact(ContactEntity contact) {
      this.contact = contact;
   }

   public String getFirst() {
      return first;
   }

   public void setFirst(String first) {
      this.first = first;
   }

   public String getMiddle() {
      return middle;
   }

   public void setMiddle(String middle) {
      this.middle = middle;
   }

   public String getLast() {
      return last;
   }

   public void setLast(String last) {
      this.last = last;
   }

   public Name asName() {
      Name name = new Name();
      name.setFirst(first);
      name.setMiddle(middle);
      name.setLast(last);
      
      return name;
   }

   static NameEntity fromName(Name name) {
      return null;
   }

   @Override
   public String toString() {
      return "NameEntity{" + "contactId=" + contactId + ", first=" + first + ", middle=" + middle + ", last=" + last + '}';
   }
}
