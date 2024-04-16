package com.vikas.banking.service;

import com.vikas.banking.Dao.*;
import com.vikas.banking.exception.IDnotfound;
import com.vikas.banking.model.*;
import com.vikas.banking.response.BalanceResponse;
import com.vikas.banking.response.CustomerResponse;
import com.vikas.banking.response.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class Bankservice {

    @Autowired
    CustaddressDao custaddressdao;

    @Autowired
    CustDetailsDao custdetailsdao;

    @Autowired
    CustAccMApDao camd;

    @Autowired
    AccbalanceDao accbalancedao;

    @Autowired
    transactionsUpdateDao transactiondao;



    public Object addcustomer(custFulladd cf) {

        Random r=new Random();

        long customerid=r.nextInt((600000-50000)+1)+50000;
        long addressid=r.nextInt(600000-500000+1)+600000;
        long accountid=r.nextInt(600000-500000+1)+700000;

        Timestamp time=new Timestamp(new Date().getTime());

        Custaddress custadd=new Custaddress(addressid,cf.getCountry(),cf.getCity(),cf.getAddressLane(),cf.getPin(),time);
        CustDetails custDetails=new CustDetails(customerid,cf.getName(),addressid,cf.getPhonenum(),cf.getEmail(),time,time);

        custaddressdao.save(custadd);

        custdetailsdao.save(custDetails);

        CustomerAccMap cam=new CustomerAccMap(accountid,customerid);

        camd.save(cam);

        Accbalance accbalance = new Accbalance(accountid, 500);

        accbalancedao.save(accbalance);

        return new CustomerResponse(custDetails.getName(),customerid,accountid,accbalance.getBalance());


    }

    public List<CustDetails> getallCustomers() {
        return custdetailsdao.findAll();

    }

    public Object getCustomerbyId(long id) {

        try {
            Optional<CustDetails> c=custdetailsdao.findById(id);
            if(c.isEmpty())
            {
                throw new RuntimeException();
            }
            return c;
        }
        catch(Exception e){
            return new IDnotfound("Provided input's {query params or path params} is/are Invalid!.", "HCTB404");
        }


    }


    public Object getBalancebyAcc_Id(long accId) {
        try{
            Optional<Accbalance> ab=accbalancedao.findById(accId);
            if(ab.isEmpty()){
                throw new RuntimeException();
            }
            return new BalanceResponse(accId,ab.get().getBalance());
        }
        catch(Exception e)
        {
            return new IDnotfound("Customer Details are not available","HCT404");
        }


    }
    public Object getBalancebyCust_Id(long custId){
        try{
            CustomerAccMap cam=camd.findbyCustId(custId);
            Optional<Accbalance> ab=accbalancedao.findById(cam.getAccId());
            if(ab.isEmpty()){
                throw new RuntimeException();
            }
            return new BalanceResponse(cam.getAccId(),ab.get().getBalance());
        }
        catch (Exception e){
            return new IDnotfound("Customer Details are not available","HCT404");
        }
    }

    public Object newTransaction(Transactions accTran) {
           Timestamp ts=new Timestamp(new Date().getTime());
            long accId=accTran.getAccId();
            long to_accId=accTran.getToaccId();

            double amount=accTran.getAmount();

            Random rm=new  Random();

            long transaction_Id1=rm.nextInt(800000-700000+1)+700000;
            long transaction_Id2=rm.nextInt(800000-700000+1)+700000;

            long trans_refId=rm.nextInt(700000-600000+1)+600000;

            Optional<Accbalance> pay=accbalancedao.findById(accId);

            if(pay.isPresent()){
                Accbalance  transamount=pay.get();
                double currentbalance=transamount.getBalance();
                if(currentbalance>=amount){
                    transamount.setBalance(currentbalance-amount);

                    AcctransactionsUpdate accountupdates=new AcctransactionsUpdate(accId,transaction_Id1,trans_refId,0,amount,transamount.getBalance(),ts);
                    transactiondao.save(accountupdates);
                    accbalancedao.save(transamount);

                }
                else{
                    return new IDnotfound("Insufficient funds","HCTB400");
                }

            }
            else{
                return new IDnotfound( "Provided Details are Invalid!...","HCTB400");
            }

            Optional<Accbalance> receiver = accbalancedao.findById(to_accId);

            if(receiver.isPresent()){
                Accbalance  receiverbalance =receiver.get();
                double balance=receiverbalance.getBalance();

                receiverbalance.setBalance(balance+amount);

                AcctransactionsUpdate accountupdate=new AcctransactionsUpdate(  to_accId,transaction_Id2,trans_refId,amount,0,receiverbalance.getBalance(),ts);

                transactiondao.save(accountupdate);
                accbalancedao.save(receiverbalance);

            }
            else{
                return new IDnotfound("Provided Details are Invalid!..","HCTB400");

            }
            return new TransactionResponse("Transaction Successful","HCT200",trans_refId);



    }

    public Object getTransIncludingBoth(long accId, long transactionRefId) {
        return transactiondao.findByBoth(accId,transactionRefId);

    }


    public Object transactionByAccId(long accId) {
        return transactiondao.findBy_AccId(accId);
    }


    public Object transactionByredId(long transactionRefId) {

        return transactiondao.findBy_RefId(transactionRefId);
    }
}
