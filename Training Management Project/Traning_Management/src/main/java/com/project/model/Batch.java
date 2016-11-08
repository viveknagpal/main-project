package com.project.model;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the batch database table.
 * 
 */
@Entity
@NamedQuery(name="Batch.findAll", query="SELECT b FROM Batch b")
public class Batch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="batch_id")
	private int batchId;

	@Temporal(TemporalType.DATE)
	@Column(name="batch_end_date")
	private Date batchEndDate;

	@Column(name="batch_location")
	private String batchLocation;

	@Column(name="batch_name")
	private String batchName;

	@Temporal(TemporalType.DATE)
	@Column(name="batch_start_date")
	private Date batchStartDate;

	@Column(name="batch_type")
	private String batchType;

	@Temporal(TemporalType.DATE)
	private Date created;

	@Temporal(TemporalType.DATE)
	private Date modified;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="created_by")
	private Admin admin1;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="modified_by")
	private Admin admin2;

	//bi-directional many-to-one association to BatchEmployee
	@OneToMany(mappedBy="batch")
	private List<BatchEmployee> batchEmployees;

	//bi-directional many-to-one association to BatchTechnology
	@OneToMany(mappedBy="batch")
	private List<BatchTechnology> batchTechnologies;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="batch")
	private List<TMSSession> sessions;

	public Batch() {
	}

	public int getBatchId() {
		return this.batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public Date getBatchEndDate() {
		return this.batchEndDate;
	}

	public void setBatchEndDate(Date batchEndDate) {
		this.batchEndDate = batchEndDate;
	}

	public String getBatchLocation() {
		return this.batchLocation;
	}

	public void setBatchLocation(String batchLocation) {
		this.batchLocation = batchLocation;
	}

	public String getBatchName() {
		return this.batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Date getBatchStartDate() {
		return this.batchStartDate;
	}

	public void setBatchStartDate(Date batchStartDate) {
		this.batchStartDate = batchStartDate;
	}

	public String getBatchType() {
		return this.batchType;
	}

	public void setBatchType(String batchType) {
		this.batchType = batchType;
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

	public List<BatchEmployee> getBatchEmployees() {
		return this.batchEmployees;
	}

	public void setBatchEmployees(List<BatchEmployee> batchEmployees) {
		this.batchEmployees = batchEmployees;
	}

	public BatchEmployee addBatchEmployee(BatchEmployee batchEmployee) {
		getBatchEmployees().add(batchEmployee);
		batchEmployee.setBatch(this);

		return batchEmployee;
	}

	public BatchEmployee removeBatchEmployee(BatchEmployee batchEmployee) {
		getBatchEmployees().remove(batchEmployee);
		batchEmployee.setBatch(null);

		return batchEmployee;
	}

	public List<BatchTechnology> getBatchTechnologies() {
		return this.batchTechnologies;
	}

	public void setBatchTechnologies(List<BatchTechnology> batchTechnologies) {
		this.batchTechnologies = batchTechnologies;
	}

	public BatchTechnology addBatchTechnology(BatchTechnology batchTechnology) {
		getBatchTechnologies().add(batchTechnology);
		batchTechnology.setBatch(this);

		return batchTechnology;
	}

	public BatchTechnology removeBatchTechnology(BatchTechnology batchTechnology) {
		getBatchTechnologies().remove(batchTechnology);
		batchTechnology.setBatch(null);

		return batchTechnology;
	}

	public List<TMSSession> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<TMSSession> sessions) {
		this.sessions = sessions;
	}

	public TMSSession addSession(TMSSession session) {
		getSessions().add(session);
		session.setBatch(this);

		return session;
	}

	public TMSSession removeSession(TMSSession session) {
		getSessions().remove(session);
		session.setBatch(null);

		return session;
	}

}