package dev.paie.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;

@Service
public class InitialiserDonneesServiceTemplate implements InitialiserDonneesService {

	@PersistenceContext
	private EntityManager em;

	
	@Override
	@Transactional
	public void initialiser() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:entreprises.xml",
				"classpath:grades.xml", "classpath:profils-remuneration.xml")) {

			// <id, objet>
			Map<String, Entreprise> entreprs = context.getBeansOfType(Entreprise.class);
			entreprs.forEach((keyEntreprise, valueEntreprise)-> em.persist(valueEntreprise));
			entreprs.forEach((keyEntreprise, valueEntreprise)-> em.persist(valueEntreprise));
			Map<String, Grade> grade = context.getBeansOfType(Grade.class);
			grade.forEach((keyGrade, valueGrade)-> em.persist(valueGrade));
			Map<String, Cotisation> cot = context.getBeansOfType(Cotisation.class);
			cot.forEach((keyCot, valueCot)->em.persist(valueCot));
			Map<String, ProfilRemuneration> profrem = context.getBeansOfType(ProfilRemuneration.class);
			profrem.forEach((keyProfRem, valueProfRel)-> em.persist(valueProfRel));
			
			IntStream.rangeClosed(1, 12).forEach(month -> {

				Periode p = new Periode();

				LocalDate date = LocalDate.of(2017, month, 1);

				p.setDateDebut(date);

				p.setDateFin(date.with(TemporalAdjusters.lastDayOfMonth()));

				em.persist(p);

			});
			
					
					
					
			
			
			
			
			

		}

	}
}
