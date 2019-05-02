package fr.boudfor.app.domain;


import com.sun.istack.internal.NotNull;
import fr.boudfor.app.domain.constants.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ExpenseLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Product product;
    private Double price;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private String[] notes;
}