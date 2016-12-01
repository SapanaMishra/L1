package com.cg.daos;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.cg.dto.Emp;

@Repository("empDao")
public class EmpCrudDaoImpl implements EmpCrudDao{
	private JdbcTemplate jdbcTemplate;
	@Resource        //for self reference
	private ConfigurableApplicationContext ctx;
	
	@Resource(name="jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//get a record based on empId - MapResultSet
	
	public Emp getEmpOnId(int empId){
		String sql = "SELECT empNo,eName,sal from emp WHERE empNo=?";
		Object[] params = new Object[]{empId};
		MyRowMapper mapper = new MyRowMapper(ctx);
		Emp emp = jdbcTemplate.queryForObject(sql, params,mapper);
		return emp;
	}
	// Get a list of all emps

	@Override
	public List<Emp> getAllEmps() {
		String sql = "Select empNo,eName, sal from emp";
		List<Map<String,Object>> empsMap = jdbcTemplate.queryForList(sql);
		List<Emp> empList = new ArrayList<Emp>();
		
		
		for(Map<String,Object>empMap :empsMap){
			int empNo= ((BigDecimal) empMap.get("empNo")).intValue();
			String empNm =(String) empMap.get("eName");
			float empSal =((BigDecimal) empMap.get("sal")).floatValue();
			
			
			Emp emp = ctx.getBean("emp",Emp.class);
			emp.setEmpNo(empNo);
			emp.setEmpNm(empNm);
			emp.setEmpSal(empSal);
			empList.add(emp);
		}
		return empList;
	}

	
	
	//insert a record
	
	@Override
	public boolean insertEmp(Emp emp) {
		System.out.println(emp);
		String sql="Insert into emp(empNo,eName,sal) values(?,?,?)";
		Object[] params = new Object[]{emp.getEmpNo(),emp.getEmpNm(),emp.getEmpSal()};
		
		int updtSucc = jdbcTemplate.update(sql, params);

		return updtSucc>0?true:false;
	}
	
	//delete
	//update
	//batch insert
	//batch update
	//page fetching
	//queries with joins
	
	

}

class MyRowMapper implements ParameterizedRowMapper<Emp> {
	       
	private ConfigurableApplicationContext ctx;
	public MyRowMapper(ConfigurableApplicationContext ctx) {
		this.ctx = ctx;
	}
	
	@Override
	public Emp mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Emp emp = ctx.getBean("emp",Emp.class);
		
		emp.setEmpNo(rs.getInt("empNo"));
		emp.setEmpNm(rs.getString("eName"));
		emp.setEmpSal(rs.getFloat("sal"));
		
		return emp;
		
	}
	
}





