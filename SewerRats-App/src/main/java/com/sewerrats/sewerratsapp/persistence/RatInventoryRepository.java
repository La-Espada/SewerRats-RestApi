package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.RatInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatInventoryRepository extends JpaRepository<RatInventory,Long> {
}
