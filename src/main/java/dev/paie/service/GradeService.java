package dev.paie.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Grade;

public interface GradeService {
	int sauvegarder(Grade nouveauGrade);

	int mettreAJour(Grade grade);

	List<Grade> lister();
	

}