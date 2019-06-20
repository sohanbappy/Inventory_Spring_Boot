package com.inventory.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.models.Organization;






@Repository
public interface OrganizationDao extends JpaRepository<Organization, Integer>{

}
