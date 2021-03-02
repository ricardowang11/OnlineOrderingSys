<template>
  <div id="SignForm">
    <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
      <el-form-item label="用户名" prop="username">
        <el-input type="text"  v-model="ruleForm2.username" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="pass">
        <el-input type="password" v-model="ruleForm2.pass" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="checkPass">
        <el-input type="password" v-model="ruleForm2.checkPass" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input type="text" v-model="ruleForm2.email" auto-complete="off"></el-input>
      </el-form-item>
      <!--      <el-form-item label="验证码" prop="checkPass">-->
      <!--        <el-input type="password" v-model="ruleForm2.checkPass" auto-complete="off"></el-input>-->
      <!--      </el-form-item>-->
      <el-form-item label="验证码" prop="validateCode">
        <el-row>
          <el-col :span="10"><div class="grid-content bg-purple">
            <el-input type="text" v-model="ruleForm2.validateCode" auto-complete="off"></el-input>
          </div></el-col>
          <el-col :span="14"><div class="grid-content bg-purple-light">
            <img :src="vCodeUrl" @click="getNewVCode"/>
          </div></el-col>
        </el-row>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm2')">提交</el-button>
        <el-button @click="goSingIn">去登陆</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm2')" class="icon iconfont icon-qq"  circle></el-button>
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
export default {
  data() {
    const usernameRegex = /^[A-Za-z0-9]{8,16}$/;
    const passRegex = /^[A-Za-z0-9._]{8,16}$/;
    const emailRegex = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    var validateUsername = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'));
      } else {
        if(!usernameRegex.test(value)){
          callback(new Error('请输入8-16位只包含数字字母的用户名'));
        }else {
          callback();
        }
      }
    };
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if(!passRegex.test(value)){
          callback(new Error('请输入8-16位密码，可以包含. _ 这两个特殊字符'));
        }else {
          callback();
        }
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm2.pass) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入邮箱'));
      } else {
        if(!emailRegex.test(value)){
          callback(new Error('请输入正确的邮箱'));
        }else {
          callback();
        }
      }
    };
    var validateValidateCode = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入验证码'));
      } else {
        var that = this;
        /*在这里进行跨域请求*/
        that
          .axios({
            method: "post",
            url: "/validateCode",
            data:"vCode="+this.ruleForm2.validateCode,
            responseType:'json'
          })
          .then(function (res) {
            let b=res.data;

            if (b==true){
              callback();
            }else {
              callback(new Error('验证码错误'));
            }
          })
          .catch(function (err) {
            console.log(err);
          });

      }
    };
    return {
      vCodeUrl: '/api/validateCode',
      ruleForm2: {
        username:'',
        pass: '',
        checkPass: '',
        email:'',
        validateCode:''
      },
      rules2: {
        username:[
          {validator: validateUsername, trigger: 'blur'}
        ],
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ],
        email: [
          { validator: validateEmail, trigger: 'blur' }
        ],
        validateCode: [
          { validator: validateValidateCode, trigger:'change' }
        ]

      }
    };
  },
  methods: {
    submitForm(formName) {
      let a=this
      this.$refs[formName].validate((valid) => {

        if (valid) {
          let params = {
            "username":a.ruleForm2.username,//开始时间
            "password":a.ruleForm2.pass,//结束时间
            "email": a.ruleForm2.email//过滤
          }
          alert(qs.stringify(params))
          axios.get('/signup/user',{
            params:params
          }).then(function (res) {
            alert(111)
            var data = res.data
            if (data != null) {
              alert(JSON.stringify(data))
              a.$router.push({path: '/sign/in'})
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    goSingIn() {
      this.$router.push({path: '/sign/in'})
    },
    getNewVCode(){
      this.vCodeUrl='/validateCode?'+(new Date()).getTime();

    },
  },
}
</script>

<style>
#SignForm{
  width: 80%;
  height: 80%;
  /*水平居中*/
  /*text-align: center;*/
  display: flex; /**/
  justify-content: center; /*水平居中*/
  align-items: Center; /*垂直居中*/
}
</style>
