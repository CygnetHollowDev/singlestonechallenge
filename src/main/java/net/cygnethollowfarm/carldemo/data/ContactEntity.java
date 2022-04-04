package net.cygnethollowfarm.carldemo.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import net.cygnethollowfarm.carldemo.dto.Contact;
import net.cygnethollowfarm.carldemo.dto.Phone;

@Entity
@Table(name = "contact")
public class ContactEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
   @PrimaryKeyJoinColumn
   private NameEntity name;

   @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
   @PrimaryKeyJoinColumn
   private AddressEntity address;

   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   @JoinColumn(name = "contact_id")
   private List<PhoneEntity> phone = null;

   @Column(name = "email")
   private String email;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public NameEntity getName() {
      return name;
   }

   public void setName(NameEntity name) {
      this.name = name;
   }

   public AddressEntity getAddress() {
      return address;
   }

   public void setAddress(AddressEntity address) {
      this.address = address;
   }

   public List<PhoneEntity> getPhone() {
      return phone;
   }

   public void setPhone(List<PhoneEntity> phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Contact asContact() {
      Contact contact = new Contact();
      contact.setId(id);
      contact.setEmail(email);
      contact.setName(name.asName());
      contact.setAddress(address.asAddress());
      ArrayList<Phone> phoneList = new ArrayList();
      if (phone != null) {
         phone.forEach((p) -> {
            phoneList.add(p.asPhone());
         });
      }
      contact.setPhone(phoneList);

      return contact;
   }

   public static ContactEntity fromContact(Contact contact) {
      ContactEntity contactEntity = new ContactEntity();
      contactEntity.setName(NameEntity.fromName(contact.getName()));

      return contactEntity;
   }

   @Override
   public String toString() {
      return "ContactEntity{" + "id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + '}';
   }
}
