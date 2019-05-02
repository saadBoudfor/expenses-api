package fr.boudfor.app.persistences;

import fr.boudfor.app.domain.*;
import fr.boudfor.app.domain.constants.Currency;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.PrimitiveIterator;

@Component
@AllArgsConstructor
public class App implements CommandLineRunner {

    private ProductRepository productRepository;
    private CategoryRepository productCategoryRepository;
    private ExpenseLineRepository expenseLineRepository;
    private StoreRepository storeRepository;
    private ExpenseRepository expenseRepository;
    private static int MAX = 124;
    private static int MIN = 49;

    @Override
    public void run(String... strings) throws Exception {

        String[] categoriesList = new String[]{"Software", "food", "books", "tools"};
        double[] pricesList = new double[]{66.6, 89.21, 16.99, 56.33, 77.5, 96.3};

        for (int i = MIN; i < MAX; i++) {
            Category software = this._createSimpleCategory(categoriesList[i % categoriesList.length]);
            Product product = this._createSimpleProduct(software, i);
            ExpenseLine expenseLine = this._createSimpleExpenseLine(product, pricesList[i% pricesList.length]);
        }

//        Store store = this.storeRepository
//                .save(Store
//                        .builder()
//                        .name("Affinity Designer corporation")
//                        .webSite("http://www.web-designer.com")
//                        .build());
//
//        this.expenseRepository
//                .save(Expense
//                        .builder()
//                        .name("Achat outil maquettage")
//                        .date(LocalDateTime.now())
//                        .store(store)
//                        .userID("12DL99A")
//                        .expenseLines(new ExpenseLine[]{expenseLine})
//                        .build());

    }

    private Product _createSimpleProduct(Category category, int number) {
        return this.productRepository
                .save(Product
                        .builder()
                        .name("Product  number " + number)
                        .description("Testing product API, product: " + number)
                        .category(new Category[]{category})
                        .build());
    }

    private Category _createSimpleCategory(String categoryName) {
        return this
                .productCategoryRepository
                .save(Category
                        .builder()
                        .name(categoryName)
                        .description("Full description  for category: " + categoryName)
                        .build());
    }

    private ExpenseLine _createSimpleExpenseLine(Product product, double price) {
        return this.expenseLineRepository
                .save(ExpenseLine
                        .builder()
                        .price(price)
                        .product(product)
                        .currency(Currency.EURO)
                        .build());
    }
}