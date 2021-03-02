<template>
  <div class="block" style="height: 300px;">
    <div id="centered">
      <h1>1-Fish</h1>
      <router-view/>
    </div>
  </div>
</template>

<script>
export default {}
</script>

<style>
body {

  /*background: #2c3e50;*/
  background: url("../../assets/image/3358.jpg");
  background-size: 100%;
  background-repeat: no-repeat;
  background-attachment:fixed;
  background-size: cover;
}

#centered {
  width: 400px;
  height: 500px;
  background: white;

  margin: 0 auto;
  margin-top: 200px;


  padding-top: 30px;
  padding-bottom: 0px;

  text-align: center;

  border: black;
  border-width: 10px;
}
#centered h1{
  margin-top: 0;
  margin-bottom: 30px;
}
</style>
