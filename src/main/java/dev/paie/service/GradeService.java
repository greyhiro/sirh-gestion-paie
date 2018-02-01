package dev.paie.service;

import java.util.List;


import dev.paie.entite.Grade;

public interface GradeService {
	int sauvegarder(Grade nouveauGrade);

	int mettreAJour(Grade grade);

	List<Grade> lister();
	

}