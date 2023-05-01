package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.entity.Standard;
import com.exam.entity.User;

public interface StandardRepository extends JpaRepository<Standard,Long>{
      public Standard findBystandardName(String standardName);
      
      
      @Query(value = "SELECT s FROM Standard s WHERE s.isDeleted=false")
      public List<Standard> findByIsDeleted();
      
      @Query(value="SELECT COUNT(s) FROM Standard s WHERE s.isDeleted =false")
  	  public Long countStandard(Standard standard);
}
