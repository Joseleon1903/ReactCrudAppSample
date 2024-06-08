package com.ap.crud.samnple.ReactCrudApp.dto;

import com.ap.crud.samnple.ReactCrudApp.domain.Wallet;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletDto {

    private Long id;
    private String uuid;
    private String currency;
    private String accountName;
    private String accountNumber;
    private BigDecimal balance;

    public WalletDto(Wallet entity) {
        this.id = entity.getId();
        this.uuid = entity.getUuid();
        this.currency = entity.getCurrency();
        this.accountName = entity.getAccountName();
        this.accountNumber = entity.getAccountNumber();
        this.balance = entity.getBalance();
    }

    public WalletDto() {
      super();
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", currency='" + currency + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
