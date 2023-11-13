import httpInstance from "@/utils/http";

export const getOrderApi=(id)=>{
    return httpInstance({
        url:`/member/order/${id}`,
    })
}