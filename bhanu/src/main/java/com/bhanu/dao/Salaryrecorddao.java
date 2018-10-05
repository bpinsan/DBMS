package com.bhanu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bhanu.model.Salaryrecord;

public interface Salaryrecorddao {
	
	@Autowired
	public void addRecord(Salaryrecord salaryrecord);
	public List<Salaryrecord> getAllRecords();
	public List<Salaryrecord> getRecords(int Employee_id);
	public Boolean isPaid(int Employee_id,int Month,int Year);
	
}
