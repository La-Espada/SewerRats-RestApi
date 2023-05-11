package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.ItemInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemInventoryRepository extends JpaRepository<ItemInventory,Long>{
}
