// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import utils from './assets/js/utils'

import Vue from 'vue'
import App from './App'
import {router} from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Axios from 'axios'
import VueAxios from 'vue-axios'

import './assets/font/iconfont.css'
import './assets/css/index.css'

Vue.use(VueAxios, Axios)
Vue.use(ElementUI)

// Axios.defaults.baseURL = '/api'

Vue.config.productionTip = false
Axios.defaults.baseURL = '/api'
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
