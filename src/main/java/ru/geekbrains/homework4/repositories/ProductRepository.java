package ru.geekbrains.homework4.repositories;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.geekbrains.homework4.entities.Product;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class ProductRepository implements AbstractRepository<Product, Long> {

	private final CopyOnWriteArrayList<Product> productList = new CopyOnWriteArrayList<>();

	@Override
	public List<Product> findAll() {
		return productList.stream()
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long id) {
		productList.removeIf(p -> id.equals(p.getId()));
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productList.stream().filter(pr->pr.getId()==id).findFirst();
	}

	@Override
	public void add(Product product) {
		productList.add(product);
	}

	@PostConstruct
	public void init() throws Exception {

		log.info("Log: Product list init");
		long id = 0L;
		productList.add(new Product(id++,"Apple",10));
		productList.add(new Product(id++,"Watermelon",8));
		productList.add(new Product(id++,"Banana",6));
		productList.add(new Product(id++,"Orange",12));
		productList.add(new Product(id++,"Lemon",13));
		productList.add(new Product(id++,"Dragon fruit",20));
		productList.add(new Product(id++,"Blueberries",15));
		productList.add(new Product(id++,"Raspberry",21));
		productList.add(new Product(id++,"Strawberry",18));
		productList.add(new Product(id++,"Blackberry",17));
	}
}
