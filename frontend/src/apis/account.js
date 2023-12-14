import httpInstance from "@/utils/http";

// 用户注册
export const userRegisterApi=({username,email,password,avatar,gender})=>{
    return httpInstance({
        url:'/account/user/register',
        method:'post',
        data:{
            username,
            email,
            password,
            avatar,
            gender
        }
    })
}

// 顾客登录
export const userLoginApi=({email,password})=>{
    return httpInstance({
        url:'/account/user/login',
        method:'post',
        data:{
            email,
            password
        }
    })
}

// 商家注册
export const sellerRegisterApi=({name,email,password})=>{
    return httpInstance({
        url:'/account/seller/register',
        method:'post',
        data:{
            name,
            email,
            password,
        }
    })
}

// 商家登录
export const sellerLoginApi=({email,password})=>{
    return httpInstance({
        url:'/account/seller/login',
        method:'post',
        data:{
            email,
            password
        }
    })
}
