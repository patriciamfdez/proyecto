package com.example.proyecto.service;

import com.example.proyecto.data.entity.Address;
import com.example.proyecto.data.repository.AddressRepository;
import com.example.proyecto.data.repository.UserRepository;
import com.example.proyecto.dto.AddressDTO;
import com.example.proyecto.service.mapper.AddressMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AddressService extends AbstractBusinessService<Address, Integer, AddressDTO, AddressRepository, AddressMapper> {

    private final UserRepository userRepository;

    protected AddressService(AddressRepository repository, AddressMapper serviceMapper, UserRepository userRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
    }
    //Obtener el listado de direcciones
    public Page<AddressDTO> findAll(Pageable pageable) {
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }

    //Modificar una dirección
    @Override
    public AddressDTO save(AddressDTO dto) {
        final Address entity = getServiceMapper().toEntity(dto);
        final Address savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }
}
