package com.example.proyecto.service;

import com.example.proyecto.data.entity.DogWalker;
import com.example.proyecto.data.repository.DogWalkerRepository;
import com.example.proyecto.data.repository.UserRepository;
import com.example.proyecto.dto.DogWalkerDTO;
import com.example.proyecto.service.mapper.DogWalkerMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DogWalkerService extends AbstractBusinessService<DogWalker, Integer, DogWalkerDTO, DogWalkerRepository, DogWalkerMapper> {

    private final UserRepository userRepository;

    protected DogWalkerService(DogWalkerRepository repository, DogWalkerMapper serviceMapper, UserRepository userRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
    }
    //Obtener el listado de paseadores
    public Page<DogWalkerDTO> findAll(Pageable pageable) {
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }

    //Modificar un paseador
    @Override
    public DogWalkerDTO save(DogWalkerDTO dto) {
        final DogWalker entity = getServiceMapper().toEntity(dto);
        final DogWalker savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }
}