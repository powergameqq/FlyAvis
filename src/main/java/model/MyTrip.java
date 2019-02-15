package model;

import java.sql.Blob;
import java.sql.Date;
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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
@Component
@Entity
@Table(name = "MyTrip")
public class MyTrip {
	private Integer tripId;
	private String tripName;
	
	private Date tripDate;
	private Integer tripViews;
	private Integer tripLike;
	private Integer userId;
	private Boolean tripPrivate;
	
	private Date createtime;
	private Blob tripPhoto;
	private Set<TeamMember> teamMember = new LinkedHashSet<>();
	private Set<PlanDetail> planDetail = new LinkedHashSet<>();
	
	public MyTrip() {
		super();
	}

	public MyTrip(Integer tripId, String tripName, Date tripDate, Integer tripViews, Integer tripLike, Integer userId,
			Boolean tripPrivate, Date createtime, Blob tripPhoto, Set<TeamMember> teamMember,
			Set<PlanDetail> planDetail) {
		super();
		this.tripId = tripId;
		this.tripName = tripName;
		this.tripDate = tripDate;
		this.tripViews = tripViews;
		this.tripLike = tripLike;
		this.userId = userId;
		this.tripPrivate = tripPrivate;
		this.createtime = createtime;
		this.tripPhoto = tripPhoto;
		this.teamMember = teamMember;
		this.planDetail = planDetail;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}

	@Column(name="tripName", columnDefinition="varchar(32)")
	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}

	public Integer getTripViews() {
		return tripViews;
	}

	public void setTripViews(Integer tripViews) {
		this.tripViews = tripViews;
	}

	public Integer getTripLike() {
		return tripLike;
	}

	public void setTripLike(Integer tripLike) {
		this.tripLike = tripLike;
	}

	@Column(name="userId")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getTripPrivate() {
		return tripPrivate;
	}

	public void setTripPrivate(Boolean tripPrivate) {
		this.tripPrivate = tripPrivate;
	}
	@JsonFormat(pattern="yyyy-MM-dd")
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Blob getTripPhoto() {
		return tripPhoto;
	}

	public void setTripPhoto(Blob tripPhoto) {
		this.tripPhoto = tripPhoto;
	}

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="tripId", referencedColumnName="tripId")
	public Set<TeamMember> getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(Set<TeamMember> teamMember) {
		this.teamMember = teamMember;
	}

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="tripId", referencedColumnName="tripId")
	public Set<PlanDetail> getPlanDetail() {
		return planDetail;
	}

	public void setPlanDetail(Set<PlanDetail> planDetail) {
		this.planDetail = planDetail;
	}

	
}
