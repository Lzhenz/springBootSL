package com.example.helloSpringBoot.Repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.helloSpringBoot.entity.PhoneModel;

// CRUD
public interface PhoneModelRepository extends JpaRepository<PhoneModel , Long> , JpaSpecificationExecutor<PhoneModel>{

    List<PhoneModel> findByPhonename(String phoneName);

    Page<PhoneModel> findByModel(String model , Pageable pageable);

    Page<PhoneModel> findByModelAndPriceBetween(String model, Double minPrice, Double maxPrice, Pageable pageable);

}