package com.chemicalgears.chemicalapi.service;

import com.chemicalgears.chemicalapi.entity.SystemInformation;
import com.chemicalgears.chemicalapi.repository.SystemInformationRepository;
import com.chemicalgears.chemicalapi.utils.SystemHelpers;
import org.springframework.boot.system.SystemProperties;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

@Service
public class SystemInformationService {

    private final SystemInformationRepository systemInformationRepository;

    SystemInformationService(SystemInformationRepository systemInformationRepository) {
        this.systemInformationRepository = systemInformationRepository;
    }

    public SystemInformation createSystemInformation() {
        SystemInformation sys = new SystemInformation();
        try {
            sys.setHostName(SystemHelpers.getHostName());
            sys.setSystemModel(SystemHelpers.getSystemModel());
            sys.setSystemArch(SystemHelpers.getSystemArch());
            sys.setSystemVersion(SystemHelpers.getSystemVersion());
            sys.setSystemMaxMemory(SystemHelpers.getSystemMaxMemory());
            sys.setApplicationMemoryUsage(SystemHelpers.getApplicationMemoryUsage());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return sys;
    }

    public SystemInformation getSystemInformation() {
        return systemInformationRepository.findById(1L).orElse(null);
    }

    public void save() {
        var newSys = createSystemInformation();
        createSystemInformation().setId(1L);
        systemInformationRepository.save(newSys);
    }
}
