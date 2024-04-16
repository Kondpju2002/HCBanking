package com.vikas.banking.Dao;

import com.vikas.banking.model.Accbalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccbalanceDao extends JpaRepository<Accbalance,Long> {

}
