package com.jxufe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AcademyRankInfo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,name="Rank_ID")
	protected int Rank_ID = 0;
	
	@Column(nullable = true)
	private String Aca_Name;
	
	@Column(nullable = true)
	private int Aca_Ranking;
	
	@OneToOne(optional = false,fetch=FetchType.LAZY)
    @JoinColumn(name = "Aca_ID")
	private AcademyInfo academyInfo;

	public AcademyInfo getAcademyInfo() {
		return academyInfo;
	}

	@JsonIgnore
	public void setAcademyInfo(AcademyInfo academyInfo) {
		this.academyInfo = academyInfo;
	}

	public int getRank_ID() {
		return Rank_ID;
	}

	public void setRank_ID(int rank_ID) {
		Rank_ID = rank_ID;
	}
	public String getAca_Name() {
		return Aca_Name;
	}

	public void setAca_Name(String aca_Name) {
		Aca_Name = aca_Name;
	}

	public int getAca_Ranking() {
		return Aca_Ranking;
	}

	public void setAca_Ranking(int aca_Ranking) {
		Aca_Ranking = aca_Ranking;
	}
	
	

}
