import { createRouter, createWebHistory } from 'vue-router'
import UserLayout from '@/views/UserLayout/index.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'User',
      component: UserLayout,
      children: [{
        path: '',
        component: () => import('@/views/Home/index.vue'),
        name: 'Home'
      }, {
        path: 'category/:id',
        component: () => import('@/views/Category/index.vue'),
        name: 'Category'
      }, {
        path: 'detail/:id',
        component: () => import('@/views/Detail/index.vue'),
        name: 'Detail'
      }, {
        path: 'pay',
        component: () => import('@/views/Pay/index.vue'),
        name: 'Pay'
      }, {
        path: 'member',
        component: () => import('@/views/Member/index.vue'),
        name: 'Member',
        children: [{
          path: '',
          component: () => import('@/views/Member/components/UserInfo.vue'),
          name: 'Info'
        },{
          path: 'order',
          component: () => import('@/views/Member/components/UserOrder.vue'),
          name: 'Order'
        }]
      }
      ]
    },
    {
      path: '/seller',
      name: 'Seller',
      component: () => import('@/views/SellerLayout/index.vue'),
      children: [{
        path: '',
        component: () => import('@/views/Product/index.vue'),
        name: 'Product'
      }, {
        path: 'sales',
        component: () => import('@/views/Sales/index.vue'),
        name: 'Sales'
      }]
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('@/views/Login/index.vue')
    },
    {
      path: '/register',
      name: 'Register',
      component: () => import('@/views/Register/index.vue')
    }
  ]
})

export default router
