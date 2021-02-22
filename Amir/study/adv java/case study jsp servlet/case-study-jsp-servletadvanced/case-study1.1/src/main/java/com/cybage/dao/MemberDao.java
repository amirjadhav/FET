package com.cybage.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Batch;
import com.cybage.model.Enrollment;
import com.cybage.model.Plan;
import com.cybage.model.Sports;
import com.cybage.model.Users;

public class MemberDao {

	public List<Plan> getPlans() throws Exception{

		String sql = "select * from plans";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Plan> plans = new ArrayList<>();
		while(rs.next()) {

			plans.add(new Plan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5)));			
		}		
		return plans;
	}

	//	public List<Sports> getSports() throws Exception{
	//
	//		String sql = "select * from sports";
	//		Connection con = DbUtil.getConnection();
	//		PreparedStatement ps = con.prepareStatement(sql);
	//		ResultSet rs = ps.executeQuery();
	//
	//		List<Sports> sports = new ArrayList<>();
	//		while(rs.next()) {			
	//			sports.add(new Sports(rs.getString(1), rs.getString(2)));			
	//		}		
	//		System.out.println(sports);
	//		return sports;
	//	}
	//
	//	public int addPlan(Plan plan) throws Exception{
	//		String sql = "insert into plans values (?, ?, ?, ?, ?)";
	//		Connection con = DbUtil.getConnection();
	//		PreparedStatement ps = con.prepareStatement(sql);
	//		ps.setString(1, plan.getPlanid());
	//		ps.setString(2, plan.getPlanname());
	//		ps.setString(3, plan.getSportid());
	//		ps.setDouble(4, plan.getFees());
	//		ps.setInt(5, plan.getDuration());
	//		return ps.executeUpdate();		
	//	}
	//
	//	public int deletePlan(String planid) throws Exception{
	//		String sql = "delete from plans where planid=?";
	//		Connection con = DbUtil.getConnection();
	//		PreparedStatement ps = con.prepareStatement(sql);
	//		ps.setString(1, planid);
	//		return ps.executeUpdate();		
	//	}
	//
	//	public Plan findPlan(String planid) throws Exception{
	//		String sql = "select * from plans where planid = ? ";
	//		Connection con = DbUtil.getConnection();
	//		PreparedStatement ps = con.prepareStatement(sql);
	//		ps.setString(1, planid);
	//		ResultSet rs = ps.executeQuery();
	//
	//		Plan plan = new Plan();
	//		if(rs.next()) {
	//			plan = new Plan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
	//		}
	//		System.out.println("inside dao: "+ plan);
	//		return plan;
	//	}
	//
	//	public int updatePlan(Plan plan) throws Exception{
	//		String sql = "update plans set planname = ?, sportsid = ?, fees = ? , duration = ? where planid = ? ";
	//		Connection con = DbUtil.getConnection();
	//		PreparedStatement ps = con.prepareStatement(sql);
	//		ps.setString(1, plan.getPlanname());
	//		ps.setString(2, plan.getSportid());
	//		ps.setDouble(3, plan.getFees());
	//		ps.setInt(4, plan.getDuration());
	//		ps.setString(5, plan.getPlanid());
	//		return ps.executeUpdate();
	//	}
	//
	public List<Batch> getBatches() throws Exception{
		String sql = "select * from batches";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Batch> batches = new ArrayList<>();
		while(rs.next()) {			
			batches.add(
					new Batch(rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getDate(4).toLocalDate(), rs.getTime(5).toLocalTime(), rs.getDouble(6), rs.getInt(7)
							)
					);			
		}			
		return batches;

	}
	//
	//	public int addBatch(Batch batch) throws Exception{
	//		String sql = "insert into batches values (?, ?, ?, ?, ?, ? , ?)";
	//		Connection con = DbUtil.getConnection();
	//		PreparedStatement ps = con.prepareStatement(sql);
	//		ps.setString(1, batch.getBatchid());
	//		ps.setString(2, batch.getBatchname());
	//		ps.setString(3, batch.getSportsid());
	//		ps.setDate(4, Date.valueOf(batch.getBatchStartDate()));
	//		ps.setTime(5, Time.valueOf(batch.getBatchTime()));
	//		ps.setDouble(6, batch.getBatchDuration());
	//		ps.setInt(7, batch.getBatchSize());
	//		return ps.executeUpdate();		
	//	}
	//
	//	public int deleteBatch(String batchid) throws Exception{
	//		String sql = "delete from batches where batchid=?";
	//		Connection con = DbUtil.getConnection();
	//		PreparedStatement ps = con.prepareStatement(sql);
	//		ps.setString(1, batchid);
	//		return ps.executeUpdate();	
	//	}
	//	
	//	
	public Batch findBatch(String batchId) throws Exception{
		String sql = "select * from batches where batchid = ? ";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, batchId);
		ResultSet rs = ps.executeQuery();

		Batch batch = new Batch();
		if(rs.next()) {
			batch = new Batch(rs.getString(1), rs.getString(2), rs.getString(3), 
					rs.getDate(4).toLocalDate(), rs.getTime(5).toLocalTime(), rs.getDouble(6), rs.getInt(7));
		}
		return batch;
	}
	//
	public int updateBatch(Batch batch) throws Exception{
		String sql = "update batches set batchname = ?, sportsid = ?, batchstartdate = ? , "
				+ "batchtime = ?, batchduration = ?, batchsize = ?  where batchid = ? ";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, batch.getBatchname());
		ps.setString(2, batch.getSportsid());
		ps.setDate(3, Date.valueOf(batch.getBatchStartDate()));
		ps.setTime(4, Time.valueOf(batch.getBatchTime()));
		ps.setDouble(5, batch.getBatchDuration());
		ps.setInt(6, batch.getBatchSize());
		ps.setString(7, batch.getBatchid());
		return ps.executeUpdate();
	}

	public int enroll(Enrollment enroll) throws Exception {
		String sql = "insert into enrollment values (?, ?, ?, ?, ?, ?)";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, enroll.getEnrollid());
		ps.setString(2, enroll.getUsername());
		ps.setString(3, enroll.getPlanid());
		ps.setString(4, enroll.getBatchid());
		ps.setDate(5, Date.valueOf(enroll.getStartdate()));
		ps.setString(6, enroll.getStatus());
		return ps.executeUpdate();		
	}
	public List<Enrollment> getEnrollments() throws Exception{
		String sql = "select * from enrollment";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Enrollment> enrollments = new ArrayList<>();
		while(rs.next()) {			
			enrollments.add(
					new Enrollment(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), 
							rs.getDate(5).toLocalDate(),  rs.getString(6)
							)
					);			
		}			
		return enrollments;

	}

	public int register(Users user) throws Exception{
		String sql = "insert into users values (?, ?, ?)";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getRole());		
		return ps.executeUpdate();		
	}

}