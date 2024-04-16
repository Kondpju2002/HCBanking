package com.vikas.banking.Dao;

import com.vikas.banking.model.CustomerAccMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustAccMApDao extends JpaRepository<CustomerAccMap,Long> {

    @Query(value="SELECT*from Customer_Acc_Map cam where cam.cust_id =:id", nativeQuery = true )
     CustomerAccMap findbyCustId(long id);



}

