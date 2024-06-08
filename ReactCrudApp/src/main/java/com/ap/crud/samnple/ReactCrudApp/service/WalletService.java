package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.dto.WalletDto;

import java.util.List;

public interface WalletService {


    List<WalletDto> findAll();

    WalletDto findByProfileId(String id);

    WalletDto updateWallet(WalletDto wallet);
}
