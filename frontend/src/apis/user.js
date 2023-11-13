import httpInstance from "@/utils/http";

export const loginApi=({account,password})=>{
    return httpInstance({
        url:'/login',
        method:'post',
        data:{
            account,
            password
        }
    })
}
//个人中心页面的推荐列表
export const getLikeListAPI = ({ limit = 4 }) => {
    return httpInstance({
        url:'/goods/relevant',
        params: {
            limit
        }
    })
}