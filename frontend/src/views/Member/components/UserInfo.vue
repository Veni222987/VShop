<script setup>
import GoodsItem from '@/views/Home/components/GoodsItem.vue'
import {useUserStore} from "@/stores/userStore";
import {onMounted, ref} from 'vue'
import {getHistoryApi} from "@/apis/shopping";

const userStore = useUserStore()
// 获取浏览历史列表
const historyList = ref([])

const goodsList = ref([])
const getHistoryList = async () => {
  const uid = userStore.userInfo?.uid
  const res = await getHistoryApi({uid})
  historyList.value = res.data
  console.log(historyList.value)
  // 提取historyList中的goods信息并合并数组，goods不能为null
  historyList.value.forEach(item => {
    if (item.goods) {
      goodsList.value.push(item.goods)
    }
  })
  goodsList.value.reverse()
}
onMounted(() => getHistoryList())
</script>

<template>
  <div class="home-overview">
    <!-- 用户信息 -->
    <div class="user-meta">
      <div class="avatar">
        <img :src="userStore.userInfo?.avatar" />
      </div>
      <h4>{{ userStore.userInfo?.account }}</h4>
    </div>
  </div>
  <div class="like-container">
    <div class="home-panel">
      <div class="header">
        <h4 data-v-bcb266e0="">浏览历史</h4>
      </div>
      <div class="goods-list">
        <GoodsItem v-for="goods in goodsList" :key="goods?.id" :goods="goods" />
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.home-overview {
  height: 132px;
  background: $themeColor;
  display: flex;

  .user-meta {
    flex: 1;
    display: flex;
    align-items: center;

    .avatar {
      width: 85px;
      height: 85px;
      border-radius: 50%;
      overflow: hidden;
      margin-left: 60px;

      img {
        width: 100%;
        height: 100%;
      }
    }

    h4 {
      padding-left: 26px;
      font-size: 18px;
      font-weight: normal;
      color: white;
    }
  }
}

.like-container {
  margin-top: 20px;
  border-radius: 4px;
  background-color: #fff;
}

.home-panel {
  background-color: #fff;
  padding: 0 20px;
  margin-top: 20px;
  height: 400px;

  .header {
    height: 66px;
    border-bottom: 1px solid #f5f5f5;
    padding: 18px 0;
    display: flex;
    justify-content: space-between;
    align-items: baseline;

    h4 {
      font-size: 22px;
      font-weight: 400;
    }

  }

  .goods-list {
    width: 100%;
    height: 80%;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    overflow-y: scroll;
  }
}
</style>
