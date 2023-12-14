//封装分类数据业务
import {onMounted, ref} from "vue";
import {onBeforeRouteUpdate, useRouter} from "vue-router";
import {getCategoryGoodsApi} from "@/apis/shopping";

/**
 * 获取分类数据
 */
export function useCategory() {
    const categoryData=ref({});
//获取路由参数，拿到参数ID
    const router=useRouter()
    console.log(router,"router")
//id=route.params.id 意思是形参为id，默认值是route.params.id
    const getCategory=async (category=router.currentRoute.value.params.id)=>{
        const res=await getCategoryGoodsApi({category});
        categoryData.value=res.data;
    }
    onMounted(()=>getCategory())
    //解决路由缓存问题方案2：利用钩子函数，路由参数变化的时候，可以把分类数据接口重新发送
    onBeforeRouteUpdate((to)=>{
        //路由发生变化,重新发送xhr请求
        let category=to.params.id;
        getCategory(category).then();
    })
    return{
        categoryData
    }
}
