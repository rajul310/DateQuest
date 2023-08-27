package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.enums.FeedbackTitle;
import com.app.enums.PackagesType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Packages")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Packages extends BaseEntity {
	private String pName;
	private LocalDate pDate;
	private LocalTime startAt;
	private LocalTime endAt;
	private String location;

	@Enumerated(EnumType.STRING)
	private PackagesType activities;

	@ManyToOne
	@JoinColumn(name = "Vendor_Id")
	private Vendor vendorId;

}
