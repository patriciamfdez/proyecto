package com.example.proyecto.service.mapper;

import com.example.proyecto.data.entity.Dog;
import com.example.proyecto.dto.DogDTO;
import org.springframework.stereotype.Service;

@Service
public class DogMapper extends  AbstractServiceMapper<Dog, DogDTO> {

    @Override
    public Dog toEntity(DogDTO dogDTO) {
        final Dog entity = new Dog();
        entity.setId(dogDTO.getId());
        entity.setName(dogDTO.getName());
        entity.setWeightKg(dogDTO.getWeightKg());
        entity.setAge(dogDTO.getAge());
        entity.setGender(dogDTO.getGender());
        entity.setRace(dogDTO.getRace());
        entity.setMicrochip(dogDTO.getMicrochip());
        entity.setSterilized(dogDTO.getSterilized());
        entity.setInfAdditional(dogDTO.getInfAdditional());
        entity.setCompatible(dogDTO.getCompatible());
        entity.setAllergies(dogDTO.getAllergies());
        return entity;
    }

    @Override
    public DogDTO toDto(Dog dog) {
        final DogDTO dto = new DogDTO();
        dto.setId(dog.getId());
        dto.setName(dog.getName());
        dto.setWeightKg(dog.getWeightKg());
        dto.setAge(dog.getAge());
        dto.setGender(dog.getGender());
        dto.setRace(dog.getRace());
        dto.setMicrochip(dog.getMicrochip());
        dto.setSterilized(dog.getSterilized());
        dto.setInfAdditional(dog.getInfAdditional());
        dto.setCompatible(dog.getCompatible());
        dto.setAllergies(dog.getAllergies());
        return dto;
    }
}
