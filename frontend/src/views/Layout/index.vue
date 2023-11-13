<script setup>
import LayoutNav from './components/LayoutNav.vue'
import LayoutHeader from './components/LayoutHeader.vue'
import LayoutFooter from './components/LayoutFooter.vue'
import LayoutFixed from "@/views/Layout/components/LayoutFixed.vue";
import {useCategoryStore} from "@/views/Layout/components/category";
import {onMounted} from "vue";
const categoryStore = useCategoryStore();
onMounted(()=>categoryStore.getCategoryData())
</script>

<template>
  <LayoutFixed/>
  <LayoutNav />
  <LayoutHeader />
  <!--解决路由缓存问题方案1：添加key，值为$route.fullPath，破坏复用机制，强制销毁重建
  缺点：太粗暴，会将整个实例销毁重建，发送所有请求，不建议使用
  -->
  <!--<RouterView :key="$route.fullPath"/>-->
  <RouterView />
  <LayoutFooter />
</template>