import httpInstance from "@/utils/http";

/**
 * 获取Banner
 * @returns {*}
 */
export function getHomBannerApi(params={}) {
    //定义默认值
    const {distributionSite='1'}=params
    return httpInstance({
        url:'/home/banner',
        params:{
            distributionSite
        }
    })
}
/**
 * @description: 获取新鲜好物
 */
export const findNewAPI = () => {
    return httpInstance({
        url:'/home/new'
    })
}
/**
 * @description: 获取人气推荐
 * @return {*}
 */
export const getHotAPI = () => {
    return httpInstance({
        url: '/home/hot'
    })
}
/**
 * @description: 获取所有商品模块
 * @return {*}
 */
export const getGoodsAPI = () => {
    return httpInstance({
        url: '/home/goods'
    })
}