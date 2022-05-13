package com.gerenciadordeeventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciadordeeventos.entities.CasaDeShow;

@Repository
public interface CasaDeShowRepository extends JpaRepository<CasaDeShow, Long> {

}
