import { ref} from 'vue'
import { defineStore } from 'pinia'
import {getCategory} from "@/apis/layout";

export const useCategoryStore = defineStore('category', () => {
//导航列表数据管理
    //装载得到的导航数据
    const categoryList=ref([])
    //获取导航数据方法
    const getCategoryData=async ()=>{
        const res=await getCategory()
        categoryList.value=res.result
    }
    return{
        categoryList,
        getCategoryData
    }
})
