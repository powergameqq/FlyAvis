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
@Table(name = "ToDoList")
public class ToDoList {
	private Integer toDoId;
	private String toDoItem;
	private Boolean done;
	private Integer planId;
	
	public ToDoList() {
		super();
	}

	public ToDoList(Integer toDoId, String toDoItem, Boolean done, Integer planId) {
		super();
		this.toDoId = toDoId;
		this.toDoItem = toDoItem;
		this.done = done;
		this.planId = planId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getToDoId() {
		return toDoId;
	}

	public void setToDoId(Integer toDoId) {
		this.toDoId = toDoId;
	}

	@Column(name="toDoItem", columnDefinition="varchar(32)")
	public String getToDoItem() {
		return toDoItem;
	}

	public void setToDoItem(String toDoItem) {
		this.toDoItem = toDoItem;
	}

	public Boolean isDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}
	
	@Column(name="planId")
	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	
	
}
