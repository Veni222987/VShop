//购物车逻辑
import {defineStore} from "pinia";
import {computed, ref} from "vue";
import {useUserStore} from "@/stores/userStore";
import {delCartApi, findNewCartListApi, insertCartApi} from "@/apis/cart";

export const useCartStore = defineStore('cart', () => {
    const userStore=useUserStore();

    //isLogin是一个布尔值
    const isLogin=computed(()=>userStore.userInfo.token)
    //定义购物车列表
    const cartList = ref([]);
    //获取最新购物车数据
    const updateCart=async ()=>{
        const res=await findNewCartListApi();
        clearCart();
        res.result.forEach((item)=>{
            cartList.value.push(item)
        })

    }
    const addCart =async (goods) => {
        if (isLogin.value){
            const {skuId,count}=goods;
            await insertCartApi({skuId,count});
            updateCart()
        }else {
            const item = cartList.value.find((item) => goods.skuId === item.skuId);
            if (item) {
                //在购物车中找到相同的，只需要数量加1
                item.count++;
            } else {
                //没找到，新增
                cartList.value.push(goods);
            }
        }

    };
    //清空购物车
    const clearCart=()=>{
        cartList.value=[]
    }
    //删除购物车中的单个或多个商品
    const deleteCart =async (skuId) => {
        if (isLogin.value){
            //调用接口
           await delCartApi([skuId]);
            updateCart();
        }else {
            const index = cartList.value.findIndex((item) => skuId === item.skuId);
            //删除
            cartList.value.splice(index, 1)
        }
    };
    // 1. 总的数量 所有项的count之和
    const allCount = computed(() => cartList.value.reduce((a, c) => a + c.count, 0))
    // 2. 总价 所有项的count*price之和
    const allPrice = computed(() => cartList.value.reduce((a, c) => a + c.count * c.price, 0))
    //单选框功能
    const singleCheck = (skuId, selected) => {
        const item = cartList.value.find((item) => skuId === item.skuId);
        item.selected = selected;
    }
    // 全选功能
    const allCheck = (selected) => {
        // 把cartList中的每一项的selected都设置为当前的全选框状态
        cartList.value.forEach(item => item.selected = selected)
    }
    //是否全选
    const isAll = computed(() => cartList.value.every((item) => item.selected))
    // 3. 已选择数量
    const selectedCount = computed(
        () => cartList.value.filter(item => item.selected).reduce(
            (a, c) => a + c.count, 0))
    // 4. 已选择商品价钱合计
    const selectedPrice = computed(
        () => cartList.value.filter(item => item.selected).reduce(
            (a, c) => a + c.count * c.price, 0))

    return {
        cartList,
        addCart,
        deleteCart,
        allCount,
        allPrice,
        singleCheck,
        isAll,
        allCheck,
        selectedCount,
        selectedPrice,
        clearCart,
        updateCart,
    }
}, {
    //数据存储在浏览器存储，保证刷新不丢失
    persist: true
})