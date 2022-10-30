package com.comohogar.benefit.domain.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.comohogar.benefit.domain.enums.GroupType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {

	private String id;

	private String names;

	private String email;

	private String phone;

	private GroupType type;

	private String option;

	@JsonIgnore
	private Date createdAt;

	@JsonIgnore
	private Boolean enabled;

}
