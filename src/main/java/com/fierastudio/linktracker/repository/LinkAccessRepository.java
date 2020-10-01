package com.fierastudio.linktracker.repository;

import com.fierastudio.linktracker.dto.ReportDTO;
import com.fierastudio.linktracker.entity.Link;
import com.fierastudio.linktracker.entity.LinkAccess;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkAccessRepository extends CrudRepository<LinkAccess, Integer> {
    @Query(value = "SELECT CONCAT(YEAR(LA.access_time), MONTH(LA.access_time), DAY(LA.access_time)) AS day, COUNT(LA) AS total " +
            "FROM LinkAccess LA " +
            "WHERE LA.link = :link " +
            "GROUP BY CONCAT(YEAR(LA.access_time), MONTH(LA.access_time), DAY(LA.access_time)) ")
    public List<ReportDTO> findAllByLinkGroupByDate(@Param("link") Link link);
}
