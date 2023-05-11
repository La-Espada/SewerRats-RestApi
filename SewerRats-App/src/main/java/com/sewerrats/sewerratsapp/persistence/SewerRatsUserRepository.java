package com.sewerrats.sewerratsapp.persistence;

import com.sewerrats.sewerratsapp.domain.SewerRatsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SewerRatsUserRepository extends JpaRepository<SewerRatsUser,Long> {

    SewerRatsUser findByDiscordUsername(String username);

}
