//管理用户相关数据
import {defineStore} from "pinia";
import {ref} from "vue";
// import {useCartStore} from "@/stores/cartStore";
import {userLoginApi, userRegisterApi} from "@/apis/account";
import {useCartStore} from "@/stores/cartStore";

export const useUserStore=defineStore('user',()=>{
    const userInfo=ref({});

    // 用户注册
    const userRegister=async ({username,email,password,avatar,gender})=>{
        const res=await userRegisterApi({username,email,password,avatar,gender});
        userInfo.value= {
            id:res.data.uid,
            username,
            email,
            password,
            avatar,
            gender
        }
    }
    const userLogin=async ({email,password})=>{
        console.log(email)
        const res=await userLoginApi({email,password});
        userInfo.value=res.data;
        //合并购物车
    }
    //退出登录函数,清除用户信息
    const clearUserInfo=()=>{
        userInfo.value={};
        useCartStore().clearCart();
    }
    return{
        userInfo,
        userRegister,
        userLogin,
        clearUserInfo
    }
},{
    //数据持久化
    persist:true
})
