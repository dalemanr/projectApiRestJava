package com.david.apirest.projectapirest.Repositories;

import com.david.apirest.projectapirest.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
