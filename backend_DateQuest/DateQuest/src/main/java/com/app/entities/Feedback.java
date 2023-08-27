package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.enums.FeedbackTitle;
import com.app.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Feedbacks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Feedback extends BaseEntity {
	private int bookingId;
	
	private FeedbackTitle title;
	
	private String description;
	

}
