package com.sipa.rest;

import com.sipa.UserServiceException;
import com.sipa.domain.EntityValue;
import com.sipa.service.EntityService;
import com.sipa.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/entity")
public class EntityResource {

    private final UserService userService;
    private final EntityService entityService;

    public EntityResource(UserService userService, EntityService entityService) {
        this.userService = userService;
        this.entityService = entityService;
    }

    @PostMapping()
    public ResponseEntity<EntityValue> createEntity (@RequestBody @Valid EntityValue entity) throws UserServiceException {
        entity.setParentId(1L);
        EntityValue createdEntity = entityService.createEntity(entity);

        // TODO : call services to setup new entity (doc david ?)

        userService.createDefaultAdminUser(createdEntity);
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }

}
