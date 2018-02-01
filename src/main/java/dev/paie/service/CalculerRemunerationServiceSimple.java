package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;

import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Configuration
@ImportResource("classpath:jdd-config.xml")

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		BigDecimal nbHbase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase();
		BigDecimal tauxDeBase = bulletin.getRemunerationEmploye().getGrade().getTauxBase();

		BigDecimal salaireBase = nbHbase.multiply(tauxDeBase);

		BigDecimal salaireBrut = bulletin.getPrimeExceptionnelle().add(salaireBase);

		BigDecimal totRetSalarial = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(c -> c.getTauxSalarial() != null)
				.map(c -> c.getTauxSalarial()).map(taux -> taux.multiply(salaireBrut))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		BigDecimal totRetPatronal = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables().stream().filter(c -> c.getTauxPatronal() != null)
				.map(c -> c.getTauxPatronal()).map(taux -> taux.multiply(salaireBrut))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		// NET_IMPOSABLE = SALAIRE_BRUT - TOTAL_RETENUE_SALARIALE

		BigDecimal netImposable = salaireBrut.subtract(totRetSalarial);

		// NET_A_PAYER = NET_IMPOSABLE -
		// SOMME(COTISATION_IMPOSABLE.TAUX_SALARIAL*SALAIRE_BRUT)
		BigDecimal netApayer = netImposable
				.subtract(bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().stream()
						.filter(c -> c.getTauxSalarial() != null).map(c -> c.getTauxSalarial())
						.map(taux -> taux.multiply(salaireBrut)).reduce(BigDecimal.ZERO, BigDecimal::add));

		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();
		resultat.setNetAPayer(paieUtils.formaterBigDecimal(netApayer));
		resultat.setNetImposable(paieUtils.formaterBigDecimal(netImposable));
		resultat.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));
		resultat.setSalaireDeBase(paieUtils.formaterBigDecimal(salaireBase));
		resultat.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(totRetPatronal));
		resultat.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(totRetSalarial));

		return resultat;

	}

}
