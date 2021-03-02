import Vue from 'vue'
import Router from 'vue-router'
import Sign from '@/components/parent/Sign.vue'
import Delivery from '@/components/parent/Delivery.vue'
import Shop from '@/components/parent/Shop.vue'
import User from '@/components/parent/User.vue'

import SignIn from '@/components/child/SignIn.vue'
import SignUp from '@/components/child/SignUp.vue'

import ShopMain from '@/components/child/ShopMain.vue'
import axios from 'axios'
import utils from '../assets/js/utils'

Vue.use(Router)

// eslint-disable-next-line no-unused-vars
export const router = new Router({
  routes: [
    {
      path: '/sign',
      name: 'Sign',
      component: Sign,
      children: [
        {
          path: '/sign/in',
          name: 'SignIn',
          component: SignIn,
        },
        {
          path: '/sign/up',
          name: 'SignUp',
          component: SignUp

        }
      ]
    },
    {
      path: '/delivery',
      name: 'Delivery',
      component: Delivery
    },
    {
      path: '/shop',
      name: 'Shop',
      component: Shop,
      children: [
        {
          path: '/shop/main',
          name: 'ShopMain',
          component: ShopMain,
          meta: {
            requireAuth: true,
          }
        }
      ]
    },
    {
      path: '/user',
      name: 'User',
      component: User
    }
  ]
})
router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {  // 判断该路由是否需要登录权限
    alert("push之后")
    axios({
      method: 'get',
      url: '/confirm'
    }).then(function (res) {
      alert("确认中。。。")
      alert(JSON.stringify(res))
      let b = res.data.succeed
      alert("结果。。。"+b)
      if (b == true) {
        next()
      } else {
        next({
          path: '/sign/in',
          query: {redirect: to.fullPath}  // 将跳转的路由path作为参数，登录成功后跳转到该路由
        })
      }
    })
      .catch(function (err) {
        console.log(err)
      })
  } else if (from.fullPath.startsWith('/sign/in')) {
    if (to.fullPath.startsWith('/sign/up')){
      next()
    }
    var urlKey = utils.getUrlKey('redirect')
    if (urlKey == null) {
      next()
    } else {
      next({
        path: urlKey
      })
    }
  } else {
    next()
  }
})
