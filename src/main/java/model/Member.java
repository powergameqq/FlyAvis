package model;

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
@Table(name = "Member")
public class Member {
	private Integer userId;
	private String userName;
	private String userGoogleMail;
	private String userPhoto;
	private String userToken;
	private Set<MyTrip> myTrip = new LinkedHashSet<>();
	
	public Member() {
		super();
	}

	public Member(Integer userId, String userName, String userGoogleMail, String userPhoto, String userToken,
			Set<MyTrip> myTrip) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userGoogleMail = userGoogleMail;
		this.userPhoto = userPhoto;
		this.userToken = userToken;
		this.myTrip = myTrip;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name="userName", columnDefinition="varchar(32)")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="userGoogleMail", columnDefinition="varchar(64)")
	public String getUserGoogleMail() {
		return userGoogleMail;
	}

	public void setUserGoogleMail(String userGoogleMail) {
		this.userGoogleMail = userGoogleMail;
	}
	
	@Column(name="userPhoto", columnDefinition="varchar(64)")
	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	@Column(name="userToken", columnDefinition="varchar(255)")
	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="userId", referencedColumnName="userId")
	public Set<MyTrip> getMyTrip() {
		return myTrip;
	}

	public void setMyTrip(Set<MyTrip> myTrip) {
		this.myTrip = myTrip;
	}
	
	
	
	
}
