<script setup>

import {useRouter} from "vue-router";
import {useSellerStore} from "@/stores/sellerStore";

const router = useRouter()

const sellerStore = useSellerStore()

const handleConfirm = () => {
  router.push('/login')
  sellerStore.clearSellerInfo()
}

</script>

<template>
  <nav class="app-topnav">
    <ul>
      <template v-if="true">
        <li><a href="javascript:;"><i class="iconfont icon-user"></i>{{sellerStore.sellerInfo?.name}}</a></li>
        <li>
          <el-popconfirm
              title="确认退出吗?"
              confirm-button-text="确认"
              cancel-button-text="取消"
              @confirm="handleConfirm"
          >
            <template #reference>
              <a href="javascript:;">退出登录</a>
            </template>
          </el-popconfirm>
        </li>
      </template>
    </ul>
  </nav>
</template>


<style scoped lang="scss">
.app-topnav {
  //background: $themeColor;
  border-bottom: 1px solid #27BA9B22;
  ul {
    display: flex;
    height: 80px;
    justify-content: flex-end;
    align-items: center;
    li {
      a {
        font-size: 18px;
        padding: 0 15px;
        color: $themeColor;
        line-height: 1;
        display: inline-block;

        i {
          font-size: 18px;
          margin-right: 2px;
        }

        &:hover {
          color: $themeColor;
        }
      }

      ~li {
        a {
          border-left: 2px solid $themeColor;
        }
      }
    }
  }
}
</style>
