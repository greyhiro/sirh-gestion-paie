package dev.paie.entite;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class GradeMapper implements RowMapper<Grade> {
	// cette méthode est invoquée pour chaque ligne de résultat SQL
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grade gradeList = new Grade();
		gradeList.setId(rs.getInt("id"));
		gradeList.setCode(rs.getString("code"));
		gradeList.setNbHeuresBase(rs.getBigDecimal("nombreheure"));
		gradeList.setTauxBase(rs.getBigDecimal("tauxbase"));
		
		
		System.out.println(gradeList.getId()+ " " + gradeList.getCode()+" "+ gradeList.getNbHeuresBase()+" "+gradeList.getTauxBase());
		
		return gradeList;
	}
}
