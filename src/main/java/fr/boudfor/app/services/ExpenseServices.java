package fr.boudfor.app.services;

import fr.boudfor.app.domain.Expense;
import fr.boudfor.app.persistences.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by sboudfor on 02/05/2019.
 */
@Component
@AllArgsConstructor
public class ExpenseServices implements IExpenseServices{
    private ExpenseRepository _repository;

    @Override
    public Expense[] findAll() {
        return this._repository.findAll().toArray(new Expense[0]);
    }
}
