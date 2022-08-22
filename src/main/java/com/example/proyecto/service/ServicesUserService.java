package com.example.proyecto.service;

import com.example.proyecto.data.entity.ServicesUser;
import com.example.proyecto.data.repository.ServicesUserRepository;
import com.example.proyecto.data.repository.UserRepository;
import com.example.proyecto.dto.ServicesUserDTO;
import com.example.proyecto.service.mapper.ServicesUserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ServicesUserService extends AbstractBusinessService<ServicesUser, Integer, ServicesUserDTO, ServicesUserRepository, ServicesUserMapper> {

    private final UserRepository userRepository;

    protected ServicesUserService(ServicesUserRepository repository, ServicesUserMapper serviceMapper, UserRepository userRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
    }
    //Obtener el listado de servicios de usuarios
    public Page<ServicesUserDTO> findAll(Pageable pageable) {
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }

    //Modificar un servicio de usuario
    @Override
    public ServicesUserDTO save(ServicesUserDTO dto) {
        final ServicesUser entity = getServiceMapper().toEntity(dto);
        final ServicesUser savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }
}
