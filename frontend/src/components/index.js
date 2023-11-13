//将components里面的插件进行全局注册(通过插件方式)
//到main.js里面注册！！
import ImageView from './ImageView/index.vue'
import XtxSku from "@/components/XtxSku/index.vue";

export const componentPlugin={
    install(app){
        //app.component('组件名字',组件配置对象)
        app.component('ImageView',ImageView);
        app.component('XtxSku',XtxSku);
    }
}