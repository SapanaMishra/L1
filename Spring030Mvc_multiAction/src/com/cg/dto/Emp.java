package com.cg.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

@Component("emp")
@Scope("prototype")
public class Emp {
	
	private int empNo;
	
	@NotEmpty(message="Name is mandatory")
	@Size(min=3, max=10, message="Minimum 3 characters and maximum 10 characters")
	private String empNm;
	
	
	private float empSal;
	
	public Emp() {
		super();
	}

	public Emp(int empNo, String empNm, float empSal) {
		super();
		this.empNo = empNo;
		this.empNm = empNm;
		this.empSal = empSal;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public float getEmpSal() {
		return empSal;
	}

	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empNm == null) ? 0 : empNm.hashCode());
		result = prime * result + empNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Emp))
			return false;
		Emp other = (Emp) obj;
		if (empNm == null) {
			if (other.empNm != null)
				return false;
		} else if (!empNm.equals(other.empNm))
			return false;
		if (empNo != other.empNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empNm=" + empNm + ", empSal="
				+ empSal + "]";
	}
	
	

}
