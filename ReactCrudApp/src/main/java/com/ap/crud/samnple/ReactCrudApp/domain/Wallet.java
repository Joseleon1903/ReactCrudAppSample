package com.ap.crud.samnple.ReactCrudApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Wallet {

    @Id
    @GeneratedValue
    private Long id;
    private String uuid;
    private String currency;
    private String accountName;
    private String accountNumber;
    private BigDecimal balance;
    @OneToOne
    private Profile profile;

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", currency='" + currency + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
