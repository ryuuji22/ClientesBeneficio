/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comohogar.benefit.infraestructure.repositories.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comohogar.benefit.domain.enums.GroupType;
import com.comohogar.benefit.infraestructure.models.ClientModel;

/**
 *
 * @author diego
 */
public interface IJpaClientRepository extends JpaRepository<ClientModel, String> {

	public Optional<List<ClientModel>> findByEnabled(Boolean enabled);

	public Optional<ClientModel> findByNamesAndTypeAndEnabled(String names, GroupType type, Boolean enabled);

	public Optional<ClientModel> findByTypeAndOptionAndEnabled(GroupType type, String option, Boolean enabled);

}
