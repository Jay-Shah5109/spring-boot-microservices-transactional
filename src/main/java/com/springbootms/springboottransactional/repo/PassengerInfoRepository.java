package com.springbootms.springboottransactional.repo;

import com.springbootms.springboottransactional.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {


}
