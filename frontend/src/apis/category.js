import httpInstance from "@/utils/http";
export function getCategoryApi(id){
    var map={
        "1":"居家",
        "2":"美食",
        "3":"服饰",
        "4":"母婴",
        "5":"个护",
        "6":"严选",
        "7":"数码",
        "8":"运动",
        "9":"其他"
    }
    var category=map[id]
    return httpInstance({
        url:'/product/list/category',
        params:{
            category
        }
    })
}
/**
 * @description: 获取二级分类列表数据
 * @param {*} id 分类id
 * @return {*}
 */
export const getCategoryFilterAPI = (id) => {
    return httpInstance({
        url:'/category/sub/filter',
        params:{
            id
        }
    })
}
/**
 * @description: 获取导航数据
 * @data {
     categoryId: 1005000 ,
     page: 1,
     pageSize: 20,
     sortField: 'publishTime' | 'orderNum' | 'evaluateNum'
   }
 * @return {*}
 */
export const getSubCategoryAPI = (data) => {
    return httpInstance({
        url:'/category/goods/temporary',
        method:'POST',
        data
    })
}