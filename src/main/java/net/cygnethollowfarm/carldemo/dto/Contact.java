package net.cygnethollowfarm.carldemo.dto;

import java.util.List;

public class Contact {
   private Long id;
   private Name name;
   private Address address;
   private List<Phone> phone = null;
   private String email;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Name getName() {
      return name;
   }

   public void setName(Name name) {
      this.name = name;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public List<Phone> getPhone() {
      return phone;
   }

   public void setPhone(List<Phone> phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

}
