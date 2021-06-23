package com.cognizant.ptaresourcesharingservice.repository;

import com.cognizant.ptaresourcesharingservice.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
