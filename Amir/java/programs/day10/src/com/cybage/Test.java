package com.cybage;

public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println("jdbc day 2...");
		JDBCExample je = new JDBCExample();
		je.getResultInfo();
		je.getInfo();
		je.txnMgmnt();
	}
}