package fr.boudfor.app.domain;

import fr.boudfor.app.domain.constants.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String[] notes;
    private String billUrl;
    private LocalDateTime date;
    private Payment[] payment;
    private Long price;
    private Category[] expenseCategories;
    private String userID;
    private ExpenseLine[] expenseLines;
    private Store store;
}