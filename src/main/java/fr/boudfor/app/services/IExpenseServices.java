package fr.boudfor.app.services;

import fr.boudfor.app.domain.Expense;

/**
 * Created by sboudfor on 02/05/2019.
 */
public interface IExpenseServices {
    public Expense[] findAll();
}
