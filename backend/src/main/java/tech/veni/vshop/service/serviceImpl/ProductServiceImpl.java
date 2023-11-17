package tech.veni.vshop.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.veni.vshop.dao.Item;
import tech.veni.vshop.dao.Product;
import tech.veni.vshop.dao.mapper.ItemMapper;
import tech.veni.vshop.dao.mapper.ProductMapper;
import tech.veni.vshop.service.ProductService;
import tech.veni.vshop.utils.IdUtils;
import tech.veni.vshop.vo.Req4CreateProduct;
import tech.veni.vshop.vo.Res2ProductDetail;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Transactional
    @Override
    public void createProduct(Req4CreateProduct req4CreateProduct) {
        // 插入Product
        Product product = new Product(
                null,
                IdUtils.generatePid().toString(),
                req4CreateProduct.getTitle(),
                req4CreateProduct.getCover(),
                req4CreateProduct.getSeller(),
                req4CreateProduct.getDetailUrl(),
                req4CreateProduct.getCategory(),
                req4CreateProduct.getPrice(),
                req4CreateProduct.getAttributes(),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis())
        );
        productMapper.insert(product);
        //将pid赋值给items
        for (Item item : req4CreateProduct.getItems()) {
            item.setPid(product.getPid());
            Timestamp now = new Timestamp(System.currentTimeMillis());
            item.setCreateTime(now);
            item.setUpdateTime(now);
        }

        // 插入Item
        itemMapper.insertBatch(req4CreateProduct.getItems());
    }

    @Override
    public List<Product> listProducts() {
        return productMapper.listProducts();
    }

    @Override
    public List<Product> listProducts(String category) {
        return productMapper.listProductsByCategory(category);
    }

    @Override
    public Res2ProductDetail getProductDetail(String pid) {
        Product product = productMapper.getProductByPid(pid);
        List<Item> items = itemMapper.listItemsByPid(pid);
        Res2ProductDetail res2ProductDetail = new Res2ProductDetail(
                product.getPid(),
                product.getTitle(),
                product.getCover(),
                product.getSeller(),
                product.getDetailUrl(),
                product.getCategory(),
                product.getPrice(),
                product.getAttributes(),
                items
        );
        return res2ProductDetail;
    }
}
