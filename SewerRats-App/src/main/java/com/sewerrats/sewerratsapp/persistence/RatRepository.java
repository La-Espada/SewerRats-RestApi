package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.Rat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatRepository extends JpaRepository<Rat,Long> {

    Rat findByRatName(String name);
}
