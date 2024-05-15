package com.ap.crud.samnple.ReactCrudApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

     @Id
     private String id;
     private String username;
     private String email;
     private String uid;

     @OneToMany
     private List<Address> address;
     private String userType;
     private String profileUrl;
     private LocalDate updatedAt;

     @Override
     public String toString() {
          return "Profile{" +
                  "id='" + id + '\'' +
                  ", username='" + username + '\'' +
                  ", email='" + email + '\'' +
                  ", uid='" + uid + '\'' +
                  ", address=" + address +
                  ", userType='" + userType + '\'' +
                  ", profileUrl='" + profileUrl + '\'' +
                  ", updatedAt=" + updatedAt +
                  '}';
     }
}
