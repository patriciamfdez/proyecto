package com.example.proyecto.service;

import com.example.proyecto.data.entity.Catalogue;
import com.example.proyecto.data.repository.CatalogueRepository;
import com.example.proyecto.data.repository.UserRepository;
import com.example.proyecto.dto.CatalogueDTO;
import com.example.proyecto.service.mapper.CatalogueMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class CatalogueService extends AbstractBusinessService<Catalogue, Integer, CatalogueDTO, CatalogueRepository, CatalogueMapper> {

    private final UserRepository userRepository;

    protected CatalogueService(CatalogueRepository repository, CatalogueMapper serviceMapper, UserRepository userRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
    }
    //Obtener el listado del catálogo
    public Page<CatalogueDTO> findAll(Pageable pageable) {
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }

    //Obtener el listado del catálogo
    public Page<CatalogueDTO> findByServiceType(String serviceType, Pageable pageable) {
        return getRepository().findByServiceType(serviceType, pageable).map(getServiceMapper()::toDto);
    }

    //Modificar un libro
    @Override
    public CatalogueDTO save(CatalogueDTO dto) {
        final Catalogue entity = getServiceMapper().toEntity(dto);
        final Catalogue savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }

    //Alta en el catálogo
    public void alta() {
        getRepository().altaCatalogo();
    }
    /*  DUDAS: seguro que es un void y no devuelkve nada? porque el save tiene eso del toentity y todto

    Desde luego un void me facilita la otra duda, si no es un void, entonces que es, un CatalogueDTO o un Page<..>?

     */
}
