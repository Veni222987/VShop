import {createApp} from 'vue'
import {createPinia} from 'pinia'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
// 定义懒加载插件
import App from './App.vue'
import router from './router'
//引入初始化样式文件
import '@/styles/common.scss'
import {lazyPlugin} from "@/directives";
//引入全局插件组件,使用时候不用引入import
import {componentPlugin} from "@/components";

const app = createApp(App)
const pinia=createPinia()
//注册持久化插件
pinia.use(piniaPluginPersistedstate)
app.use(pinia)
app.use(router)
app.use(componentPlugin)
//注册懒加载插件
app.use(lazyPlugin)
app.mount('#app')
