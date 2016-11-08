package com.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emp_id")
	private int empId;

	@Temporal(TemporalType.DATE)
	private Date created;

	@Column(name="emp_email_id")
	private String empEmailId;

	@Column(name="emp_location")
	private String empLocation;

	@Column(name="emp_name")
	private String empName;

	@Column(name="emp_password")
	private String empPassword;

	@Temporal(TemporalType.DATE)
	private Date modified;

	//bi-directional many-to-one association to BatchEmployee
	@OneToMany(mappedBy="employee")
	private List<BatchEmployee> batchEmployees;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="created_by")
	private Admin admin1;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="modified_by")
	private Admin admin2;

	public Employee() {
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEmpEmailId() {
		return this.empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpLocation() {
		return this.empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPassword() {
		return this.empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public Date getModified() {
		return this.modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public List<BatchEmployee> getBatchEmployees() {
		return this.batchEmployees;
	}

	public void setBatchEmployees(List<BatchEmployee> batchEmployees) {
		this.batchEmployees = batchEmployees;
	}

	public BatchEmployee addBatchEmployee(BatchEmployee batchEmployee) {
		getBatchEmployees().add(batchEmployee);
		batchEmployee.setEmployee(this);

		return batchEmployee;
	}

	public BatchEmployee removeBatchEmployee(BatchEmployee batchEmployee) {
		getBatchEmployees().remove(batchEmployee);
		batchEmployee.setEmployee(null);

		return batchEmployee;
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

}