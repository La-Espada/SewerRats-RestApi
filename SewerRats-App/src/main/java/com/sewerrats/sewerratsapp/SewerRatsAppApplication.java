package com.sewerrats.sewerratsapp;

import com.sewerrats.sewerratsapp.domain.SewerRatsUser;
import com.sewerrats.sewerratsapp.persistence.SewerRatsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SewerRatsAppApplication {

    @Autowired
    SewerRatsUserRepository sewerRatsUserRepository;


    public static void main(String[] args) {



        SpringApplication.run(SewerRatsAppApplication.class, args);
    }



}
