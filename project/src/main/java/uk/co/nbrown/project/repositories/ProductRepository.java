package uk.co.nbrown.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.co.nbrown.project.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {  
	List<Product> findById(int id);
}