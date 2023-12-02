import httpInstance from "@/utils/http";

export const loginApi=({account,password})=>{
    return httpInstance({
        url:'/user/login',
        method:'get',
        params:{
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