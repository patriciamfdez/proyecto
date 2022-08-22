package com.example.proyecto.service;

import com.example.proyecto.data.entity.Daycare;
import com.example.proyecto.data.repository.DaycareRepository;
import com.example.proyecto.data.repository.UserRepository;
import com.example.proyecto.dto.DaycareDTO;
import com.example.proyecto.service.mapper.DaycareMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class DaycareService extends AbstractBusinessService<Daycare, Integer, DaycareDTO, DaycareRepository, DaycareMapper> {

    private final UserRepository userRepository;

    protected DaycareService(DaycareRepository repository, DaycareMapper serviceMapper, UserRepository userRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
    }
    //Obtener el listado de residencias caninas
    public Page<DaycareDTO> findAll(Pageable pageable) {
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }

    //Modificar una residencia canina
    @Override
    public DaycareDTO save(DaycareDTO dto) {
        final Daycare entity = getServiceMapper().toEntity(dto);
        final Daycare savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }
}
