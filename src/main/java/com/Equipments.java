package com;

import javax.persistence.*;

@Entity
@Table
public class Equipments {
	@Id
	@SequenceGenerator(
			name = "equipments_sequence",
			sequenceName = "equipments_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "equipments_sequence"
	)
	private Long id;
	private String euipName;

	public String getEuipName() {
		return euipName;
	}

	public void setEuipName(String euipName) {
		this.euipName = euipName;
	}

	@Column(nullable=true,  length=45)
	private String name;



	@Column(nullable=true,length=250)
	private String description;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	

}
