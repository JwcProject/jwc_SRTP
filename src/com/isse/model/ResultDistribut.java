  package com.isse.model;

public class ResultDistribut {
	private String id;
	private String jqId; // 届期id
	private String unitId; // 单位id
	private String unitName;// 单位名称
	private String jqName; // 届期名称
	private Double decSum; // 申报数
	private Double proSum; // 立项数
	private Double bestSum;// 优秀数
	private Double badSum; // 不及格数
	private Double endSum; // 结题数
	private Double delaySum;// 延期数 = 立项数 - 结题数
	private Double proRate; // 立项率 = 立项数/申报数
	private Double bestRate; // 优秀率 = 优秀数/立项数
	private Double endRate; // 结题率  = 结题数/立项数
	private Double delayRate;// 延期率=延期数/立项数
	
	public ResultDistribut(){
	}

	public ResultDistribut(String id,String jqId, String unitId, String unitName,
			String jqName, Double decSum, Double proSum, Double bestSum,
			Double badSum,Double endSum,Double delaySum) {
		
		this.id = id;
		this.jqId = jqId;
		this.unitId = unitId;
		this.unitName = unitName;
		this.jqName = jqName;
		this.decSum = decSum;
		this.proSum = proSum;
		this.bestSum = bestSum;
		this.endSum = endSum;
		this.badSum = badSum;
		this.delaySum = proSum - endSum;
		this.proRate = proSum/decSum;
		this.bestRate = bestSum/proSum;
		this.endRate = endSum/proSum;
		this.delayRate = delaySum/proSum;		
	}

	public String getJqId() {
		return jqId;
	}

	public void setJqId(String jqId) {
		this.jqId = jqId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getJqName() {
		return jqName;
	}

	public void setJqName(String jqName) {
		this.jqName = jqName;
	}

	public Double getDecSum() {
		return decSum;
	}

	public void setDecSum(Double decSum) {
		this.decSum = decSum;
	}

	public Double getProSum() {
		return proSum;
	}

	public void setProSum(Double proSum) {
		this.proSum = proSum;
	}

	public Double getBestSum() {
		return bestSum;
	}

	public void setBestSum(Double bestSum) {
		this.bestSum = bestSum;
	}

	public Double getBadSum() {
		return badSum;
	}

	public void setBadSum(Double badSum) {
		this.badSum = badSum;
	}

	public Double getEndSum() {
		return endSum;
	}

	public void setEndSum(Double endSum) {
		this.endSum = endSum;
	}

	public Double getDelaySum() {
		return delaySum;
	}

	public void setDelaySum(Double delaySum) {
		this.delaySum = delaySum;
	}

	public Double getProRate() {
		return proRate;
	}

	public void setProRate(Double proRate) {
		this.proRate = proRate;
	}

	public Double getBestRate() {
		return bestRate;
	}

	public void setBestRate(Double bestRate) {
		this.bestRate = bestRate;
	}

	public Double getEndRate() {
		return endRate;
	}

	public void setEndRate(Double endRate) {
		this.endRate = endRate;
	}

	public Double getDelayRate() {
		return delayRate;
	}

	public void setDelayRate(Double delayRate) {
		this.delayRate = delayRate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
