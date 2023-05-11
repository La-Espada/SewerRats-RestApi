package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityRepository extends JpaRepository<Ability,Long> {
}
