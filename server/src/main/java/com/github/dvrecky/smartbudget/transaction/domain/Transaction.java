package com.github.dvrecky.smartbudget.transaction.domain;

import com.github.dvrecky.smartbudget.account.domain.Account;
import com.github.dvrecky.smartbudget.category.domain.Category;
import com.github.dvrecky.smartbudget.recurring_transaction.domain.RecurringTransaction;
import com.github.dvrecky.smartbudget.transaction_common.domain.TransactionType;
import com.github.dvrecky.smartbudget.transaction_receipts.domain.TransactionPhoto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter@Setter
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", precision = 19, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "description")
    private String description;

    @Column(name = "transaction_date", nullable = false, updatable = false)
    private LocalDateTime transactionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recurring_transaction_id")
    private RecurringTransaction recurringTransaction;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "photo_id")
    private TransactionPhoto transactionPhoto;

    public Transaction(BigDecimal amount, String title, TransactionType type, String description, LocalDateTime transactionDate) {
        this.amount = amount;
        this.title = title;
        this.type = type;
        this.description = description;
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
