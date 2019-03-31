<template>
  <div id="app">
    <div><MenuTop /></div>
    <div><MenuLeft /></div>
    <!--
    <nav class="navbar navbar-dark bg-dark">
    -->
      <!-- Navbar content -->

    <!--
      <div id="nav">
        <router-link to="/">Hello</router-link> |
        <router-link to="/callservice">Service</router-link> |
        <router-link to="/bootstrap">Bootstrap</router-link> |
        <router-link to="/user">User</router-link>
      </div>
    </nav>
    -->
    <router-view :hellomsg="msg" class="main-page"></router-view>
  </div>
</template>

<script>
  import MenuTop from "./components/MenuTop";
  import MenuLeft from "./components/MenuLeft";

export default {
  name: 'app',
  components: {
    MenuTop,
    MenuLeft
  },
  data () {
    return {
      msg: 'Welcome to your Vue.js powered Spring Boot App'
    }
  }
}
</script>

<style lang="scss">
  .main-page {
    height: 100%;
    /*width: 200px;*/
    position: fixed;
    z-index: 1;
    top: 56px;
    left: 230px;
    overflow-x: hidden;
    padding-top: 20px;
  }
  /*
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px;
}

#nav {
  padding: 30px;
  a {
    font-weight: bold;
    color: #089b9b;
    &.router-link-exact-active {
     color: #42b983;
    }
  }
}
  */
</style>
