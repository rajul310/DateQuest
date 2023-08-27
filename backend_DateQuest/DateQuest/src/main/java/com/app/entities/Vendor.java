
package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Vendors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "vPassword")

public class Vendor extends BaseEntity {

	@Column(length = 100, nullable = false)
	private String vEmail;

	@Column(length = 300, nullable = false)
	private String vPassword;

	private String vName;
	@Column(unique = true)
	private int vMobileNo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate vDob;
	private int vAge;
	@Enumerated(EnumType.STRING)
	private Gender vGender;

	private String vAddress;

	private String vCity;

	private String vGovtId;
	
	
	@OneToMany(mappedBy = "vendorId",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Packages> packages;

}
