package net.cygnethollowfarm.carldemo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import net.cygnethollowfarm.carldemo.dto.Address;

@Entity
@Table(name = "address")
public class AddressEntity {
   @Id
   @Column(name = "contact_id")    
   private Long contactId;
   
   @OneToOne
   @MapsId
   @JoinColumn(name = "contact_id")
   private ContactEntity contact;
   
   @Column(name = "street")
   private String street;
   
   @Column(name = "city")
   private String city;
   
   @Column(name = "state")
   private String state;
   
   @Column(name = "zip")
   private String zip;

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

   public String getStreet() {
      return street;
   }

   public void setStreet(String street) {
      this.street = street;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getZip() {
      return zip;
   }

   public void setZip(String zip) {
      this.zip = zip;
   }

   public Address asAddress() {
      Address address = new Address();
      address.setCity(city);
      address.setState(state);
      address.setStreet(street);
      address.setZip(zip);
      
      return address;
   }

   @Override
   public String toString() {
      return "AddressEntity{" + "contactId=" + contactId + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + '}';
   }
}
