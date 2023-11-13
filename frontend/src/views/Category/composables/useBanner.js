//封装Banner轮播图相关代码
import {onMounted, ref} from "vue";
import {getHomBannerApi} from "@/apis/home";
export function useBanner() {
    const bannerList=ref([]);
    const getBanner=async ()=>{
        const banner = await getHomBannerApi({
            distributionSite:'2'
        });
        bannerList.value=banner.result;
    }
    onMounted(()=>getBanner())
    return{
        bannerList
    }
}