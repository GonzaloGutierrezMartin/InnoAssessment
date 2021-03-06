package es.upm.miw.innoassessment.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={
		   @UniqueConstraint(columnNames={"product_id", "name"})
		})
public class ProductVersion {
	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String name;

	@Column
	private String description;

	@ManyToOne
	@JoinColumn
	private Product product;

	public ProductVersion(int id) {
		this.id = id;
	}
	
	public ProductVersion() {

	}

	public ProductVersion(String name, Product product) {
		this.name = name;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
