package com.vikas.banking.Bankingcontroller;
import com.vikas.banking.exception.IDnotfound;
import com.vikas.banking.model.CustDetails;
import com.vikas.banking.model.Transactions;
import com.vikas.banking.model.custFulladd;
import com.vikas.banking.service.Bankservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/Bank")

public class Bankingcontroller {

    @Autowired
    Bankservice Bankserv;


    @PostMapping("customers")
    public Object addCustomer(@RequestBody custFulladd cf){
        return Bankserv.addcustomer(cf);
    }

    @GetMapping("allcustomers")
    public List<CustDetails> getallCustomers(){
        return Bankserv.getallCustomers();

    }

    @GetMapping("customers/{id}")
    public Object getCustomerbyId(@PathVariable long id){

        return Bankserv.getCustomerbyId(id);

    }

    @GetMapping("balances")
    public Object getBalances(@RequestParam long custId,@RequestParam long accId){
        if(custId!=0 && accId!=0 )
        {
            return Bankserv.getBalancebyAcc_Id(accId);
        }
        else if(custId!=0 ) {
            return Bankserv.getBalancebyCust_Id(custId);


        }
        else if(accId!=0){
            return Bankserv.getBalancebyAcc_Id(accId);

        }
        else{
            return new IDnotfound("Give any one among CustomerId or AccountId","BadRequest 404");
        }

    }

    @PostMapping("transactions")
    public Object newTransaction(@RequestBody Transactions acctrans){
        String s= acctrans.getT();
        if(s.equals("CREDIT")){
            return Bankserv.newTransaction( acctrans);
        }

            return new IDnotfound("Provided Details are Invalid","HCT404");

    }


    @GetMapping("getTransactions")
    public Object getTransactions(@RequestParam long accId,@RequestParam long transaction_refId){
        if(accId==0 && transaction_refId==0){
            return new IDnotfound("Required Query parameter's are not provided!.","HCTB400");
        }
        else if(accId!=0 && transaction_refId!=0){
            return Bankserv.getTransIncludingBoth(accId,transaction_refId);
        }
        else if(accId!=0){
            return Bankserv.transactionByAccId(accId);

        }
        else if(transaction_refId!=0){
            return Bankserv.transactionByredId(transaction_refId);
        }
        else{
            return null;
        }

    }

}
