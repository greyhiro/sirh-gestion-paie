package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Grade;

public interface Graderepository extends JpaRepository<Grade, Integer> {

}
