<script setup>
import { computed } from 'vue'
import { addHistoryApi } from "@/apis/shopping";
import {useUserStore} from "@/stores/userStore";

const props = defineProps({
  goods: {
    type: Object,
    default: () => ({})
  }
})

const link = computed(() => {
  return {
    path: `/detail/${props.goods.goodsId}`
  }
})

// 添加浏览历史
const addHistory = () => {
  addHistoryApi({
    uid: useUserStore().userInfo.uid,
    goodsId: props.goods.goodsId
  })
}
</script>
<template>
  <RouterLink :to=link @click="addHistory" class="goods-item">
    <img v-img-lazy="goods.coverUrl" alt="" />
    <p class="name ellipsis">{{ goods.title }}</p>
<!--    <p class="desc ellipsis">{{ goods.desc }}</p>-->
    <p class="price">&yen;{{ goods.price }}</p>
  </RouterLink>
</template>
<style lang="scss">
.goods-item {
  display: block;
  width: 220px;
  padding: 20px 30px;
  text-align: center;
  transition: all .5s;

  &:hover {
    transform: translate3d(0, -3px, 0);
    box-shadow: 0 3px 8px rgb(0 0 0 / 20%);
  }

  img {
    width: 160px;
    height: 160px;
  }

  p {
    padding-top: 10px;
  }

  .name {
    font-size: 16px;
  }

  .desc {
    color: #999;
    height: 29px;
  }

  .price {
    color: $priceColor;
    font-size: 20px;
  }
}
</style>
