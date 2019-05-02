package fr.boudfor.app.persistences;

import fr.boudfor.app.domain.Expense;
import fr.boudfor.app.domain.ExpenseLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Observable;

@Component
public interface ExpenseLineRepository extends JpaRepository<ExpenseLine, Long>{
}