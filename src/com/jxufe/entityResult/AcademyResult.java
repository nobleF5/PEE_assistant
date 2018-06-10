package com.jxufe.entityResult;

public class AcademyResult {

	private int aca_id;
	private String aca_name;
	private int aca_ranking;
	private boolean aca_985;
	private boolean aca_211;
	
	public AcademyResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AcademyResult(int aca_id,String aca_name, int aca_ranking, boolean aca_985, boolean aca_211) {
		super();
		this.aca_id = aca_id;
		this.aca_name = aca_name;
		this.aca_ranking = aca_ranking;
		this.aca_985 = aca_985;
		this.aca_211 = aca_211;
	}
	
	public AcademyResult(int aca_id, String aca_name, boolean aca_985, boolean aca_211) {
		super();
		this.aca_id = aca_id;
		this.aca_name = aca_name;
		this.aca_985 = aca_985;
		this.aca_211 = aca_211;
	}
	public String getAca_name() {
		return aca_name;
	}
	public void setAca_name(String aca_name) {
		this.aca_name = aca_name;
	}
	public int getAca_ranking() {
		return aca_ranking;
	}
	public void setAca_ranking(int aca_ranking) {
		this.aca_ranking = aca_ranking;
	}
	public boolean isAca_985() {
		return aca_985;
	}
	public void setAca_985(boolean aca_985) {
		this.aca_985 = aca_985;
	}
	public boolean isAca_211() {
		return aca_211;
	}
	public void setAca_211(boolean aca_211) {
		this.aca_211 = aca_211;
	}
	public int getAca_id() {
		return aca_id;
	}
	public void setAca_id(int aca_id) {
		this.aca_id = aca_id;
	}
	
	
	
}
