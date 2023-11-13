import {createRouter, createWebHistory} from 'vue-router'
import Login from '@/views/Login/index.vue'
import Layout from '@/views/Layout/index.vue'
import Home from '@/views/Home/index.vue'
import Category from '@/views/Category/index.vue'
import SubCategory from '@/views/SubCategory/index.vue'
import Detail from '@/views/Detail/index.vue'
import CartList from '@/views/CartList/index.vue'
import Checkout from '@/views/Checkout/index.vue'
import Pay from '@/views/Pay/index.vue'
import PayBack from "@/views/Pay/PayBack.vue";
import Member from '@/views/Member/index.vue'
import UserInfo from "@/views/Member/components/UserInfo.vue";
import UserOrder from "@/views/Member/components/UserOrder.vue";

const router = createRouter({
    history: createWebHistory(
        import.meta.env.BASE_URL),
    //配置具体路由规则
    routes: [{
        path: '/',
        name: '首页',
        component: Layout,
        children: [{
            path: '',
            component: Home,
            name: 'Home页'
        }, {
            path: 'category/:id',
            component: Category,
            name: '分类页面'
        }, {
            path: 'category/sub/:id',
            component: SubCategory,
            name: '二级分类页面'
        }, {
            path: 'detail/:id',
            component: Detail,
            name: '商品详情'
        }, {
            path: 'cartlist',
            component: CartList,
            name: '购物车'
        }, {
            path: 'checkout',
            component: Checkout,
            name: '结算页面'
        }, {
            path: 'pay',
            component: Pay,
            name: '支付页面'
        }, {
            path: 'paycallback', // 注意路径，必须是paycallback
            component: PayBack,
            name: '支付结果回显'
        }, {
            path: '/member',
            component: Member,
            name: '个人中心',
            children: [
                {
                    path: '',
                    component: UserInfo,
                    name: '个人中心详情页'
                }, {
                    path:'order',
                    component:UserOrder,
                    name:'个人订单页'
                }
            ]
        }
        ]
    }, {
        path: '/login',
        name: '登录页',
        component: Login
    }],
    //路由行为滚动定制，切换页面，滚动条总在最上面
    scrollBehavior() {
        return {
            top: 0
        }
    }
})
export default router