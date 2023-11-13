import axios from 'axios'
import {ElMessage} from 'element-plus'
import 'element-plus/theme-chalk/el-message.css'
import {useUserStore} from "@/stores/userStore";
import router from "@/router";
// 创建axios实例
const httpInstance = axios.create({
    baseURL: 'http://pcapi-xiaotuxian-front-devtest.itheima.net',
    timeout: 5000
})
// axios请求拦截器(对发出的数据进行处理)
httpInstance.interceptors.request.use(config => {
    //从pinia获取token数据
    const userStore=useUserStore()
    //拿取token
    const token=userStore.userInfo.token;
    if (token){
        config.headers.Authorization=`Bearer ${token}`
    }
    return config
}, e => Promise.reject(e))

// axios响应式拦截器(对返回的数据进行处理)
httpInstance.interceptors.response.use(res => res.data, e => {
    const userStore=useUserStore()
    //统一错误提示
    ElMessage({
        type:'error',
        message:e.response.data.message
    })
    //401 Token失效问题
    if (e.response.status===401){
        userStore.clearUserInfo();
        router.push('/login')
    }
    return Promise.reject(e)
})


export default httpInstance