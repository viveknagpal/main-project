package com.project.model;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the batch_technology database table.
 * 
 */
@Entity
@Table(name="batch_technology")
@NamedQuery(name="BatchTechnology.findAll", query="SELECT b FROM BatchTechnology b")
public class BatchTechnology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="batch_tech_id")
	private int batchTechId;

	//bi-directional many-to-one association to Batch
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;

	//bi-directional many-to-one association to Technology
	@ManyToOne
	@JoinColumn(name="tech_id")
	private Technology technology;

	public BatchTechnology() {
	}

	public int getBatchTechId() {
		return this.batchTechId;
	}

	public void setBatchTechId(int batchTechId) {
		this.batchTechId = batchTechId;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Technology getTechnology() {
		return this.technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

}