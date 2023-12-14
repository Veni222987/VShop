//管理商家相关数据
import {defineStore} from "pinia";
import {ref} from "vue";
import {sellerLoginApi, sellerRegisterApi} from "@/apis/account";

export const useSellerStore=defineStore('seller',()=>{
    const sellerInfo=ref({});

    // 用户注册
    const sellerRegister=async ({name,email,password})=>{
        const res=await sellerRegisterApi({name,email,password});
        sellerInfo.value= {
            id:res.data.sid,
            name,
            email,
            password,
        };
    }
    const sellerLogin=async ({email,password})=>{
        const res=await sellerLoginApi({email,password});
        sellerInfo.value=res.data;
        //合并购物车
    }
    //退出登录函数,清除用户信息
    const clearSellerInfo=()=>{
        sellerInfo.value={};
        // useCartStore().clearCart();
    }
    return{
        sellerInfo,
        sellerRegister,
        sellerLogin,
        clearSellerInfo
    }
},{
    //数据持久化
    persist:true
})
