<script setup>
import {getGoodsDetailApi} from "@/apis/shopping";
import {useRoute} from "vue-router";
import {onMounted, ref} from "vue";
import {ElMessage} from "element-plus";
import {useCartStore} from "@/stores/cartStore";

const cartStore=useCartStore()
const route = useRoute()
const goods = ref({});
const getDetail = async () => {
  const goods_id = route.params.id
  const res = await getGoodsDetailApi({goods_id});
  goods.value = res.data;
}
onMounted(() => getDetail())
let skuObj = {};
//sku被点击时候
const skuChange = (sku) => {
  skuObj=sku
}
//商品数量
const count = ref(0);
const countChange = (count) => {
  count.value=count;
}
//添加购物车
const addCart = () => {
  cartStore.addCart({
    goodsId:goods.value.goodsId,
    name:goods.value.name,
    picture:goods.value.detailUrl,
    price:goods.value.price,
    count:count.value,
    selected:true
  });
  ElMessage.success('成功加入购物车');
}
</script>

<template>
  <div class="xtx-goods-page">
    <el-backtop :right="20" :bottom="20"/>
    <div class="container" v-if="!!goods">
      <div class="bread-container">
        <el-breadcrumb separator=">">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <!--首次渲染，goods里面没有数据，所以会报错
          解决方案1：可选链语法,例如 goods.categories?.[1].id 中，'?.'表示goods.categories中有数据才进行后面的运算
          解决方案2：v-if
          -->
          <el-breadcrumb-item>{{ goods.category }}
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <!-- 商品信息 -->
      <div class="info-container">
        <div>
          <div class="goods-info">
            <div class="media">
              <!-- 图片预览区 -->
              <img :src="goods.detailUrl"/>
            </div>
            <div class="spec">
              <!-- 商品信息区 -->
              <p class="g-name"> {{ goods.title }}</p>
              <p class="g-desc">{{ goods.desc }} </p>
              <p class="g-price">
                <span>{{ goods.price }}</span>
              </p>
              <div class="g-service">
                <dl>
                  <dt>促销</dt>
                  <dd>12月好物放送，App领券购买直降120元</dd>
                </dl>
                <dl>
                  <dt>服务</dt>
                  <dd>
                    <span>无忧退货</span>
                    <span>快速退款</span>
                    <span>免费包邮</span>
                    <a href="javascript:;">了解详情</a>
                  </dd>
                </dl>
              </div>
              <!-- sku组件 -->
<!--              <XtxSku :goods="goods" @change="skuChange"/>-->
              <!-- 数据组件 -->
              <el-input-number v-model="count" :min="1" @change="countChange"/>
              <!-- 按钮组件 -->
              <div>
                <el-button size="large" class="btn" @click="addCart">
                  加入购物车
                </el-button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<style scoped lang='scss'>
.xtx-goods-page {
  .goods-info {
    min-height: 600px;
    background: #fff;
    display: flex;

    .media {
      width: 580px;
      height: 600px;
      padding: 30px 50px;
    }

    .spec {
      flex: 1;
      padding: 30px 30px 30px 0;
    }
  }

  .goods-footer {
    display: flex;
    margin-top: 20px;

    .goods-article {
      width: 940px;
      margin-right: 20px;
    }

    .goods-aside {
      width: 280px;
      min-height: 1000px;
    }
  }

  .goods-tabs {
    min-height: 600px;
    background: #fff;
  }

  .goods-warn {
    min-height: 600px;
    background: #fff;
    margin-top: 20px;
  }

  .number-box {
    display: flex;
    align-items: center;

    .label {
      width: 60px;
      color: #999;
      padding-left: 10px;
    }
  }

  .g-name {
    font-size: 22px;
  }

  .g-desc {
    color: #999;
    margin-top: 10px;
  }

  .g-price {
    margin-top: 10px;

    span {
      &::before {
        content: "¥";
        font-size: 14px;
      }

      &:first-child {
        color: $priceColor;
        margin-right: 10px;
        font-size: 22px;
      }
    }
  }

  .g-service {
    background: #f5f5f5;
    width: 500px;
    padding: 20px 10px 0 10px;
    margin-top: 10px;

    dl {
      padding-bottom: 20px;
      display: flex;
      align-items: center;

      dt {
        width: 50px;
        color: #999;
      }

      dd {
        color: #666;

        &:last-child {
          span {
            margin-right: 10px;

            &::before {
              content: "•";
              color: $themeColor;
              margin-right: 2px;
            }
          }

          a {
            color: $themeColor;
          }
        }
      }
    }
  }

  .goods-sales {
    display: flex;
    width: 400px;
    align-items: center;
    text-align: center;
    height: 140px;

    li {
      flex: 1;
      position: relative;

      ~ li::after {
        position: absolute;
        top: 10px;
        left: 0;
        height: 60px;
        border-left: 1px solid #e4e4e4;
        content: "";
      }

      p {
        &:first-child {
          color: #999;
        }

        &:nth-child(2) {
          color: $priceColor;
          margin-top: 10px;
        }

        &:last-child {
          color: #666;
          margin-top: 10px;

          i {
            color: $themeColor;
            font-size: 14px;
            margin-right: 2px;
          }

          &:hover {
            color: $themeColor;
            cursor: pointer;
          }
        }
      }
    }
  }
}

.goods-tabs {
  min-height: 600px;
  background: #fff;

  nav {
    height: 70px;
    line-height: 70px;
    display: flex;
    border-bottom: 1px solid #f5f5f5;

    a {
      padding: 0 40px;
      font-size: 18px;
      position: relative;

      > span {
        color: $priceColor;
        font-size: 16px;
        margin-left: 10px;
      }
    }
  }
}

.goods-detail {
  padding: 40px;

  .attrs {
    display: flex;
    flex-wrap: wrap;
    margin-bottom: 30px;

    li {
      display: flex;
      margin-bottom: 10px;
      width: 50%;

      .dt {
        width: 100px;
        color: #999;
      }

      .dd {
        flex: 1;
        color: #666;
      }
    }
  }

  > img {
    width: 100%;
  }
}

.btn {
  margin-top: 20px;

}

.bread-container {
  padding: 25px 0;
}
</style>
