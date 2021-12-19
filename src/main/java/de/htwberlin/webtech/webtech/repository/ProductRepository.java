package de.htwberlin.webtech.webtech.repository;

import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByProductName(String productName);


}
