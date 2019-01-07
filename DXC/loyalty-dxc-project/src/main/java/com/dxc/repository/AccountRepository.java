package com.dxc.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dxc.entity.Account;

@RepositoryRestResource
public interface AccountRepository extends CrudRepository<Account, Long> {
	List<Account> findAll();

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Account account set account.point =:isPoint where account.accountid =:isAccountId")
	public void updatePoint(@Param("isAccountId") int isAccountId, @Param("isPoint") int isPoint);
}
