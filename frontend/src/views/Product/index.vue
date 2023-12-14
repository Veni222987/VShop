<script setup>
import { ref } from 'vue';
import {deleteGoodsApi, getAllGoodsApi, addGoodsApi, updateGoodsApi} from '@/apis/backstage';
import {useSellerStore} from "@/stores/sellerStore";
import {onMounted} from "vue";
import {ElMessage} from "element-plus";

const addFlag = ref(false);
const editFlag = ref(false);

const product = ref({
  title: '',
  coverUrl: '',
  category: '',
  price: '',
  stock: '',
});

const newProduct = ref({
  title: '',
  coverUrl: '',
  category: '',
  price: '',
  stock: '',
});

const sellerStore = useSellerStore();

const productList = ref([]);

// Function to add a new product
const addProduct = async (product) => {
  // Add your logic here to handle adding a new product
  await addGoodsApi({ ...product, shopId: sellerStore.sellerInfo.sid });
  ElMessage.success('添加成功');
  addFlag.value = false;
  newProduct.value = {
    title: '',
    coverUrl: '',
    category: '',
    price: '',
    stock: '',
  };
  await fetchProducts()
};

// Function to delete a product
const deleteProduct = async (goodsId) => {
  // Add your logic here to handle deleting a product
  await deleteGoodsApi({ goodsId: goodsId });
  await fetchProducts()
};

// Function to update a product
const updateProduct = async (product) => {
  // Add your logic here to handle updating a product
  await updateGoodsApi({ ...product });
  ElMessage.success('修改成功');
  editFlag.value = false;
};

// Function to fetch product data
const fetchProducts = async () => {
  // Add your logic here to fetch product data
  const res = await getAllGoodsApi({ sid: sellerStore.sellerInfo.sid });
  productList.value = res.data;
};

onMounted(() => fetchProducts());

const onEdit = (row) => {
  console.log(row);
  product.value = row;
  editFlag.value = true;
};
</script>

<template>
  <el-form :inline="true" class="demo-form-inline">
    <el-form-item>
      <el-button type="primary" @click="addFlag = true">添加商品</el-button>
    </el-form-item>
  </el-form>
  <div class="product-container">
    <!-- Display table of products -->
    <el-table :data="productList" class="product-table" style="width: 100%">
      <!-- Define columns for your table -->
      <el-table-column prop="goodsId" label="商品id" width="250"></el-table-column>
      <el-table-column prop="title" label="商品名" width="250"></el-table-column>
      <el-table-column prop="coverUrl" label="图片" width="150">
        <template #default="{ row }">
          <img :src="row.coverUrl" alt="" style="width: 100px; height: 100px" />
        </template>
      </el-table-column>
      <el-table-column prop="category" label="分类" width="150"></el-table-column>
      <el-table-column prop="price" label="价格" width="150"></el-table-column>
      <el-table-column prop="stock" label="存货" width="150"></el-table-column>
      <el-table-column fixed="right" label="操作" width="200">
        <template #default="{ row }">
          <!-- Add buttons for editing and deleting products -->
          <el-button type="primary" size="small" @click="onEdit(row)">修改</el-button>
          <el-button type="danger" size="small" @click="deleteProduct(row.goodsId)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="editFlag" title="修改商品详情" width="30%" center>
      <el-form :model="product" label-width="100px" class="demo-ruleForm">
        <el-form-item label="商品名" prop="title">
          <el-input v-model="product.title"></el-input>
        </el-form-item>
        <el-form-item label="图片" prop="coverUrl">
          <el-input v-model="product.coverUrl"></el-input>
        </el-form-item>
        <el-form-item label="分类" prop="category">
          <el-select v-model="product.category" placeholder="请选择">
            <el-option label="居家" value="居家"></el-option>
            <el-option label="美食" value="美食"></el-option>
            <el-option label="服饰" value="服饰"></el-option>
            <el-option label="母婴" value="母婴"></el-option>
            <el-option label="个护" value="个护"></el-option>
            <el-option label="严选" value="严选"></el-option>
            <el-option label="数码" value="数码"></el-option>
            <el-option label="运动" value="运动"></el-option>
            <el-option label="杂项" value="杂项"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="product.price"></el-input>
        </el-form-item>
        <el-form-item label="存货" prop="stock">
          <el-input v-model="product.stock"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
      <el-button @click="editFlag = false">取 消</el-button>
      <el-button type="primary" @click="updateProduct(product)">确 定</el-button>
    </span>
    </el-dialog>

    <el-dialog v-model="addFlag" title="添加商品" width="30%" center>
      <el-form :model="newProduct" label-width="100px" class="demo-ruleForm">
        <el-form-item label="商品名" prop="title">
          <el-input v-model="newProduct.title"></el-input>
        </el-form-item>
        <el-form-item label="图片" prop="coverUrl">
          <el-input v-model="newProduct.coverUrl"></el-input>
        </el-form-item>
        <el-form-item label="分类" prop="category">
          <el-select v-model="newProduct.category" placeholder="请选择">
            <el-option label="居家" value="居家"></el-option>
            <el-option label="美食" value="美食"></el-option>
            <el-option label="服饰" value="服饰"></el-option>
            <el-option label="母婴" value="母婴"></el-option>
            <el-option label="个护" value="个护"></el-option>
            <el-option label="严选" value="严选"></el-option>
            <el-option label="数码" value="数码"></el-option>
            <el-option label="运动" value="运动"></el-option>
            <el-option label="杂项" value="杂项"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="newProduct.price"></el-input>
        </el-form-item>
        <el-form-item label="存货" prop="stock">
          <el-input v-model="newProduct.stock"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
      <el-button @click="addFlag = false">取 消</el-button>
      <el-button type="primary" @click="addProduct(newProduct)">确 定</el-button>
    </span>
    </el-dialog>
  </div>
</template>

<style scoped>
.product-container {
  width: 100%;
  height: 70vh;
  overflow-y: scroll;
}
.demo-form-inline {
  padding: 2rem 2rem;
}
.demo-form-inline el-input {
  --el-input-width: 220px;
}
.product-table {
  padding: 0 2rem;
}
</style>
