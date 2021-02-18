package com.chemicalgears.chemicalapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class SystemInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hostName;
    private String systemModel;
    private String systemArch;
    private String systemVersion;
    private Long systemMaxMemory;

    private Long applicationMemoryUsage;
}
