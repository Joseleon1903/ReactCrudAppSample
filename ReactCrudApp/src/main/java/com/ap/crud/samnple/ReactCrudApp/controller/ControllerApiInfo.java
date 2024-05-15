package com.ap.crud.samnple.ReactCrudApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api/info")
@CrossOrigin("http://localhost:3000/")
public class ControllerApiInfo {

    Logger logger = Logger.getLogger(ControllerApiInfo.class.getName());

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> getAppVersion(){
        logger.info("entering in getAppVersion");
        return new ResponseEntity<>("{ version : \"0.0.1\"}", HttpStatus.OK);
    }

}
