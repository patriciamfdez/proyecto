package com.example.proyecto.service;

import com.example.proyecto.data.entity.Dog;
import com.example.proyecto.data.repository.DogRepository;
import com.example.proyecto.data.repository.UserRepository;
import com.example.proyecto.dto.DogDTO;
import com.example.proyecto.service.mapper.DogMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class DogService extends AbstractBusinessService<Dog, Integer, DogDTO, DogRepository, DogMapper> {

    private final UserRepository userRepository;

    protected DogService(DogRepository repository, DogMapper serviceMapper, UserRepository userRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
    }
    //Obtener el listado de perros
    public Page<DogDTO> findAll(Pageable pageable) {
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }

    //Modificar un perro
    @Override
    public DogDTO save(DogDTO dto) {
        final Dog entity = getServiceMapper().toEntity(dto);
        final Dog savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }
}
