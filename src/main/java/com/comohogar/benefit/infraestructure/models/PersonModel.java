/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comohogar.benefit.infraestructure.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author diego
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class PersonModel extends BaseEntityModel {

	@Column(nullable = false)
	private String names;

	@Column(nullable = false)
	private String email;

	private String phone;

}
