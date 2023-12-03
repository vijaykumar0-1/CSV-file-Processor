package com.csvFileProcessor.Service;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getResult(String filePath) {
        String result = ServiceUtils.processCSVFile(filePath);
        return result;
    }
}




