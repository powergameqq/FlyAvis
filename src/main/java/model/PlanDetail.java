package model;

import java.sql.Time;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "PlanDetail")
public class PlanDetail {
	private Integer planId;
	private Integer planNum;
	private String spotName;
	private Time spotStartime;
	private Time spotEndtime;
	private Integer planDay;
	private Integer spotCost;
	private String spotNotice;
	private Double longitude;
	private Double latitude;
	private String placeId;
	private Integer spotTraffic_fee;
	private Integer tripId;
	private Boolean planB;
	private Set<ToDoList> toDoList = new LinkedHashSet<>();
	private Set<Bill> bill = new LinkedHashSet<>();
	
	public PlanDetail() {
		super();
	}

	public PlanDetail(Integer planId, Integer planNum, String spotName, Time spotStartime, Time spotEndtime, Integer planDay,
			Integer spotCost, String spotNotice, Double longitude, Double latitude, String placeId, Integer spotTraffic_fee,
			Integer tripId, Boolean planB, Set<ToDoList> toDoList, Set<Bill> bill) {
		super();
		this.planId = planId;
		this.planNum = planNum;
		this.spotName = spotName;
		this.spotStartime = spotStartime;
		this.spotEndtime = spotEndtime;
		this.planDay = planDay;
		this.spotCost = spotCost;
		this.spotNotice = spotNotice;
		this.longitude = longitude;
		this.latitude = latitude;
		this.placeId = placeId;
		this.spotTraffic_fee = spotTraffic_fee;
		this.tripId = tripId;
		this.planB = planB;
		this.toDoList = toDoList;
		this.bill = bill;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Integer getPlanNum() {
		return planNum;
	}

	public void setPlanNum(Integer planNum) {
		this.planNum = planNum;
	}

	@Column(name="spotName", columnDefinition="varchar(32)")
	public String getSpotName() {
		return spotName;
	}

	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}

	public Time getSpotStartime() {
		return spotStartime;
	}

	public void setSpotStartime(Time spotStartime) {
		this.spotStartime = spotStartime;
	}

	public Time getSpotEndtime() {
		return spotEndtime;
	}

	public void setSpotEndtime(Time spotEndtime) {
		this.spotEndtime = spotEndtime;
	}

	public Integer getPlanDay() {
		return planDay;
	}

	public void setPlanDay(Integer planDay) {
		this.planDay = planDay;
	}

	public Integer getSpotCost() {
		return spotCost;
	}

	public void setSpotCost(Integer spotCost) {
		this.spotCost = spotCost;
	}

	@Column(name="spotNotice", columnDefinition="varchar(64)")
	public String getSpotNotice() {
		return spotNotice;
	}

	public void setSpotNotice(String spotNotice) {
		this.spotNotice = spotNotice;
	}

	@Column(name="longitude", columnDefinition="decimal(16,10)")
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Column(name="latitude", columnDefinition="decimal(16,10)")
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Column(name="placeId", columnDefinition="varchar(64)")
	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public Integer getSpotTraffic_fee() {
		return spotTraffic_fee;
	}

	public void setSpotTraffic_fee(Integer spotTraffic_fee) {
		this.spotTraffic_fee = spotTraffic_fee;
	}

	@Column(name="tripId")
	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}

	public Boolean getPlanB() {
		return planB;
	}

	public void setPlanB(Boolean planB) {
		this.planB = planB;
	}

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="planId", referencedColumnName="planId")
	public Set<ToDoList> getToDoList() {
		return toDoList;
	}

	public void setToDoList(Set<ToDoList> toDoList) {
		this.toDoList = toDoList;
	}

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="planId", referencedColumnName="planId")
	public Set<Bill> getBill() {
		return bill;
	}

	public void setBill(Set<Bill> bill) {
		this.bill = bill;
	}

	
	
}
