import httpInstance from "@/utils/http";

/**
 * 获取Banner
 * @returns {*}
 */
export function getHomBannerApi(params = {}) {
    //定义默认值
    const { distributionSite = '1' } = params
    return httpInstance({
        url: '/product/banner',
        params: {
            distributionSite
        }
    })
}

/**
 * 首页获取商品
 * @returns {*}
 */

export function getHomeGoodsApi({page,size}) {
    return httpInstance({
        url: '/shopping/home',
        params: {
            page,
            size
        }
    })
}


/**
 * 获取分类商品
 * @returns {*}
 */

export function getCategoryGoodsApi({category}) {
    return httpInstance({
        url: `/shopping/category/${category}`
    })
}

/**
 * 获取商品详情
 * @returns {*}
 */

export function getGoodsDetailApi({goods_id}) {
    return httpInstance({
        url: `/shopping/detail/${goods_id}`
    })
}

/**
 * 加购物车
 * @returns {*}
 */

export function addCartApi({uid,goodsId,count,sum}) {
    return httpInstance({
        url: `/shopping/add_cart`,
        method:'post',
        data:{
            uid,
            goodsId,
            count,
            sum
        }
    })
}

/**
 * 获取购物车商品
 */

export function getCartApi({uid}) {
    return httpInstance({
        url: `/shopping/cart/${uid}`
    })
}

/**
 * 结算购物车商品
 * @returns {*}
 */

export function settleCartApi({uid,carts,addressId}) {
    return httpInstance({
        url: `/shopping/settle`,
        method:'post',
        data:{
            uid,
            carts,
            addressId
        }
    })
}

/**
 * 客户付款
 * @returns {*}
 */

export function payApi({orders}) {
    return httpInstance({
        url: `/shopping/pay`,
        method:'post',
        data: orders
    })
}

/**
 * 添加收货地址
 * @returns {*}
 */

export function addAddressApi({uid,addressName,address,receiver,phoneNumber,email}) {
    return httpInstance({
        url: `/shopping/add_address`,
        method: 'post',
        data: {
            uid,
            addressName,
            address,
            receiver,
            phoneNumber,
            email
        }
    })
}

/**
 * 获取某人所有收货地址
 * @returns {*}
 */

export function getAddressApi({uid}) {
    return httpInstance({
        url: `/shopping/address/${uid}`
    })
}

/**
 * 获取客户购买记录
 * @returns {*}
 */

export function getOrdersApi({uid}) {
    return httpInstance({
        url: `/shopping/history`,
        params: {
            uid
        }
    })
}

/**
 * 增加浏览历史
 * @returns {*}
 */

export function addHistoryApi({uid,goodsId}) {
    return httpInstance({
        url: `/shopping/add_browse_history`,
        method: 'post',
        data: {
            uid,
            goodsId
        }
    })
}

/**
 * 查询浏览历史
 * @returns {*}
 */

export function getHistoryApi({uid}) {
    return httpInstance({
        url: `/shopping/browse_history`,
        params: {
            uid
        }
    })
}
