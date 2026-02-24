package com.example.helloSpringBoot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.helloSpringBoot.Repository.PhoneModelRepository;
import com.example.helloSpringBoot.entity.PhoneModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PhoneModelService {
    private final PhoneModelRepository phoneModelRepository;

    public List<PhoneModel> findByPhoneName(String phoneName){
        return phoneModelRepository.findByPhonename(phoneName);
    }

    public Page<PhoneModel> findByModel(String model , Pageable pageable){
        return phoneModelRepository.findByModel(model, pageable);
    }

    public Page<PhoneModel> findByBrandAndPriceBetween(String model, Double minPrice, Double maxPrice, Pageable pageable){
        return phoneModelRepository.findByModelAndPriceBetween(model, minPrice, maxPrice, pageable);
    }
}
