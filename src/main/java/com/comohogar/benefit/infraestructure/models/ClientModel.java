/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comohogar.benefit.infraestructure.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.comohogar.benefit.domain.enums.GroupType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "CLIENTS", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class ClientModel extends PersonModel {

	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private GroupType type;

	private String option;
}
