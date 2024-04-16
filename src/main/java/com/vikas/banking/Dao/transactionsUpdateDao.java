package com.vikas.banking.Dao;

import com.vikas.banking.model.AcctransactionsUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface transactionsUpdateDao extends JpaRepository<AcctransactionsUpdate,Long> {

    @Query(value = "SELECT*FROM bank.acctransactions_update ac where ac.trans_ref_id=:refid and ac.acc_id=:accId ",nativeQuery=true)
    Optional<AcctransactionsUpdate> findByBoth(long accId,long refid );

    @Query(value="SELECT*FROM bank.acctransactions_update ac where ac.acc_id=:accId",nativeQuery = true)
    Optional<AcctransactionsUpdate> findBy_AccId(long accId);

    @Query(value="SELECT*FROM bank.acctransactions_update ac where ac.trans_ref_id=:refId",nativeQuery = true)
    Optional<AcctransactionsUpdate> findBy_RefId(long refId);
}
