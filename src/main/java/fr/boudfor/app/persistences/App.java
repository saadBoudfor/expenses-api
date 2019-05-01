package fr.boudfor.app.persistences;

import fr.boudfor.app.domain.*;
import fr.boudfor.app.domain.constants.Currency;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class App implements CommandLineRunner {

    private ProductRepository productRepository;
    private CategoryRepository productCategoryRepository;
    private ExpenseLineRepository expenseLineRepository;
    private StoreRepository storeRepository;
    private ExpenseRepository expenseRepository;

    @Override
    public void run(String... strings) throws Exception {
        Category software = this.productCategoryRepository.save(Category.builder().name("Logicielss").build());

        Product product = this.productRepository
                .save(Product
                .builder()
                .name("Affinity Designer")
                .description("Logiciel de design pour maquettage mobile et web")
                .category(new Category[]{software})
                .build());

        ExpenseLine expenseLine = this.expenseLineRepository
                .save(ExpenseLine
                        .builder()
                        .price(69.88)
                        .product(product)
                        .currency(Currency.EURO)
                        .build());

        Store store = this.storeRepository
                .save(Store
                        .builder()
                        .name("Affinity Designer corporation")
                        .webSite("http://www.web-designer.com")
                        .build());

        this.expenseRepository
                .save(Expense
                        .builder()
                        .name("Achat outil maquettage")
                        .date(LocalDateTime.now())
                        .store(store)
                        .userID("12DL99A")
                        .expenseLines(new ExpenseLine[]{expenseLine})
                        .build());

    }
}