package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinDeSalaireRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.Graderepository;
import dev.paie.repository.PeriodesRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationService;

@Controller
@RequestMapping("/employes")
public class EmployeController {
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
	RemunerationEmployeRepository remEmpRepository;

	@Autowired
	BulletinDeSalaireRepository bulletinSalaireRepository;
	@Autowired
	private CalculerRemunerationService remunerationService;

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
			@RequestParam("Entreprise") Integer entreprise, @RequestParam("Profil") Integer profil,
			@RequestParam("Grade") Integer grade) {

		mv.setViewName("employes/EmployeCreer");

		mv.addObject("Matricule", matricule);
		mv.addObject("Entreprise", entreprise);
		mv.addObject("Profil", profil);
		mv.addObject("Grade", grade);

		RemunerationEmploye remEmpBDD = new RemunerationEmploye();
		remEmpBDD.setMatricule(matricule);
		Grade gradeBDD = new Grade();
		gradeBDD.setId(grade);
		remEmpBDD.setGrade(gradeBDD);
		Entreprise ent = new Entreprise();
		ent.setId(entreprise);
		remEmpBDD.setEntreprise(ent);
		ProfilRemuneration profilRem = new ProfilRemuneration();
		profilRem.setId(profil);
		remEmpBDD.setProfilRemuneration(profilRem);
		LocalDateTime date = LocalDateTime.now();

		remEmpBDD.setDate(date);

		em.persist(remEmpBDD);

		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/Lister")

	public ModelAndView listerEmployes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/ListeDesEmployes");

		mv.addObject("formater", new FormaterDate());
		if (remEmpRepository != null) {

			mv.addObject("remEmploye", remEmpRepository.findAll());
		}
		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/editerBulletinDeSalaire")
	public ModelAndView editerBulletinDeSalaire() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/CreerBulletinDeSalaire");

		mv.addObject("formater", new FormaterDate());
		if (periodesrepository != null) {
			mv.addObject("periodes", periodesrepository.findAll());

			if (remEmpRepository != null) {
				mv.addObject("employe", remEmpRepository.findAll());
			}

		}
		return mv;
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "/editerBulletinDeSalaire")
	public ModelAndView editerBulletinDeSalaire(@RequestParam("Matricule") Integer matricule,
			@RequestParam("Periodes") Integer periode, @RequestParam("Prime") BigDecimal prime) {

		BulletinSalaire bulletinBDD = new BulletinSalaire();
		bulletinBDD.setPrimeExceptionnelle(prime);
		RemunerationEmploye remEmp = new RemunerationEmploye();
		remEmp.setId(matricule);
		bulletinBDD.setRemunerationEmploye(remEmp);
		Periode periode2 = new Periode();
		periode2.setId(periode);
		bulletinBDD.setPeriode(periode2);
		em.persist(bulletinBDD);

		mv.addObject("matricule", matricule);
		mv.setViewName("employes/BulletinCreer");
		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/listerBulletinDeSalaire")
	@Transactional
	public ModelAndView ListerBulletinDeSalaire() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/ListerBulletin");

		mv.addObject("bulletin", bulletinSalaireRepository.findAll());
		mv.addObject("formater", new FormaterDate());

		Map<BulletinSalaire, ResultatCalculRemuneration> map = new HashMap<>();

		bulletinSalaireRepository.findAll().forEach(bulletin -> {
			map.put(bulletin, remunerationService.calculer(bulletin));
		});

		mv.addObject("bulletinResultat", map);

		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/BulletinDeSalaire")
	@Transactional
	public ModelAndView BulletinDeSalaire() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/visualiserBulletin");

		return mv;

	}
}
