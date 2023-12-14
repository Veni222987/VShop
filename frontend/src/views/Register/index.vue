<script setup>
//准备表单数据
import {ref} from "vue";
import {ElMessage} from 'element-plus'
import 'element-plus/theme-chalk/el-message.css'
import {useRouter} from "vue-router";
import {useUserStore} from "@/stores/userStore";
import {useSellerStore} from "@/stores/sellerStore";

const form = ref({
  username: '',
  email: '',
  password: '',
  gender: ''
})
//准备校验规则对象
const rules = {
  username: [
    {required: true, message: '请输入用户名', trigger: 'blur'}
  ],
  email: [
    {required: true, message: '请输入邮箱', trigger: 'blur'}
  ],
  password: [
    {required: true, message: '请输入密码', trigger: 'blur'},
    {min: 6, max: 14, message: '密码长度在4至14个字符之间', trigger: 'blur'}
  ],
  gender: [
    {required: false, message: '请选择性别', trigger: 'blur'}
  ],
}
//获取表单示例做统一检验
const formRef=ref(null);
const router=useRouter()

// 获取路由参数 如果是type = 0 则是顾客注册，否则是商家注册
const type = router.currentRoute.value.query.type

// 判断是商家登录还是顾客登录
const isCustomer = ref(type === '0')

const userStore = useUserStore()
const sellerStore = useSellerStore()

// 注册
const doRegister=()=>{
  const {username,email,password,gender}=form.value
  let avatar = 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2F4d40b566-1f0a-4f8d-bc97-c513df8775b3%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1704959612&t=c7b84a5aa4889c6d6b2df074548cd9e6'
  formRef.value.validate(async (valid)=>{
    //当所有项都校验通过才为true
    if (valid){
      if(type === '0') {
        await userStore.userRegister({username,email,password,avatar,gender})
        ElMessage({type:'success',message:'顾客注册成功'});
        //跳转首页
        await router.replace({path: '/'})
      }else {
        let name = username
        await sellerStore.sellerRegister({name,email,password})
        ElMessage({type:'success',message:'商家成功'});
        //跳转首页
        await router.replace({path: '/seller'})
      }
    }
  })
}

</script>
<template>
  <div>
    <header class="login-header">
      <div class="container m-top-20">
        <h1 class="logo">
          <RouterLink to="/">小兔鲜</RouterLink>
        </h1>
        <RouterLink class="entry" to="/">
          进入网站首页
          <i class="iconfont icon-angle-right"></i>
          <i class="iconfont icon-angle-right"></i>
        </RouterLink>
      </div>
    </header>
    <section class="login-section">
      <div class="wrapper">
        <nav>
          <div
              class="register-type"
              :class="{'active': isCustomer}"
              v-if="isCustomer"
          >顾客注册</div>
          <div
              class="register-type"
              :class="{'active': !isCustomer}"
              v-else
          >商家注册</div>

        </nav>
        <div class="account-box">
          <div class="form">
            <el-form ref="formRef" :model="form" :rules="rules" label-position="right" label-width="70px"
                     status-icon>
              <el-form-item prop="username" label="用户名">
                <el-input v-model="form.username" placeholder="请输入用户名"/>
              </el-form-item>
              <el-form-item prop="account" label="邮箱">
                <el-input v-model="form.email" placeholder="请输入邮箱号"/>
              </el-form-item>
              <el-form-item prop="password" label="密码">
                <el-input v-model="form.password"
                          type="password"
                          placeholder="请输入密码"
                          show-password/>
              </el-form-item>
              <el-form-item prop="gender" label="性别" v-if="isCustomer">
                <el-radio-group v-model="form.gender">
                  <el-radio label="male">男性</el-radio>
                  <el-radio label="female">女性</el-radio>
                  <el-radio label="other">其他</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-button size="large" class="subBtn" @click="doRegister">点击注册</el-button>
            </el-form>
          </div>
        </div>
      </div>
    </section>

    <footer class="login-footer">
      <div class="container">
        <p>CopyRight &copy; 202130441436</p>
      </div>
    </footer>
  </div>
