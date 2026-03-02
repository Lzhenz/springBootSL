package com.example.helloSpringBoot.Repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
>>>>>>> 038a7af (统一返回接口)

import com.example.helloSpringBoot.entity.PhoneModel;

// CRUD
<<<<<<< HEAD
public interface PhoneModelRepository extends JpaRepository<PhoneModel , Long>{
=======
public interface PhoneModelRepository extends JpaRepository<PhoneModel , Long> , JpaSpecificationExecutor<PhoneModel>{
>>>>>>> 038a7af (统一返回接口)

    List<PhoneModel> findByPhonename(String phoneName);

    Page<PhoneModel> findByModel(String model , Pageable pageable);

    Page<PhoneModel> findByModelAndPriceBetween(String model, Double minPrice, Double maxPrice, Pageable pageable);

}