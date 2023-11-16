package tech.veni.vshop.service;

import tech.veni.vshop.dao.Product;
import tech.veni.vshop.vo.Req4CreateProduct;
import tech.veni.vshop.vo.Res2ProductDetail;

import java.util.List;

public interface ProductService {

    /**
     * 创建商品
     *
     * @param req4CreateProduct
     * @return void
     */
    void createProduct(Req4CreateProduct req4CreateProduct);

    /**
     * 获取商品列表
     *
     * @return
     */
    List<Product> listProducts();

    /**
     * 获取分类商品列表
     *
     * @param category
     * @return
     */
    List<Product> listProducts(String category);

    /**
     * 获取商品详情
     *
     * @param pid
     * @return
     */
    public Res2ProductDetail getProductDetail(String pid);

}
