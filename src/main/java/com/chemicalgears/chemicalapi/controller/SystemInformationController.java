package com.chemicalgears.chemicalapi.controller;

import com.chemicalgears.chemicalapi.entity.SystemInformation;
import com.chemicalgears.chemicalapi.service.SystemInformationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemInformationController {

    private final SystemInformationService systemInformationService;

    SystemInformationController(SystemInformationService systemInformationService) {
        this.systemInformationService = systemInformationService;
    }

    @GetMapping("/info")
    public SystemInformation getSystemInformation() {
        return systemInformationService.getSystemInformation();
    }
}
