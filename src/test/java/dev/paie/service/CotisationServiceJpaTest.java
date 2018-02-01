package dev.paie.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;


//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = {ServicesConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
//test
@RunWith(SpringRunner.class)
//TODO compléter la configuration
public class CotisationServiceJpaTest {
	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {


		Cotisation cotisation = new Cotisation("M01", "changement", new BigDecimal("2"), new BigDecimal("0.58"));
		
		cotisationService.sauvegarder(cotisation);
		Cotisation cotisation2 = new Cotisation("M02", "changement", new BigDecimal("5"), new BigDecimal("0.2"));
		cotisationService.mettreAJour(cotisation2);
		
		cotisationService.lister();
		
		

	}
}