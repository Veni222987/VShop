import httpInstance from "@/utils/http";

//获取订单详情
export const getOrderInfoApi=()=>{
    return httpInstance({
        url:'/member/order/pre'
    })
}
//创建订单
export const createOrderApi=(data)=>{
    return httpInstance({
        url:'/member/order',
        method:"POST",
        data
    })
}