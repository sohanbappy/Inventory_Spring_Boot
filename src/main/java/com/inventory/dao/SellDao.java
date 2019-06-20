package com.inventory.dao;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.inventory.models.Sell;




@Repository
public interface  SellDao extends JpaRepository<Sell, Integer>{

}
