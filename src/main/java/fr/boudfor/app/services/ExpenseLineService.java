package fr.boudfor.app.services;

import fr.boudfor.app.domain.ExpenseLine;
import fr.boudfor.app.persistences.ExpenseLineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by sboudfor on 02/05/2019.
 */
@Component
@AllArgsConstructor
public class ExpenseLineService implements IExpenseLineService {
    private ExpenseLineRepository _repository;

    @Override
    public ExpenseLine[] findAll() {
        return this._repository.findAll().toArray(new ExpenseLine[0]);
    }
}
