<script setup>
import {useCartStore} from "@/stores/cartStore";
import {onMounted,computed} from "vue";

const cartStore=useCartStore()

let catUrls = {
  'jujia': '/category/'+encodeURIComponent("居家"),
  'meishi': '/category/'+encodeURIComponent("美食"),
  'fushi': '/category/'+encodeURIComponent("服饰"),
  'muying': '/category/'+encodeURIComponent("母婴"),
  'gehu': '/category/'+encodeURIComponent("个护"),
  'yanxuan': '/category/'+encodeURIComponent("严选"),
  'shuma': '/category/'+encodeURIComponent("数码"),
  'yundong': '/category/'+encodeURIComponent("运动"),
  'zaxiang': '/category/'+encodeURIComponent("杂项"),
}

onMounted(()=>{
  cartStore.updateCart()
})

// 获取购物车商品数量
const goodsCount = computed(() => {
  return cartStore.cartList.reduce((total, item) => {
    return total + item.count;
  }, 0);
})

// 获取购物车商品总价
const goodsPrice = computed(() => {
  return cartStore.cartList.reduce((total, item) => {
    return total + item.count * item.goods.price;
  }, 0);
})
</script>

<template>
  <header class='app-header'>
    <div class="container">
      <h1 class="logo">
        <RouterLink to="/">VShop</RouterLink>
      </h1>
      <ul class="app-header-nav ">
        <li class="home">
          <RouterLink to="/">首页</RouterLink>
        </li>
        <li>
          <RouterLink :to=catUrls.jujia>居家</RouterLink>
        </li>
        <li>
          <RouterLink :to=catUrls.meishi>美食</RouterLink>
        </li>
        <li>
          <RouterLink :to=catUrls.fushi>服饰</RouterLink>
        </li>
        <li>
          <RouterLink :to=catUrls.muying>母婴</RouterLink>
        </li>
        <li>
          <RouterLink :to=catUrls.gehu>个护</RouterLink>
        </li>
        <li>
          <RouterLink :to=catUrls.yanxuan>严选</RouterLink>
        </li>
        <li>
          <RouterLink :to=catUrls.shuma>数码</RouterLink>
        </li>
        <li>
          <RouterLink :to=catUrls.yundong>运动</RouterLink>
        </li>
        <li>
          <RouterLink :to=catUrls.zaxiang>杂项</RouterLink>
        </li>
      </ul>
      <!-- 头部购物车 -->
      <div class="cart">
        <a class="curr" href="javascript:;">
          <i class="iconfont icon-cart"></i><em>{{ goodsCount }}</em>
        </a>
        <div class="layer">
          <div class="list">
            <div class="item" v-for="i in cartStore.cartList" :key="i">
              <RouterLink to="">
                <img :src="i.goods.coverUrl" alt="" />
                <div class="center">
                  <p class="name ellipsis-2">
                    {{ i.goods.title }}
                  </p>
<!--                  <p class="attr ellipsis">{{ i.attrsText }}</p>-->
                </div>
                <div class="right">
                  <p class="price">&yen;{{ i.goods.price }}</p>
                  <p class="count">x{{ i.count }}</p>
                </div>
              </RouterLink>
<!--              <i class="iconfont icon-close-new" @click="cartStore.delCart(i.skuId)"></i>-->
            </div>
          </div>
          <div class="foot">
            <div class="total">
              <p>共 {{goodsCount}} 件商品</p>
              <p>&yen; {{ goodsPrice }} </p>
            </div>
            <el-button size="large" type="primary" @click="$router.push('/pay')">去购物车结算</el-button>
          </div>
        </div>
      </div>
    </div>
  </header>
</template>


<style scoped lang='scss'>
.app-header {
  background: #fff;

  .logo {
    display: flex;
    align-items: center;
    height: 100px;
  }

  .container {
    display: flex;
    align-items: center;
  }

  .app-header-nav {
    width: 820px;
    display: flex;
    padding-left: 40px;
    position: relative;
    z-index: 998;

    li {
      margin-right: 40px;
      width: 38px;
      text-align: center;

      a {
        font-size: 16px;
        line-height: 32px;
        height: 32px;
        display: inline-block;

        &:hover {
          color: $themeColor;
          border-bottom: 1px solid $themeColor;
        }
      }

      .active {
        color: $themeColor;
        border-bottom: 1px solid $themeColor;
      }
    }
  }

  .cart {
    width: 50px;
    position: relative;
    z-index: 600;

    .curr {
      height: 32px;
      line-height: 32px;
      text-align: center;
      position: relative;
      display: block;

      .icon-cart {
        font-size: 22px;
      }

      em {
        font-style: normal;
        position: absolute;
        right: 0;
        top: 0;
        padding: 1px 6px;
        line-height: 1;
        background: $helpColor;
        color: #fff;
        font-size: 12px;
        border-radius: 10px;
        font-family: Arial;
      }
    }

    &:hover {
      .layer {
        opacity: 1;
        transform: none;
      }
    }

    .layer {
      opacity: 0;
      transition: all 0.4s 0.2s;
      transform: translateY(-200px) scale(1, 0);
      width: 400px;
      height: 400px;
      position: absolute;
      top: 50px;
      right: 0;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
      background: #fff;
      border-radius: 4px;
      padding-top: 10px;

      &::before {
        content: "";
        position: absolute;
        right: 14px;
        top: -10px;
        width: 20px;
        height: 20px;
        background: #fff;
        transform: scale(0.6, 1) rotate(45deg);
        box-shadow: -3px -3px 5px rgba(0, 0, 0, 0.1);
      }

      .foot {
        position: absolute;
        left: 0;
        bottom: 0;
        height: 70px;
        width: 100%;
        padding: 10px;
        display: flex;
        justify-content: space-between;
        background: #f8f8f8;
        align-items: center;

        .total {
          padding-left: 10px;
          color: #999;

          p {
            &:last-child {
              font-size: 18px;
              color: $priceColor;
            }
          }
        }
      }
    }

    .list {
      height: 310px;
      overflow: auto;
      padding: 0 10px;

      &::-webkit-scrollbar {
        width: 10px;
        height: 10px;
      }

      &::-webkit-scrollbar-track {
        background: #f8f8f8;
        border-radius: 2px;
      }

      &::-webkit-scrollbar-thumb {
        background: #eee;
        border-radius: 10px;
      }

      &::-webkit-scrollbar-thumb:hover {
        background: #ccc;
      }

      .item {
        border-bottom: 1px solid #f5f5f5;
        padding: 10px 0;
        position: relative;

        i {
          position: absolute;
          bottom: 38px;
          right: 0;
          opacity: 0;
          color: #666;
          transition: all 0.5s;
        }

        &:hover {
          i {
            opacity: 1;
            cursor: pointer;
          }
        }

        a {
          display: flex;
          align-items: center;

          img {
            height: 80px;
            width: 80px;
          }

          .center {
            padding: 0 10px;
            width: 200px;

            .name {
              font-size: 16px;
            }

            .attr {
              color: #999;
              padding-top: 5px;
            }
          }

          .right {
            width: 100px;
            padding-right: 20px;
            text-align: center;

            .price {
              font-size: 16px;
              color: $priceColor;
            }

            .count {
              color: #999;
              margin-top: 5px;
              font-size: 16px;
            }
          }
        }
      }
    }
  }
}
</style>
