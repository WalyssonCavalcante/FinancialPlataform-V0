package model;

import java.math.BigDecimal;

public class CheckingAccount extends Account{

    private BigDecimal overdraftLimit;

    public void setOverdraftLimit(BigDecimal limit){
        this.overdraftLimit = limit;
    }

    public void withdraw(BigDecimal amount) {
        BigDecimal maxAvailable = this.getBalance().add(this.overdraftLimit);

        if (amount.compareTo(maxAvailable) > 0){
            throw new IllegalArgumentException("Saque negado! Seu limite disponível é de apenas R$ " + maxAvailable);
        }

        this.setBalance(this.getBalance().subtract(amount));
    }
}
