<script setup>
import { ref } from 'vue';
import {getSaleDataApi} from '@/apis/backstage';
import {useSellerStore} from "@/stores/sellerStore";
import {onMounted,computed} from "vue";

const sellerStore = useSellerStore();

const salesList = ref([
  {
    goodsId: '',
    count: '',
    sum: '',
  },
]);

// Function to fetch product data
const fetchSales = async () => {
  // Add your logic here to fetch product data
  const res = await getSaleDataApi({ sid: sellerStore.sellerInfo.sid });
  salesList.value = res.data;
};

onMounted(() => fetchSales());

// 计算总销售额
const totalSales = computed(() => {
  let total = 0;
  salesList.value.forEach(item => {
    total += item.sum;
  });
  return total;
});

</script>

<template>
  <div class="sales-container">
    <div class="sales-header">
      <h2>销售数据</h2>
      <div class="sales-total">
        <span>总销售额：</span>
        <span class="red">¥{{ totalSales }}</span>
      </div>
    </div>
  </div>
  <div class="detail">
    <h2>销售详情</h2>
  </div>
  <el-table :data="salesList" class="product-table" style="width: 100%">
    <el-table-column prop="goods.goodsId" label="商品ID" width="250">
    </el-table-column>
    <el-table-column prop="goods.title" label="商品名称" width="300">
    </el-table-column>
    <el-table-column prop="count" label="销量" width="200">
    </el-table-column>
    <el-table-column prop="sum" label="销售额" width="200">
    </el-table-column>
    <el-table-column prop="goods.createTime" label="销售时间" width="400">
    </el-table-column>
  </el-table>

</template>

<style scoped>
.sales-container {
  padding: 0 2rem;
}
.detail {
  padding: 0 2rem;
}
.demo-form-inline el-input {
  --el-input-width: 220px;
}
.product-table {
  padding: 1rem 2rem;
}
</style>
