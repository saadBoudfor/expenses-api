package fr.boudfor.app.web;

import fr.boudfor.app.domain.Expense;
import fr.boudfor.app.services.IExpenseServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sboudfor on 02/05/2019.
 * Expenses web services.
 */
@RestController
@RequestMapping("expenses")
@AllArgsConstructor
public class ExpensesController {
    private IExpenseServices _services;

    @GetMapping()
    public Expense[] findAll() {
        return this._services.findAll();
    }
}
