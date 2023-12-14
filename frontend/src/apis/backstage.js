import httpInstance from "@/utils/http";


/**
 * 新增商品
 * @returns {*}
 */

export function addGoodsApi({ title, coverUrl, detailUrl, shopId, category, price, stock }) {
    return httpInstance({
        url: '/backstage/goods/add',
        method: 'post',
        data: {
            title,
            coverUrl,
            detailUrl,
            shopId,
            category,
            price,
            stock
        }
    })
}

/**
 * 修改商品
 * @returns {*}
 */

export function updateGoodsApi({ id, title, coverUrl, detailUrl, shopId, category, price, stock }) {
    return httpInstance({
        url: '/backstage/goods/update',
        method: 'put',
        data: {
            id,
            title,
            coverUrl,
            detailUrl,
            shopId,
            category,
            price,
            stock
        }
    })
}


/**
 * 删除商品
 * @returns {*}
 */

export function deleteGoodsApi({ goodsId }) {
    return httpInstance({
        url: `/backstage/goods/delete`,
        method: 'delete',
        params: {
            goodsId
        }
    })
}


/**
 * 查询商家的所有商品
 * @returns {*}
 */

export function getAllGoodsApi({ sid }) {
    return httpInstance({
        url: `/backstage/goods/list/${sid}`
    })
}

/**
 * 查询某个商店的销售数据
 * @returns {*}
 */

export function getSaleDataApi({ sid }) {
    return httpInstance({
        url: `/backstage/shop/sales/${sid}`
    })
}

/**
 * 查询某个商品的销售数据
 * @returns {*}
 */

export function getGoodsSaleDataApi({ goodsId }) {
    return httpInstance({
        url: `/backstage/goods/sales/${goodsId}`
    })
}
