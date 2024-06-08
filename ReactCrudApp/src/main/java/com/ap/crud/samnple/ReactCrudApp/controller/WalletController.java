package com.ap.crud.samnple.ReactCrudApp.controller;

import com.ap.crud.samnple.ReactCrudApp.dto.WalletDto;
import com.ap.crud.samnple.ReactCrudApp.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api/wallet")
@CrossOrigin("http://localhost:3000/")
public class WalletController {

    Logger logger = Logger.getLogger(CategoryController.class.getName());

    private final WalletService walletService;

    @Autowired
    public WalletController (WalletService walletService){
        this.walletService= walletService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<WalletDto>> findAll(){
        List<WalletDto> entityList = walletService.findAll();
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

    @GetMapping("/{profileId}")
    @ResponseBody
    public ResponseEntity<WalletDto> findWalletByProfile(@PathVariable("profileId") String profileId){
        WalletDto wallet = walletService.findByProfileId(profileId);
        return new ResponseEntity<>(wallet, HttpStatus.OK);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<WalletDto> updateWallet(@RequestBody WalletDto walletDto){
        WalletDto wallet = walletService.updateWallet(walletDto);
        return new ResponseEntity<>(wallet, HttpStatus.OK);
    }

}
