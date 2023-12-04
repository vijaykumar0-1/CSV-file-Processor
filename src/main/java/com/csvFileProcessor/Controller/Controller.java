package com.csvFileProcessor.Controller;

import com.csvFileProcessor.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    UserService userService;
    @GetMapping(path = "/data")
    public ResponseEntity<String> getData(@RequestParam("file") MultipartFile file,
                                          @RequestParam("conditionColumnName") String conditionColumnName,
                                          @RequestParam("conditionValue") String conditionValue){
        String response = userService.getResult(file,conditionColumnName,conditionValue);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
