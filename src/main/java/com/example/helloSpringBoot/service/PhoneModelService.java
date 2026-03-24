package com.example.helloSpringBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.helloSpringBoot.DTO.PhoneResponseDTO;
import com.example.helloSpringBoot.Repository.PhoneModelRepository;
import com.example.helloSpringBoot.entity.PhoneModel;
import com.example.helloSpringBoot.exception.BusinessException;

import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PhoneModelService {
    private final PhoneModelRepository phoneModelRepository;

    public List<PhoneResponseDTO> findByPhoneName(String phoneName){
        List<PhoneModel> phoneModels = phoneModelRepository.findByPhonename(phoneName);

        return phoneModels.stream().map(phone -> {
            PhoneResponseDTO dto = new PhoneResponseDTO();
            dto.setModel(phone.getModel());
            dto.setPhoneName(phone.getPhonename());
            dto.setPrice(phone.getPrice());
            dto.setStock(phone.getStock());
            return dto;
        }).toList();
    }

    public Page<PhoneResponseDTO> findByModel(String model , Pageable pageable){
        Page<PhoneModel> phoneModels = phoneModelRepository.findByModel(model, pageable);

        // if (phoneModels != null) {
        //     throw new BusinessException("该品牌的手机不存在");
        // }
        return phoneModels.map(
            phone -> {
            PhoneResponseDTO dto = new PhoneResponseDTO();
            dto.setModel(phone.getModel());
            dto.setPhoneName(phone.getPhonename());
            dto.setPrice(phone.getPrice());
            dto.setStock(phone.getStock());
            return dto;
        });
    }

    public Page<PhoneResponseDTO> findByBrandAndPriceBetween(String model, Double minPrice, Double maxPrice, Pageable pageable){
        Page<PhoneModel> phoneModels =  phoneModelRepository.findByModelAndPriceBetween(model, minPrice, maxPrice, pageable);
        return phoneModels.map(
            phone -> {
            PhoneResponseDTO dto = new PhoneResponseDTO();
            dto.setModel(phone.getModel());
            dto.setPhoneName(phone.getPhonename());
            dto.setPrice(phone.getPrice());
            dto.setStock(phone.getStock());
            return dto;
        });
    }

    public Page<PhoneResponseDTO> search(String model , Double minPrice , Double maxPrice , Pageable pageable){
        Specification<PhoneModel> spec = (root , query , cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(model != null && !model.isEmpty()){
                predicates.add(cb.equal(root.get("model"), model));
            }

            if (minPrice != null) {
                predicates.add(cb.equal(root.get("price"), minPrice));
            }

            if (maxPrice != null) {
                predicates.add(cb.equal(root.get("price"), maxPrice));
            }
            
            return cb.and(predicates.toArray(new Predicate[0]));
        };

        Page<PhoneModel> page = phoneModelRepository.findAll(spec , pageable);

        return page.map(this::convertToDto);
    }

    private PhoneResponseDTO convertToDto(PhoneModel phone) {
        PhoneResponseDTO dto = new PhoneResponseDTO();
        dto.setPhoneName(phone.getPhonename());
        dto.setModel(phone.getModel());
        dto.setPrice(phone.getPrice());
        dto.setStock(phone.getStock());
        return dto;
    }

}
