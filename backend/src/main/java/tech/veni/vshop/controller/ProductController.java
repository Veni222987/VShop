package tech.veni.vshop.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.veni.vshop.dao.Product;
import tech.veni.vshop.service.ProductService;
import tech.veni.vshop.vo.Req4CreateProduct;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @PostMapping("/create")
    public HashMap<String, Object> create(@RequestBody Req4CreateProduct req4CreateProduct) {
        ProductService.createProduct(req4CreateProduct);
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        return res;
    }

    @GetMapping("/list")
    public HashMap<String, Object> list() {
        List<Product> products = ProductService.listProducts();
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        res.put("data", products);
        return res;
    }

    @GetMapping("/list/category")
    public HashMap<String, Object> listByCategory(@Param("category") String category) {
        List<Product> products = ProductService.listProducts(category);
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        res.put("data", products);
        return res;
    }

    @GetMapping("/detail/{pid}")
    public HashMap<String, Object> detail(@PathVariable String pid) {
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        res.put("data", ProductService.getProductDetail(pid));
        return res;
    }
}
