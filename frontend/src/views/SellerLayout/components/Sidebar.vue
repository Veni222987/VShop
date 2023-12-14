<script setup>
import {
  Document,
  Menu as IconMenu,
} from "@element-plus/icons-vue";

const handleOpen = (key, keyPath) => {
  console.log(key, keyPath)
}
const handleClose = (key, keyPath) => {
  console.log(key, keyPath)
}


</script>

<template>
  <div class="sidebar">
    <div class="logo">VShop</div>
    <el-menu
        default-active="1"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
    >
      <el-menu-item index="1" @click="$router.push(`/seller`)">
        <el-icon><icon-menu /></el-icon>
        <a>商品详情</a>
      </el-menu-item>
      <el-menu-item index="2" @click="$router.push(`/seller/sales`)">
        <el-icon><document /></el-icon>
        <a>销售数据</a>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<style scoped lang="scss">
.sidebar {
  width: 10vw;
  height: 100vh;
  background: $themeColor;

  .logo {
    height: 10vh;
    color: white;
    font-size: 32px;
    font-weight: bold;
    padding: 1rem;
    text-align: center;
  }

  .el-menu-vertical-demo {
    height: 90vh;
    background: $themeColor;

    .el-menu-item {
      color: white;
      font-size: 16px;
      font-weight: bold;
      padding: 1rem;
      text-align: center;

      &.is-active {
        background: #218a74;
      }

      a {
        color: white;
      }

      &:hover {
        background: #218a74;
      }
    }
  }
}
</style>
