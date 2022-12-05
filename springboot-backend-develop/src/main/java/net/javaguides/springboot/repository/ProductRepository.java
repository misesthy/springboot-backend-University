package net.javaguides.springboot.repository;

import net.javaguides.springboot.enties.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
