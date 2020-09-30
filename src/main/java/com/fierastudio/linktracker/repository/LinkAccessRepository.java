package com.fierastudio.linktracker.repository;

import com.fierastudio.linktracker.entity.Link;
import com.fierastudio.linktracker.entity.LinkAccess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkAccessRepository extends CrudRepository<LinkAccess, Integer> {

}
