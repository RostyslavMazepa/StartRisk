<template>
  <div class="container">
    <div class="user">
      <form>
        <h1>Create User</h1>
        <div class="form-group">
          <label for="firstName">First Name</label>
        <!--<div class="input-group input-group-sm mb-3">-->
          <input type="text" id="firstName" class="form-control" v-model="user.firstName" placeholder="First name">
        </div>
        <div class="form-group">
          <label for="middleName">Middle Name</label>
          <!--<div class="input-group input-group-sm mb-3">-->
          <input type="text" id="middleName" class="form-control" v-model="user.middleName" placeholder="Middle name">
        </div>
        <div class="form-group">
          <label for="lastName">Last Name</label>
          <!--<div class="input-group input-group-sm mb-3">-->
          <input type="text" id="lastName" class="form-control" v-model="user.lastName" placeholder="Last name">
        </div>
        <div class="form-group">
          <label for="username">Username</label>
        <!--<div class="input-group input-group-sm mb-3">-->
          <input type="email" id="username" class="form-control" v-model="user.username" placeholder="Username">
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <!--<div class="input-group input-group-sm mb-3">-->
          <input type="password" id="password" class="form-control" v-model="user.password" placeholder="Password">
        </div>


        <button @click="createUser()" class="btn btn-primary">Create User</button>

        <div v-if="showResponse"><h6>User created with Id: {{ response }}</h6></div>

        <button v-if="showResponse" @click="retrieveUser()">Retrieve user {{user.id}} data from database</button>

        <h4 v-if="showRetrievedUser">Retrieved User {{retrievedUser.firstName}} {{retrievedUser.lastName}}</h4>
      </form>
    </div>
  </div>
</template>

<script>
  // import axios from 'axios'
  import {AXIOS} from './http-common'

  export default {
    name: 'user',

    data () {
      return {
        response: [],
        errors: [],
        user: {
          id: 0,
          lastName: '',
          middleName: '',
          firstName: '',
          username: '',
          password: '',
          active: 1
        },
        showResponse: false,
        retrievedUser: {},
        showRetrievedUser: false
      }
    },
    methods: {
      // Fetches posts when the component is created.
      createUser () {
        var params = new URLSearchParams();
        params.append('firstName', this.user.firstName);
        params.append('middleName', this.user.middleName);
        params.append('lastName', this.user.lastName);

        params.append('username', this.user.username);
        params.append('password', this.user.password);
        params.append('active', this.user.active);

        AXIOS.post(`/user`, params)
          .then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data;
            this.user.id = response.data;
            console.log(response.data);
            this.showResponse = true
          })
          .catch(e => {
            this.errors.push(e)
          })
      },
      retrieveUser () {
        AXIOS.get(`/user/` + this.user.id)
          .then(response => {
            // JSON responses are automatically parsed.
            this.retrievedUser = response.data;
            console.log(response.data);
            this.showRetrievedUser = true
          })
          .catch(e => {
            this.errors.push(e)
          })
      }
    }
  }

</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
