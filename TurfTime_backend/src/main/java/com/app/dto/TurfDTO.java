package com.app.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TurfDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long turfId;
	@NotBlank(message = "Name cannot be empty")
    private String name;
	private String location;
	private boolean availability;
	private String description;
}
