//购物车逻辑
import {defineStore} from "pinia";
import {computed, ref} from "vue";
import {useUserStore} from "@/stores/userStore";
import {addCartApi, getCartApi, settleCartApi} from "@/apis/shopping";

export const useCartStore = defineStore('cart', () => {
    const userStore=useUserStore();

    //isLogin是一个布尔值
    const isLogin=computed(()=>userStore.userInfo)
    //定义购物车列表
    const cartList = ref([]);
    //获取最新购物车数据
    const updateCart=async ()=>{
        const res=await getCartApi({uid:userStore.userInfo.uid});
        clearCart();
        // 更新购物车列表，商品相同则合并
        res.data.forEach((item) => {
            const goods = cartList.value.find((goods) => goods.goodsId === item.goodsId);
            if (goods) {
                goods.count += item.count;
            } else {
                cartList.value.push(item);
            }
        });
    }
    const addCart =async (goods) => {
        if (isLogin.value){
            const {uid}=userStore.userInfo;
            const {goodsId, count, price}=goods;
            const sum = count * price;
            await addCartApi({uid, goodsId, count, sum});
            await updateCart()
        }else {
            const item = cartList.value.find((item) => goods.goodsId === item.goodsId);
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
    // 1. 总的数量 所有项的count之和
    const allCount = computed(() => cartList.value.reduce((a, c) => a + c.count, 0))
    // 2. 总价 所有项的count*price之和
    const allPrice = computed(() => cartList.value.reduce((a, c) => a + c.count * c.price, 0))
    //单选框功能
    const singleCheck = (goodsId, selected) => {
        const item = cartList.value.find((item) => goodsId === item.goodsId);
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
