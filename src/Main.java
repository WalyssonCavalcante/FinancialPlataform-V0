import model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Criar usuário
        User walysson = new User();
        walysson.setId(1L);
        walysson.setName("Walysson");
        walysson.setEmail("walysson@email.com");

        // 2. Criar conta
        CheckingAccount nubank = new CheckingAccount();
        nubank.setId(1L);
        nubank.setName("Nubank");
        nubank.setBalance(BigDecimal.ZERO);

        // 3. Criar categorias
        Category salaryCategory = new Category();
        salaryCategory.setId(1L);
        salaryCategory.setName("Salário");

        Category groceriesCategory = new Category();
        groceriesCategory.setId(2L);
        groceriesCategory.setName("Mercado");

        Category internetCategory = new Category();
        internetCategory.setId(3L);
        internetCategory.setName("Internet");

        // 4. Adicionar Receitas
        Transaction salary = new Transaction();
        salary.setId(1L);
        salary.setDescription("Salário do mês");
        salary.setAmount(new BigDecimal("3000.00"));
        salary.setType(TransactionType.INCOME);
        salary.setDate(LocalDate.now());
        salary.setAccount(nubank);
        salary.setCategory(salaryCategory);

        nubank.addTransaction(salary);

        // 5. Adicionar Despesas
        Transaction groceries = new Transaction();
        groceries.setId(2L);
        groceries.setDescription("Compras do mês");
        groceries.setAmount(new BigDecimal("300.00"));
        groceries.setType(TransactionType.EXPENSE);
        groceries.setDate(LocalDate.now());
        groceries.setAccount(nubank);
        groceries.setCategory(groceriesCategory);

        nubank.addTransaction(groceries);

        nubank.setBalance(nubank.getBalance().subtract(groceries.getAmount()));

        Transaction internetBill = new Transaction();
        internetBill.setId(3L);
        internetBill.setDescription("Conta de Internet");
        internetBill.setAmount(new BigDecimal("200.00"));
        internetBill.setType(TransactionType.EXPENSE);
        internetBill.setDate(LocalDate.now());
        internetBill.setAccount(nubank);
        internetBill.setCategory(internetCategory);

        nubank.addTransaction(internetBill);
        nubank.setBalance(nubank.getBalance().subtract(internetBill.getAmount()));

        // 6. Consultar saldo e Listar transações
        System.out.println("======================================");
        System.out.println("Usuário: " + walysson.getName());
        System.out.println("Conta: " + nubank.getName());
        System.out.println("Saldo Atual: R$ " + nubank.getBalance());
        System.out.println("======================================");
        System.out.println("Extrato de Transações:");

        for (Transaction t : nubank.getTransactions()) {
            System.out.println("- " + t.getCategory().getName() + " | "
                    + t.getDescription() + " | R$ "
                    + t.getAmount());
        }

        System.out.println("======================================");
    }
}