</template>

<style scoped lang='scss'>
.login-header {
  background: #fff;
  border-bottom: 1px solid #e4e4e4;

  .container {
    display: flex;
    align-items: flex-end;
    justify-content: space-between;
  }

  .logo {
    width: 80px;

    a {
      display: block;
      height: 132px;
      width: 100%;
      text-indent: -9999px;
    }
  }

  .sub {
    flex: 1;
    font-size: 24px;
    font-weight: normal;
    margin-bottom: 38px;
    margin-left: 20px;
    color: #666;
  }

  .entry {
    width: 120px;
    margin-bottom: 38px;
    font-size: 16px;

    i {
      font-size: 14px;
      color: $themeColor;
      letter-spacing: -5px;
    }
  }
}

.login-section {
  height: 488px;
  position: relative;

  .wrapper {
    width: 380px;
    background: #fff;
    position: absolute;
    left: 50%;
    top: 54px;
    transform: translate3d(100px, 0, 0);
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);

    nav {
      font-size: 14px;
      height: 55px;
      margin-bottom: 20px;
      border-bottom: 1px solid #f5f5f5;
      display: flex;
      padding: 0 40px;
      text-align: right;
      align-items: center;

      .register-type {
        flex: 1;
        line-height: 1;
        display: inline-block;
        font-size: 18px;
        position: relative;
        text-align: center;

        &.active {
          color: $themeColor;
        }
      }
    }
  }
}

.login-footer {
  padding: 30px 0 50px;
  background: #fff;

  p {
    text-align: center;
    color: #999;
    padding-top: 20px;

    a {
      line-height: 1;
      padding: 0 10px;
      color: #999;
      display: inline-block;

      ~ a {
        border-left: 1px solid #ccc;
      }
    }
  }
}

.account-box {
  .toggle {
    padding: 15px 40px;
    text-align: right;

    a {
      color: $themeColor;

      i {
        font-size: 14px;
      }
    }
  }

  .form {
    padding: 0 20px 20px 20px;

    &-item {
      margin-bottom: 28px;

      .input {
        position: relative;
        height: 36px;

        > i {
          width: 34px;
          height: 34px;
          background: #cfcdcd;
          color: #fff;
          position: absolute;
          left: 1px;
          top: 1px;
          text-align: center;
          line-height: 34px;
          font-size: 18px;
        }

        input {
          padding-left: 44px;
          border: 1px solid #cfcdcd;
          height: 36px;
          line-height: 36px;
          width: 100%;

          &.error {
            border-color: $priceColor;
          }

          &.active,
          &:focus {
            border-color: $themeColor;
          }
        }

        .code {
          position: absolute;
          right: 1px;
          top: 1px;
          text-align: center;
          line-height: 34px;
          font-size: 14px;
          background: #f5f5f5;
          color: #666;
          width: 90px;
          height: 34px;
          cursor: pointer;
        }
      }

      > .error {
        position: absolute;
        font-size: 12px;
        line-height: 28px;
        color: $priceColor;

        i {
          font-size: 14px;
          margin-right: 2px;
        }
      }
    }

    .agree {
      a {
        color: #069;
      }
    }

    .btn {
      display: block;
      width: 100%;
      height: 40px;
      color: #fff;
      text-align: center;
      line-height: 40px;
      background: $themeColor;

      &.disabled {
        background: #cfcdcd;
      }
    }
  }

  .action {
    padding: 20px 40px;
    display: flex;
    justify-content: space-between;
    align-items: center;

    .url {
      a {
        color: #999;
        margin-left: 10px;
      }
    }
  }
}

.subBtn {
  background: $themeColor;
  width: 100%;
  color: #fff;
}

.register-box {
  padding: 0 20px 20px 20px;
  display: flex;
  justify-content: flex-end;
  gap: 20px;
  align-items: center;

  a {
    color: $themeColor;
    font-size: 14px;
  }
}
</style>
