package com.example.helloSpringBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.helloSpringBoot.entity.PhoneModel;

// CRUD
public interface PhoneModelRepository extends JpaRepository<PhoneModel , Long>{

    List<PhoneModel> findByPhonename(String phoneName);

}