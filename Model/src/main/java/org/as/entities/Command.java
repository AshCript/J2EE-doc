package org.as.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Command implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	private Date dateCommand;
	
	public Command() {
		super();
	}
	
	public Command(User user, Date dateCommand) {
		this.user = user;
		this.dateCommand = dateCommand;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getDateCommand() {
		return dateCommand;
	}
	public void setDateCommand(Date dateCommand) {
		this.dateCommand = dateCommand;
	}
	
	@Override
	public String toString() {
		return "Command [id=" + id + ", user=" + user + ", dateCommand=" + dateCommand + "]";
	}
}
