//封装分类数据业务
import {onMounted, ref} from "vue";
import {onBeforeRouteUpdate, useRoute} from "vue-router";
import {getCategoryApi} from "@/apis/category";

/**
 * 获取分类数据
 * @returns {{categoryData: Ref<UnwrapRef<{}>>}}
 */
export function useCategory() {
    const categoryData=ref({});
//获取路由参数，拿到参数ID
    const route=useRoute()
//id=route.params.id 意思是形参为id，默认值是route.params.id
    const getCategory=async (id=route.params.id)=>{
        const res=await getCategoryApi(id);
        categoryData.value=res.result;
    }
    onMounted(()=>getCategory())
    //解决路由缓存问题方案2：利用钩子函数，路由参数变化的时候，可以把分类数据接口重新发送
    onBeforeRouteUpdate((to)=>{
        //路由发生变化,重新发送xhr请求
        getCategory(to.params.id);
    })
    return{
        categoryData
    }
}