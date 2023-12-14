<script setup>

</script>



<template>
  <div class="home-banner">
    <el-carousel height="500px">
      <el-carousel-item v-for="item in 4" :key="item">
        <img src="https://m.360buyimg.com/babel/jfs/t20261128/222983/15/34662/153923/65674d29Fea40e5c0/00f0a301be475d60.png" alt="">
      </el-carousel-item>
    </el-carousel>
  </div>
</template>



<style scoped lang='scss'>
.home-banner {
  width: 1240px;
  height: 500px;
  //position: absolute;
  //left: 0;
  //top: 0;
  //z-index: 98;

  img {
    width: 100%;
    height: 500px;
  }
}
</style>
