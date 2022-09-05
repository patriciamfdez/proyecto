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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Service
public class CatalogueService extends AbstractBusinessService<Catalogue, Integer, CatalogueDTO, CatalogueRepository, CatalogueMapper> {

    private final UserRepository userRepository;
    @PersistenceContext
    EntityManager em;
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
    public void  ActualizarCatalogo() {
        StoredProcedureQuery sp = em.createNamedStoredProcedureQuery("ActualizarCatalogo");
        sp.execute();
    }
    public void BorradoLogicoCatalogo(Integer id,String tiposervicio) {
        StoredProcedureQuery sp = em.createNamedStoredProcedureQuery("BorradoLogicoCatalogo")
                .setParameter("id_product", id).setParameter("serviceType",tiposervicio );
        sp.execute();
    }
    public void RestauradoLogicoCatalogo(Integer id,String tiposervicio) {
        StoredProcedureQuery sp = em.createNamedStoredProcedureQuery("RestauradoLogicoCatalogo")
                .setParameter("id_product", id).setParameter("serviceType",tiposervicio );
        sp.execute();
    }

}
