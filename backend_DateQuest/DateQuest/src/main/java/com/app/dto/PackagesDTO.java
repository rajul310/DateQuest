package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.enums.PackagesType;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PackagesDTO {

    @NotBlank(message = "Package name is required")
    private String pName;

    @NotNull(message = "Package date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pDate;

    @NotNull(message = "Package start time is required")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startAt;

    @NotNull(message = "Package end time is required")
    @Future(message = "end time must be a after Start time !!")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endAt;

    @NotBlank(message = "Package location is required")
    private String location;

    @NotNull(message = "Package activities type is required")
    @Enumerated(EnumType.STRING)
    private PackagesType activities;

}
