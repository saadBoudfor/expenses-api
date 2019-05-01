package fr.boudfor.app.persistences;

import fr.boudfor.app.domain.Product;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Product product1111 = Product.builder().name("Banana").build();
        entityManager.persist(product1111);
        entityManager.flush();

        // when
        Product[] found = productRepository.findByName(product1111.getName());

        // then
        assertThat(found.length != 0).isEqualTo(true);
    }
}