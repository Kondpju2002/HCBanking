package com.vikas.banking.Dao;

import com.vikas.banking.model.CustDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustDetailsDao extends JpaRepository<CustDetails,Long> {


}
