package com.fierastudio.linktracker.repository;

import com.fierastudio.linktracker.entity.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends CrudRepository<Link, Integer> {}
