package com.hunseong.corespringsecurity.repository;

import com.hunseong.corespringsecurity.domain.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Hunseong on 2022/06/07
 */
public interface ResourcesRepository extends JpaRepository<Resources, Long> {

    Resources findByResourceNameAndHttpMethod(String resourceName, String httpMethod);

    @Query("select r from Resources r join fetch r.roleSet " +
            "where r.resourceType = :type order by r.orderNum desc")
    List<Resources> findAllByType(@Param("type") String type);
}
