package fr.boudfor.app.services;

import fr.boudfor.app.domain.ExpenseLine;

/**
 * Created by sboudfor on 02/05/2019.
 */
public interface IExpenseLineService {
    public ExpenseLine[] findAll();
}
