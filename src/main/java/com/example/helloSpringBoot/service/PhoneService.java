package com.example.helloSpringBoot.service;

import java.nio.file.OpenOption;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.helloSpringBoot.DTO.PhoneDTO;
import com.example.helloSpringBoot.Repository.PhoneModelRepository;
import com.example.helloSpringBoot.entity.PhoneModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneModelRepository repository;

    public void create(PhoneDTO phoneDTO){
        PhoneModel entity = new PhoneModel();
        entity.setModel("xiaomi");
        entity.setPhonename(phoneDTO.getPhoneName());;
        entity.setPrice(phoneDTO.getPrice());
        entity.setCreatedat(LocalDateTime.now());

        // repository.save(entity);
        PhoneModel saved = repository.saveAndFlush(entity);
        System.out.println("saved id = " + saved.getId());
        System.out.println("count = " + repository.count());
    }

    public PhoneDTO searchOneDataByName(Long phoneId){
        PhoneModel entity = new PhoneModel();

        // entity.setId(null);
        // entity.setModel("xiaomi");
        // entity.setPhonename(phoneDTO.getPhoneName());;
        // entity.setPrice(phoneDTO.getPrice());
        // entity.setCreatedat(LocalDateTime.now());
        return null;
    }

}
