package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "Bill")
public class Bill {
	private Integer costId;
	private String costTittle;
	private Integer memberId;
	private Boolean ifTrafficCost;
	private Timestamp costDate;
	private String category;
	private Integer planId;
	private Integer singlePayer;
	private Integer singleCost;
	
	public Bill() {
		super();
	}

	public Bill(Integer costId, String costTittle, Integer memberId, Boolean ifTrafficCost, Timestamp costDate, String category,
			Integer planId, Integer singlePayer, Integer singleCost) {
		super();
		this.costId = costId;
		this.costTittle = costTittle;
		this.memberId = memberId;
		this.ifTrafficCost = ifTrafficCost;
		this.costDate = costDate;
		this.category = category;
		this.planId = planId;
		this.singlePayer = singlePayer;
		this.singleCost = singleCost;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCostId() {
		return costId;
	}

	public void setCostId(Integer costId) {
		this.costId = costId;
	}

	@Column(name="costTittle", columnDefinition="varchar(64)")
	public String getCostTittle() {
		return costTittle;
	}

	public void setCostTittle(String costTittle) {
		this.costTittle = costTittle;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Boolean getIfTrafficCost() {
		return ifTrafficCost;
	}

	public void setIfTrafficCost(Boolean ifTrafficCost) {
		this.ifTrafficCost = ifTrafficCost;
	}

	@Column(name="costDate", columnDefinition="DATETIME")
	public Timestamp getCostDate() {
		return costDate;
	}

	public void setCostDate(Timestamp costDate) {
		this.costDate = costDate;
	}

	@Column(name="category", columnDefinition="varchar(64)")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Column(name="planId")
	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Integer getSinglePayer() {
		return singlePayer;
	}

	public void setSinglePayer(Integer singlePayer) {
		this.singlePayer = singlePayer;
	}

	public Integer getSingleCost() {
		return singleCost;
	}

	public void setSingleCost(Integer singleCost) {
		this.singleCost = singleCost;
	}
	
	
}
