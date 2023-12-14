<script setup>

// tab列表
import {onMounted, ref} from "vue";
import {getOrdersApi} from "@/apis/shopping";
import {useUserStore} from "@/stores/userStore";
// 订单列表
const orderList = ref([])

const goodsList = ref([])

const userStore = useUserStore()

const getOrderList = async () => {
  const uid = userStore.userInfo?.uid
  const res = await getOrdersApi({uid})
  orderList.value = res.data
  // 提取orderList中的goods信息并合并数组，goods不能为null
  orderList.value.forEach(item => {
    if (item.goods) {
      goodsList.value.push(item.goods)
    }
  })
}
onMounted(() => getOrderList())
</script>

<template>
  <div class="order-container">
    <div class="main-container">
      <div class="holder-container" v-if="orderList.length === 0">
        <el-empty description="暂无订单数据" />
      </div>
      <div class="order-container" v-else>
        <!-- 订单列表 -->
        <div class="order-item" v-for="(order, i) in goodsList" :key="order.id">
          <div class="head">
            <span>下单时间：{{ order.createTime }}</span>
            <span>订单编号：{{ order.id }}</span>
          </div>
          <div class="body">
            <div class="column goods">
              <img class="image" :src="order.coverUrl" alt="" />
              <div class="info">
                <p class="name ellipsis-2">
                  {{ order.title }}
                </p>
                <p class="attr ellipsis">
                  <span>{{ order.category }}</span>
                </p>
              </div>
              <div class="price">¥{{ order.price }}</div>
              <div class="count">x{{ orderList[i].count }}</div>
            </div>
            <div class="column amount">
              <p class="red">¥{{ orderList[i].sum }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.order-container {
  padding: 10px 20px;

  .pagination-container {
    display: flex;
    justify-content: center;
  }

  .main-container {
    min-height: 500px;

    .holder-container {
      min-height: 500px;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .order-container {
      overflow-y: scroll;
    }
  }
}

.order-item {
  margin-bottom: 20px;
  border: 1px solid #f5f5f5;

  .head {
    height: 50px;
    line-height: 50px;
    background: #f5f5f5;
    padding: 0 20px;
    overflow: hidden;

    span {
      margin-right: 20px;

      &.down-time {
        margin-right: 0;
        float: right;

        i {
          vertical-align: middle;
          margin-right: 3px;
        }

        b {
          vertical-align: middle;
          font-weight: normal;
        }
      }
    }

    .del {
      margin-right: 0;
      float: right;
      color: #999;
    }
  }

  .body {
    display: flex;
    align-items: stretch;

    .column {
      border-left: 1px solid #f5f5f5;
      text-align: center;
      padding: 20px;

      >p {
        padding-top: 10px;
      }

      &:first-child {
        border-left: none;
      }

      &.goods {
        flex: 1;
        //padding: 0;
        align-self: center;
        border-bottom: 1px solid #f5f5f5;
        padding: 10px;
        display: flex;

        .image {
          width: 70px;
          height: 70px;
          border: 1px solid #f5f5f5;
        }

        .info {
          width: 220px;
          text-align: left;
          padding: 0 10px;

          p {
            margin-bottom: 5px;

            &.name {
              height: 38px;
            }

            &.attr {
              color: #999;
              font-size: 12px;

              span {
                margin-right: 5px;
              }
            }
          }
        }

        .price {
          width: 100px;
        }

        .count {
          width: 80px;
        }
      }

      &.state {
        width: 120px;

        .green {
          color: $themeColor;
        }
      }

      &.amount {
        width: 200px;

        .red {
          color: $priceColor;
        }
      }

      &.action {
        width: 140px;

        a {
          display: block;

          &:hover {
            color: $themeColor;
          }
        }
      }
    }
  }
}
</style>
