package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Adherent;

public interface IAdherentDao extends JpaRepository<Adherent, Long> {

}
