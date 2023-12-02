package tech.veni.vshop.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.veni.vshop.service.ProductService;
import tech.veni.vshop.vo.Req4CreateProduct;

import java.util.ArrayList;
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

    @GetMapping("/banner")
    public HashMap<String, Object> banner(@Param("distributionSite") String distributionSite) {
        List<HashMap<String, Object>> banners = new ArrayList<>();
        // 模拟首页banner广告
        banners.add(new HashMap<String, Object>() {{
            put("id", 1);
            put("imgUrl", "https://images.eduego.com/Uploads/Images/Content/catid13/2017-01/031003001-b.jpg");
        }});

        banners.add(new HashMap<String, Object>() {{
            put("id", 2);
            put("imgUrl", "https://images.eduego.com/Uploads/Images/Content/catid13/2017-01/031003001-b.jpg");
        }});

        banners.add(new HashMap<String, Object>() {{
            put("id", 3);
            put("imgUrl", "https://images.eduego.com/Uploads/Images/Content/catid13/2017-01/031003001-b.jpg");
        }});

        banners.add(new HashMap<String, Object>() {{
            put("id", 4);
            put("imgUrl", "https://images.eduego.com/Uploads/Images/Content/catid13/2017-01/031003001-b.jpg");
        }});

        banners.add(new HashMap<String, Object>() {{
            put("id", 5);
            put("imgUrl", "https://images.eduego.com/Uploads/Images/Content/catid13/2017-01/031003001-b.jpg");
        }});

        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        res.put("data", banners);
        return res;
    }

    @GetMapping("/categories")
    public HashMap<String, Object> getCategories() {
        List<HashMap<String, Object>> categories = new ArrayList<>();
        categories.add(new HashMap<String, Object>() {{
            put("id", 1);
            put("name", "居家");
        }});
        categories.add(new HashMap<String, Object>() {{
            put("id", 2);
            put("name", "美食");
        }});
        categories.add(new HashMap<String, Object>() {{
            put("id", 3);
            put("name", "服饰");
        }});
        categories.add(new HashMap<String, Object>() {{
            put("id", 4);
            put("name", "母婴");
        }});
        categories.add(new HashMap<String, Object>() {{
            put("id", 5);
            put("name", "个护");
        }});
        categories.add(new HashMap<String, Object>() {{
            put("id", 6);
            put("name", "严选");
        }});
        categories.add(new HashMap<String, Object>() {{
            put("id", 7);
            put("name", "数码");
        }});
        categories.add(new HashMap<String, Object>() {{
            put("id", 8);
            put("name", "运动");
        }});
        categories.add(new HashMap<String, Object>() {{
            put("id", 9);
            put("name", "其他");
        }});
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        res.put("data", categories);
        return res;
    }
}
