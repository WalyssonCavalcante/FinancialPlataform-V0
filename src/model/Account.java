package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private long id;
    private String name;
    private BigDecimal balance;
    private AccountType type;

    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction t){
        this.transactions.add(t);

        if (t.getType() == TransactionType.INCOME){
            this.balance = this.balance.add(t.getAmount());
        } else if (t.getType() == TransactionType.EXPENSE) {
            this.balance = this.balance.subtract(t.getAmount());
        }

    }

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
