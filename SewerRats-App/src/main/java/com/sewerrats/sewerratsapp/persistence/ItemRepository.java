package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}