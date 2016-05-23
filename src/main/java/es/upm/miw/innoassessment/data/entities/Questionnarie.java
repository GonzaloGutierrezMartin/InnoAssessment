package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class Questionnarie {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn
	private Model model;

	@Column(unique = true, nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String version;

	public Questionnarie(int id, Model model, String name, String version) {
		super();
		this.id = id;
		this.model = model;
		this.name = name;
		this.version = version;
	}
	
}
