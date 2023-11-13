//购物车
import httpInstance from "@/utils/http";
//加入购物车
export const insertCartApi=({skuId,count})=>{
    return httpInstance({
        url:'member/cart',
        method:"post",
        data:{
            skuId,
            count
        }
    })
}
//获取最新购物车列表
export const findNewCartListApi=()=>{
    return httpInstance({
        url:'member/cart'
    })
}
//删除购物车商品
export const delCartApi=(ids)=>{
    return httpInstance({
        url:'member/cart',
        method:"delete",
        data:{
            ids
        }
    })
}
//合并本地购物车到服务器
export const mergeCartApi=(data)=>{
    return httpInstance({
        url:'member/cart',
        method:"post",
        data
    })
}