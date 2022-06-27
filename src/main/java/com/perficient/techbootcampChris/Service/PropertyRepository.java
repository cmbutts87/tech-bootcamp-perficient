package com.perficient.techbootcampChris.Service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.perficient.techbootcampChris.Entity.PropertyEntity;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Integer>{

	// Custom query, will return all properties with rent lower than specified
	@Query("FROM property WHERE rent <= :rent")
	List<PropertyEntity> findByRent(@Param("rent") int rent);
}
