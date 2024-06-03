package com.ap.crud.samnple.ReactCrudApp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

     @Id
     private String id;
     private String username;
     private String email;
     private String password;
     private String uid;

     @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
     private Address address;
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
