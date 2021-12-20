package de.htwberlin.webtech.webtech.repository;

import de.htwberlin.webtech.webtech.persistence.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    //List<CategoryEntity> findAllByCategoryName(String categoryName);

}
