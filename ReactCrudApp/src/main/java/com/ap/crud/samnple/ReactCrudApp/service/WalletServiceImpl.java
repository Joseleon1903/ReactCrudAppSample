package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Wallet;
import com.ap.crud.samnple.ReactCrudApp.dto.WalletDto;
import com.ap.crud.samnple.ReactCrudApp.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class WalletServiceImpl implements WalletService{

    Logger logger = Logger.getLogger(WalletService.class.getName());

    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    @Override
    public List<WalletDto> findAll() {
        List<WalletDto> listOut = new ArrayList<>();
        List<Wallet> entityList = walletRepository.findAll();
        entityList.forEach( enty ->{
            WalletDto dto = new WalletDto(enty);
            listOut.add(dto);
        });
        return listOut;
    }

    @Override
    public WalletDto findByProfileId(String id) {
        logger.info("entring findByProfileId");
        logger.info("param id :"+ id);
        Wallet entity =  walletRepository.findByProfileId(id);
        return new WalletDto(entity);
    }

    @Override
    public WalletDto updateWallet(WalletDto wallet) {
        logger.info("entring updateWallet");
        logger.info("param wallet :"+ wallet);
        Wallet walletEntity = walletRepository.findById(wallet.getId()).get();
        walletEntity.setBalance(wallet.getBalance());
        walletEntity.setCurrency(wallet.getCurrency());
        return wallet;
    }
}
