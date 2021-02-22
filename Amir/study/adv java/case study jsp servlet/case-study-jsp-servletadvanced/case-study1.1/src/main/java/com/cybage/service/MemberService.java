package com.cybage.service;

import java.util.List;

import com.cybage.dao.ManagerDao;
import com.cybage.dao.MemberDao;
import com.cybage.model.Batch;
import com.cybage.model.Enrollment;
import com.cybage.model.Plan;
import com.cybage.model.Users;

public class MemberService {
	MemberDao md = new MemberDao();
	private String getEnrollId() {
		return "enroll"+ Math.round(Math.random()*9999);
	}
	
	public List<Plan> getPlans() throws Exception{
		return md.getPlans();
	}

	public int enroll(Enrollment enroll) throws Exception{
		enroll.setEnrollid(getEnrollId());
		Batch batch = md.findBatch(enroll.getBatchid());
		int batchSize = batch.getBatchSize();
		if(batchSize > 1) {
			batch.setBatchSize(batchSize-1);
			enroll.setStatus("Enrolled");
			md.updateBatch(batch);
			return md.enroll(enroll);
		}else {
			enroll.setStatus("Rejected");
			return md.enroll(enroll);
		}
	}
	public List<Enrollment> getEnrollments() throws Exception{
		return md.getEnrollments();
	}

	public int register(Users user) throws Exception{
		return md.register(user);
	}
}
