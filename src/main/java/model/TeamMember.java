package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "TeamMember")
public class TeamMember {
	private Integer memberId;
	private Integer userId;
	private String memberName;
	private String teamName;
	private Integer tripId;
	
	public TeamMember() {
		super();
	}

	public TeamMember(Integer memberId, Integer userId, String memberName, String teamName, Integer tripId) {
		super();
		this.memberId = memberId;
		this.userId = userId;
		this.memberName = memberName;
		this.teamName = teamName;
		this.tripId = tripId;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name="memberName", columnDefinition="varchar(32)")
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Column(name="teamName", columnDefinition="varchar(32)")
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Column(name="tripId")
	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}
	
	
}
