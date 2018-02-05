package dev.paie.web.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.Graderepository;
import dev.paie.repository.PeriodesRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Controller
@RequestMapping("/employes")
public class EditerUnNouvelleEmployeController {
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("prefixMatricule", "M00");
		return mv;

	}

	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private ProfilRemunerationRepository profilRepository;

	@Autowired
	private Graderepository graderepository;

	@Autowired
	PeriodesRepository periodesrepository;

	@Autowired
	RemunerationEmploye remEmprepository;

	@RequestMapping(method = RequestMethod.GET, path = "/editer")

	public ModelAndView editerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/BulletinCreationEmploye");

		if (entrepriseRepository != null) {

			mv.addObject("entreprise", entrepriseRepository.findAll());
		}
		if (profilRepository != null) {

			mv.addObject("profil", profilRepository.findAll());
		}

		if (graderepository != null) {
			mv.addObject("grade", graderepository.findAll());
		}

		return mv;

	}

	@PersistenceContext
	private EntityManager em;

	ModelAndView mv = new ModelAndView();

	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "/editer")
	public ModelAndView editerpEmploye(@RequestParam("Matricule") String matricule,
			@RequestParam("Entreprise") String entreprise, @RequestParam("Profil") String profil,
			@RequestParam("Grade") String grade) {

		mv.setViewName("employes/EmployeCreer");

		mv.addObject("Matricule", matricule);
		mv.addObject("Entreprise", entreprise);
		mv.addObject("Profil", profil);
		mv.addObject("Grade", grade);

		RemunerationEmploye remEmpBDD = new RemunerationEmploye();
		Entreprise entBDD = new Entreprise();
		ProfilRemuneration profRemBDD = new ProfilRemuneration();
		Grade gradeBDD = new Grade();
		Periode periode = new Periode();
		LocalDate DateEntrée = LocalDate.now();

		periode.setDateDebut(DateEntrée);
		em.persist(periode);
		remEmpBDD.setMatricule(matricule);
		em.persist(remEmpBDD);
		entBDD.setDenomination(entreprise);
		em.persist(entBDD);
		profRemBDD.setCode(profil);
		em.persist(profRemBDD);
		gradeBDD.setCode(grade);
		em.persist(gradeBDD);

		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/Lister")

	public ModelAndView listerEmployes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/ListeDesEmployes");

		if (periodesrepository != null) {
			mv.addObject("periode", periodesrepository.findAll());
		}

		if (profilRepository != null) {

			mv.addObject("profil", profilRepository.findAll());
		}

		return mv;

	}
}
