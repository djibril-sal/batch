package com.hama.SpringTransaction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hama.SpringTransaction.exception.BankTransactionException;
import com.hama.SpringTransaction.model.BankAccount;
import com.hama.SpringTransaction.model.BankAccountInfo;

@Repository
public class BankAccountDAO {
	
	@Autowired
	EntityManager entityManager;
	
	public BankAccount findById(long id) {
		
		return entityManager.find(BankAccount.class, id);
	}
	
	public List<BankAccountInfo> listBankAccountInfo() {
		
		String sql = "Select new " +BankAccountInfo.class.getName()
				+" e.id, e.fullName, e.balance " + "from " + BankAccount.class.getName();
		
		Query query = entityManager.createQuery(sql, BankAccountInfo.class);
		
		return query.getResultList();
				
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void addAmount(long id, Double amount) throws BankTransactionException {
		BankAccount account = this.findById(id);
		
		if(account == null) {
			
			throw new BankTransactionException("Account " +id+ " not found !");
		}
		
		Double newBalance = account.getBalance() + amount;
		
		if (account.getBalance() + amount < 0) {
			throw new BankTransactionException("The money in the account " +id+ " is not enough (" + account.getBalance() + ")");
		}
		
		account.setBalance(newBalance);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW,
			rollbackFor = BankTransactionException.class)
	public void sendMoney(long fromAccountId, long toAccountId, Double amount) throws BankTransactionException {
		addAmount(toAccountId, amount);
		addAmount(fromAccountId, -amount);
	}

}
