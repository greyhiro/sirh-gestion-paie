package dev.paie.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dev.paie.entite.Cotisation;

@Service

public class CotisationServiceJpa implements CotisationService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {

		em.persist(nouvelleCotisation);

	}

	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		// TODO Auto-generated method stub

		TypedQuery<Cotisation> query = em.createQuery("FROM Cotisation", Cotisation.class);
		
		for (int i = 0; i<query.getResultList().size(); i++)
		{
			
			Cotisation cot =  (Cotisation) query.getResultList().get(i);
			if (cot.getCode().equals("M01"))
			{
				
				em.remove(cot);
				em.persist(cotisation);
				return;
			}
		
		
	
		
	
		}
		
		

	
		
		
			
		
		
	}

	@Override
	public List<Cotisation> lister() {
		// TODO Auto-generated method stub
		TypedQuery<Cotisation> query = em.createQuery("FROM Cotisation", Cotisation.class);
		
		
		return query.getResultList();

	}
}