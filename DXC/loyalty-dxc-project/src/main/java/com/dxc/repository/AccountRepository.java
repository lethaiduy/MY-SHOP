package com.dxc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dxc.entity.Account;

@RepositoryRestResource
public interface AccountRepository  extends CrudRepository<Account, Long>{

}
