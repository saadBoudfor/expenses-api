package fr.boudfor.app.web;

import fr.boudfor.app.domain.ExpenseLine;
import fr.boudfor.app.domain.Product;
import fr.boudfor.app.services.ExpenseLineService;
import fr.boudfor.app.services.IExpenseLineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sboudfor on 02/05/2019.
 */
@RestController
@RequestMapping("expenses/expenseLines")
@AllArgsConstructor
public class ExpensesLinesController {
    private IExpenseLineService _services;

    @GetMapping("/all")
    public ExpenseLine[] getAll() {
        return this._services.findAll();
    }

}
