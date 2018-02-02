package dev.paie.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.repository.AvantageRepository;


@ContextConfiguration(classes = {ServicesConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
//test
@RunWith(SpringRunner.class)
//TODO compléter la configuration
public class AvantageRepositoryTest {
	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
		Avantage avantage = new Avantage( "M06", "lallila", new BigDecimal("2.6"));
		avantageRepository.save(avantage);
		avantageRepository.findOne(avantage.getId());
		
		Avantage avantageAchanger = new Avantage( "M06", "changé", new BigDecimal("2.6"));
		
		for(int i =0 ; i< avantageRepository.count(); i++)
		{
			if(avantage.getCode().equals("M06"))
			{
				System.out.println(avantage.getCode());
				System.out.println("boucle");
				avantageRepository.delete(avantage);
				avantageRepository.save(avantageAchanger);
				
			}
		}
		
		
		System.out.println(avantageRepository.count());
	
		
		// TODO sauvegarder un nouvel avantage
		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via
		// la méthode findOne
		// TODO modifier un avantage
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode findOne
	}
}