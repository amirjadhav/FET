package com.cybage.service;

import java.util.List;

import com.cybage.dao.ManagerDao;
import com.cybage.model.Batch;
import com.cybage.model.Plan;
import com.cybage.model.Users;

public class ManagerService {
	ManagerDao md = new ManagerDao();

	private String getPlanId() {
		return "plan"+ Math.round(Math.random()*9999);
	}
	
	private String getBatchId() {
		return "batch"+ Math.round(Math.random()*9999);
	}
	
	
	public List<Plan> getPlans() throws Exception{
		return md.getPlans();
	}
	public int addPlan(Plan plan) throws Exception{
		plan.setPlanid(getPlanId());
		return md.addPlan(plan);		
	}
	public int deletePlan(String planid) throws Exception{		
			return md.deletePlan(planid);				
	}
	public Plan getPlan(String planid) throws Exception{		 
		return md.findPlan(planid);
	}
	public int updatePlan(Plan plan) throws Exception{
		return md.updatePlan(plan);
	}
	public List<Batch> getBatches() throws Exception{		
		return md.getBatches();
	}
	public int addBatch(Batch batch) throws Exception{
		batch.setBatchid(getBatchId());
		return md.addBatch(batch);
	}

	
	public Batch getBatch(String batchid) throws Exception{		 
		return md.findBatch(batchid);
	}
	
	
	public int deleteBatch(String batchid)  throws Exception{
		return md.deleteBatch(batchid);
	}

	public int updateBatch(Batch batch) throws Exception {
		return md.updateBatch(batch);		
	}
}
