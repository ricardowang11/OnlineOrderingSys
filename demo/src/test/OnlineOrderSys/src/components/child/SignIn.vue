<template>
  <div id="SignForm">
    <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
      <el-form-item label="用户名" prop="username">
        <el-input type="text" v-model="ruleForm2.username" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="pass">
        <el-input type="password" v-model="ruleForm2.pass" auto-complete="off"></el-input>
      </el-form-item>


      <el-form-item>
        <el-button type="primary" @click="signin">登录</el-button>
        <el-button @click="goSignUp">去注册</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm2')" class="icon iconfont icon-qq" circle></el-button>
        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <el-button type="primary" @click="submitForm('ruleForm2')" class="icon iconfont icon-github" circle></el-button>
        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <el-button type="primary" @click="submitForm('ruleForm2')" class="icon iconfont icon-email" circle></el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from 'axios'
import qs from 'qs'
import utils from '../../assets/js/utils'

export default {
  data () {
    const usernameRegex = /^[A-Za-z0-9]{8,16}$/
    const passRegex = /^[A-Za-z0-9._]{8,16}$/
    var validateUsername = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'))
      } else {
        if (!usernameRegex.test(value)) {
          callback(new Error('请输入8-16位只包含数字字母的用户名'))
        } else {
          callback()
        }
      }
    }
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (!passRegex.test(value)) {
          callback(new Error('请输入8-16位密码，可以包含. _ 这两个特殊字符'))
        } else {
          callback()
        }
      }
    }
    return {
      ruleForm2: {
        username: '',
        pass: ''
      },
      rules2: {
        username: [
          {validator: validateUsername, trigger: 'blur'}
        ],
        password: [
          {validator: validatePass, trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    signin () {
      let a = this
      let params = {
        "username":a.ruleForm2.username,
        "password":a.ruleForm2.pass
      };
      axios.get('/signin/user',{
        params:params
      }).then(function (res) {
        var data = res.data
        alert(JSON.stringify(data))
        if (data.succeed != false) {
          a.$router.push({path: '/shop/main'})
        }
      })
    },
    goSignUp () {
      this.$router.push({path: '/sign/up'})
    }

  }
}
</script>

<style>
#SignForm {
  width: 80%;
  height: 80%;
  /*水平居中*/
  /*text-align: center;*/
  display: flex; /**/
  justify-content: center; /*水平居中*/
  align-items: Center; /*垂直居中*/
}
</style>
