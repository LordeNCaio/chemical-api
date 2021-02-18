package com.chemicalgears.chemicalapi.repository;

import com.chemicalgears.chemicalapi.entity.SystemInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemInformationRepository extends JpaRepository<SystemInformation, Long> {

}
