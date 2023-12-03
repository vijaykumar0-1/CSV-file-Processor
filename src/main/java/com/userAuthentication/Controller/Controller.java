package com.userAuthentication.Controller;

import com.userAuthentication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    UserService userService;
    @GetMapping(path = "/data")
    public ResponseEntity<String> getData(@RequestParam String filePath){
        String response = userService.getResult(filePath);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
