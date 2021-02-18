package com.chemicalgears.chemicalapi.components;

import com.chemicalgears.chemicalapi.service.SystemInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineStartupRunner implements CommandLineRunner {

    @Autowired
    private SystemInformationService systemInformationService;

    @Override
    public void run(String... args) throws Exception {
        systemInformationService.save();
    }
}
