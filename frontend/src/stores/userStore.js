//管理用户相关数据
import {defineStore} from "pinia";
import {ref} from "vue";
import {loginApi} from "@/apis/user";
import {useCartStore} from "@/stores/cartStore";

export const useUserStore=defineStore('user',()=>{
    const userInfo=ref({});
    const getUserInfo=async ({account,password})=>{
        const res=await loginApi({account,password});
        userInfo.value=res.result;
        //合并购物车
        /*await mergeCartApi(useCartStore().cartList.map(item=>{
            return{
                skuId:item.skuId,
                selected:item.selected,
                count:item.count
            }
        }))
        await useCartStore().updateCart()*/
    }
    //退出登录函数,清除用户信息
    const clearUserInfo=()=>{
        userInfo.value={};
        useCartStore().clearCart();
    }
    return{
        userInfo,
        getUserInfo,
        clearUserInfo
    }
},{
    //数据持久化
    persist:true
})