package com.example.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class MessageSendService {

    @Value("${my.greeting}")
    private String greetingMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

//    @Value(("#{${dbValues}}"))
//    private Map<String, String> dbValues;

    @Autowired
    private DbSettings dbSettings;

    @RequestMapping("/greeting")
    public String getGreetingMessage(){
        return  greetingMessage + dbSettings.getConnection() + dbSettings.getHost();
    }
    @RequestMapping("/message")
    public String getMessage(){
        return dbSettings.getConnection() + dbSettings.getHost();
    }

}
