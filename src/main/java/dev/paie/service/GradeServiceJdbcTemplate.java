package dev.paie.service;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.entite.GradeMapper;

@Service
public class GradeServiceJdbcTemplate implements GradeService {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}



	
	
	
	@Override
	public int sauvegarder(Grade nouveauGrade) {

		String code = "M01";
		BigDecimal nbHeuresBase = new BigDecimal("12");
		BigDecimal tauxBase = new BigDecimal("0.5");

		Grade grade = new Grade();
		grade.setCode(code);
		grade.setNbHeuresBase(nbHeuresBase);
		grade.setTauxBase(tauxBase);

		String sql = "INSERT INTO bxitw9lvy.grade (code, nombreheure,tauxbase)VALUE(?,?,?) ";
		// exécution de la requête et récupération du résultat

		return this.jdbcTemplate.update(sql, code, nbHeuresBase, tauxBase);

	}

	@Override
	public int mettreAJour(Grade grade) {
		// TODO Auto-generated method stub
		String code = "M03";
		BigDecimal nbHeuresBase = new BigDecimal("5");
		BigDecimal tauxBase = new BigDecimal("0.7");

		Grade gradeUp = new Grade();
		gradeUp.setCode(code);
		gradeUp.setNbHeuresBase(nbHeuresBase);
		gradeUp.setTauxBase(tauxBase);
		
		 String code1 = "M01";
		
		String sqlUpdate = "UPDATE bxitw9lvy.grade SET code=?, nombreheure=?, tauxbase=? WHERE code = ? ";
		return jdbcTemplate.update(sqlUpdate,code,nbHeuresBase,tauxBase, code1);
		
		


	}
	
	


	

	@Override
	public List<Grade> lister() {
		
		
		String sql = "SELECT * FROM bxitw9lvy.grade";
	

	
		
		
		return  jdbcTemplate.query(sql, new GradeMapper());
	}

}