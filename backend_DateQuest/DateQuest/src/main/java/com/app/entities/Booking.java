package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "Booking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Booking extends BaseEntity {

	private LocalDate bookingdate;

	private Status bookingStatus;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	@OneToOne
	@JoinColumn(name = "package_id")
	private Packages packageId;

	@JsonIgnore
	@OneToMany(mappedBy = "booking",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private List<User> users;

	// userID,PackageID,BookingID

}
