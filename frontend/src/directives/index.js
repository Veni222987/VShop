//定义懒加载插件
import {useIntersectionObserver} from "@vueuse/core";
//定义完成后需要在main.js注册！！
export const lazyPlugin={
    install(app){
    //懒加载指令逻辑
        //自定义全局指令之图片懒加载
        app.directive('img-lazy',{
            mounted(el,binding){
                //el:指令绑定的那个元素 img
                //binding：binding.value 指令等于号后面绑定的表达式的值 图片URL
                const { stop } = useIntersectionObserver(
                    el,//表明要监听的元素
                    ([{ isIntersecting }]) => {
                        if (isIntersecting) {
                            // 进入视口区域
                            el.src = binding.value;
                            //要监听的图片第一次加载完成后就结束监听，避免资源浪费
                            stop();
                        }
                    },
                )
            }
        })
    }
}