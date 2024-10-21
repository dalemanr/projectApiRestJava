package com.david.apirest.projectapirest.Controllers;

import com.david.apirest.projectapirest.Entities.Product;
import com.david.apirest.projectapirest.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id)
    {
        return productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el producto con el ID:" + id));
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product)
    {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product)
    {
        Product productFind = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el producto con el ID:" + id));

        productFind.setName(product.getName());
        productFind.setPrice(product.getPrice());

        return productRepository.save(productFind);
    }

    @DeleteMapping("/{id}")
    public String DeleteProduct(@PathVariable Long id)
    {
        Product productFind = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontró el producto con el ID:" + id));

        productRepository.delete(productFind);
        return "Producto con el id: " + id + " fue eliminado correctamente" ;
    }
}
