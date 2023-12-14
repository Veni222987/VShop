<script setup>
import { onMounted } from 'vue'
import { ref } from 'vue'
import GoodsItem from "@/views/Home/components/GoodsItem.vue";
import {getHomeGoodsApi} from "@/apis/shopping";
const goodsProduct = ref([])
const getGoods = async () => {
  let page = 1,size = 10
  const { data } = await getHomeGoodsApi({page,size})
  goodsProduct.value = data
}
onMounted( ()=> getGoods() )
</script>

<template>
  <div class="home-product">
    <div class="home-panel">
      <div class="container">
        <div class="head">
          <!-- 主标题和副标题 -->
          <h3>
            产品列表
          </h3>
        </div>
        <!-- 主体内容区域 -->
        <div class="box">
          <RouterLink class="cover" to="/">
<!--            <img v-img-lazy="cate.picture" />-->
<!--            <strong class="label">-->
<!--              <span>{{ cate.name }}馆</span>-->
<!--              <span>{{ cate.saleInfo }}</span>-->
<!--            </strong>-->
          </RouterLink>
          <ul class="goods-list">
            <GoodsItem v-for="goods in goodsProduct" :key="goods.id" :goods="goods" />
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang='scss'>
.home-panel {
  background-color: #fff;

  .head {
    padding: 40px 0;
    display: flex;
    align-items: flex-end;

    h3 {
      flex: 1;
      font-size: 32px;
      font-weight: normal;
      margin-left: 6px;
      height: 35px;
      line-height: 35px;

      small {
        font-size: 16px;
        color: #999;
        margin-left: 20px;
      }
    }
  }

  .box {
    width: 100%;

    .goods-list {
      display: flex;
      flex-wrap: wrap;
    }
  }
}
</style>
