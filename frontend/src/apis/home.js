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
 * @description: 获取新鲜好物
 */
export const findNewAPI = () => {
    return httpInstance({
        url: '/product/list'
    })
}