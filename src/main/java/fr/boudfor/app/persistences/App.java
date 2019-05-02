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
    private static int MAX = 124;
    private static int MIN = 49;

    @Override
    public void run(String... strings) throws Exception {

        String[] categoriesList = new String[]{"Software", "food", "books", "tools"};
        String[] storeName = new String[]{"auChamps", "leclerc", "monoprix", "macro"};
        double[] pricesList = new double[]{66.6, 89.21, 16.99, 56.33, 77.5, 96.3};

        for (int i = MIN; i < MAX; i++) {
            Category category = this._createSimpleCategory(categoriesList[i % categoriesList.length]);
            Product product = this._createSimpleProduct(category, i);
            ExpenseLine expenseLine = this._createSimpleExpenseLine(product, pricesList[i % pricesList.length]);
            Store store = this._createSimpleStore(storeName[i % storeName.length]);
            this._createSimpleExpense(new ExpenseLine[]{expenseLine}, "ID45" + i + "45", store, category.getName());
        }
    }

    private Expense _createSimpleExpense(ExpenseLine[] expenseLines, String userID, Store store, String category) {
        return this.expenseRepository
                .save(Expense
                        .builder()
                        .name("Achat " + category)
                        .date(LocalDateTime.now())
                        .store(store)
                        .userID(userID)
                        .expenseLines(expenseLines)
                        .build());
    }

    private Store _createSimpleStore(String storeName) {
        return this.storeRepository
                .save(Store
                        .builder()
                        .name(storeName + " corporation")
                        .webSite("http://www." + storeName + ".com")
                        .build());
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