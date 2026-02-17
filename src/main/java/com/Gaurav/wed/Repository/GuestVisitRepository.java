package com.Gaurav.wed.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gaurav.wed.Service.GuestService;
import com.Gaurav.wed.entity.GuestVisit;

public interface GuestVisitRepository extends JpaRepository<GuestVisit, Long> {

}
