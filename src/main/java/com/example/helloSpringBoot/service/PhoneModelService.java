package com.example.helloSpringBoot.service;

import java.util.List;

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
}
