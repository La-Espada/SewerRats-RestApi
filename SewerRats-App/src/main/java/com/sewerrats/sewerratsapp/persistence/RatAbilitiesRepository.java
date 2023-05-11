package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.RatAbilities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatAbilitiesRepository extends JpaRepository<RatAbilities,Long> {
}
