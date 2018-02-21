package com.sipa.service;

import com.sipa.domain.EntityValue;
import com.sipa.repository.EntityRepository;
import org.springframework.stereotype.Service;

@Service
public class EntityService {

    private final EntityRepository entityRepository;

    public EntityService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public EntityValue createEntity(EntityValue entity) {
        return entityRepository.save(entity);
    }
}
