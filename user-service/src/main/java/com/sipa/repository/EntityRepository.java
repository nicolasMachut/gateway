package com.sipa.repository;

import com.sipa.domain.EntityValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends CrudRepository <EntityValue, Long> {

}
