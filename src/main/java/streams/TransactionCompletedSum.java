package streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
class Transaction {
    private int id;
    private BigDecimal amount;
    private String currency;
    private String status;
}

public class TransactionCompletedSum {
    public static void main(String[] args) {
        List<Transaction> transactionList = List.of(
                new Transaction(1, new BigDecimal(100), "USD", "COMPLETED"),
                new Transaction(2, new BigDecimal(200), "INR", "PENDING"),
                new Transaction(3, new BigDecimal(300), "USD", "COMPLETED"),
                new Transaction(4, new BigDecimal(400), "INR", "FAILED"),
                new Transaction(5, new BigDecimal(500), "INR", "COMPLETED"));

        var results = transactionList.parallelStream()
                .filter(transaction -> transaction.getStatus().equals("COMPLETED"))
                .collect(Collectors.toMap(Transaction::getCurrency, Transaction::getAmount, BigDecimal::add));

        System.out.println(results);//{USD=400, INR=500}

        // find the transaction with all status and total amount

        var collect = transactionList.stream()
                .collect(Collectors.groupingBy(Transaction::getStatus))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        val -> val.getValue().stream().map(Transaction::getAmount)
                                .reduce(new BigDecimal(0), BigDecimal::add)));
        System.out.println(collect);


    }
}
