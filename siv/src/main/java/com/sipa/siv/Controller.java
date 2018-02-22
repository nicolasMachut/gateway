package com.sipa.siv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private TypeIdentification typeIdentification;

    @GetMapping("/test")
    public void test () {
        InfoImmat infoImmat = new InfoImmat();
        InfoImmatReq infoImmatReq = new InfoImmatReq();
        infoImmatReq.setIdentification(typeIdentification);
        System.out.println("coucou");
    }
}
