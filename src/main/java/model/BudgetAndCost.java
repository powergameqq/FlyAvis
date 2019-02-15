package model;

public class BudgetAndCost {
	private String spotName;
	private Integer bugdet;
	private Integer cost;
	public BudgetAndCost() {
		super();
	}
	public BudgetAndCost(String spotName, Integer bugdet, Integer cost) {
		super();
		this.spotName = spotName;
		this.bugdet = bugdet;
		this.cost = cost;
	}
	public String getSpotName() {
		return spotName;
	}
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	public Integer getBugdet() {
		return bugdet;
	}
	public void setBugdet(Integer bugdet) {
		this.bugdet = bugdet;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	
}
