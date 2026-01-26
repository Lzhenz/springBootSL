package com.example.helloSpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.helloSpringBoot.entity.PhoneModel;

// CRUD
public interface PhoneModelRepository extends JpaRepository<PhoneModel , Long>{

}