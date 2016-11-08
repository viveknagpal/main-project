package com.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trainer database table.
 * 
 */
@Entity
@NamedQuery(name="Trainer.findAll", query="SELECT t FROM Trainer t")
public class Trainer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="trainer_id")
	private int trainerId;

	@Temporal(TemporalType.DATE)
	private Date created;

	@Temporal(TemporalType.DATE)
	private Date modified;

	@Column(name="trainer_email_id")
	private String trainerEmailId;

	@Column(name="trainer_location")
	private String trainerLocation;

	@Column(name="trainer_name")
	private String trainerName;

	@Column(name="trainer_password")
	private String trainerPassword;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="trainer")
	private List<TMSSession> sessions;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="created_by")
	private Admin admin1;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="modified_by")
	private Admin admin2;

	//bi-directional many-to-one association to TrainerTechnology
	@OneToMany(mappedBy="trainer")
	private List<TrainerTechnology> trainerTechnologies;

	public Trainer() {
	}

	public int getTrainerId() {
		return this.trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return this.modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getTrainerEmailId() {
		return this.trainerEmailId;
	}

	public void setTrainerEmailId(String trainerEmailId) {
		this.trainerEmailId = trainerEmailId;
	}

	public String getTrainerLocation() {
		return this.trainerLocation;
	}

	public void setTrainerLocation(String trainerLocation) {
		this.trainerLocation = trainerLocation;
	}

	public String getTrainerName() {
		return this.trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerPassword() {
		return this.trainerPassword;
	}

	public void setTrainerPassword(String trainerPassword) {
		this.trainerPassword = trainerPassword;
	}

	public List<TMSSession> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<TMSSession> sessions) {
		this.sessions = sessions;
	}

	public TMSSession addSession(TMSSession session) {
		getSessions().add(session);
		session.setTrainer(this);

		return session;
	}

	public TMSSession removeSession(TMSSession session) {
		getSessions().remove(session);
		session.setTrainer(null);

		return session;
	}

	public Admin getAdmin1() {
		return this.admin1;
	}

	public void setAdmin1(Admin admin1) {
		this.admin1 = admin1;
	}

	public Admin getAdmin2() {
		return this.admin2;
	}

	public void setAdmin2(Admin admin2) {
		this.admin2 = admin2;
	}

	public List<TrainerTechnology> getTrainerTechnologies() {
		return this.trainerTechnologies;
	}

	public void setTrainerTechnologies(List<TrainerTechnology> trainerTechnologies) {
		this.trainerTechnologies = trainerTechnologies;
	}

	public TrainerTechnology addTrainerTechnology(TrainerTechnology trainerTechnology) {
		getTrainerTechnologies().add(trainerTechnology);
		trainerTechnology.setTrainer(this);

		return trainerTechnology;
	}

	public TrainerTechnology removeTrainerTechnology(TrainerTechnology trainerTechnology) {
		getTrainerTechnologies().remove(trainerTechnology);
		trainerTechnology.setTrainer(null);

		return trainerTechnology;
	}

}