package fr.boudfor.app.persistences;

import fr.boudfor.app.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}