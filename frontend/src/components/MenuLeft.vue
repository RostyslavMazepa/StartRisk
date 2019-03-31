<template>
    <div class="sidenav">
        <router-link to="/">Hello</router-link> |
        <router-link to="/callservice">Service</router-link> |
        <router-link to="/bootstrap">Bootstrap</router-link> |
        <router-link to="/user">User</router-link> |
        <router-link to="/person">Person</router-link>
    </div>
</template>
<style>
    .sidenav {
        height: 100%;
        width: 200px;
        position: fixed;
        z-index: 1;
        top: 56px;
        left: 0;
        background-color: #111;
        overflow-x: hidden;
        padding-top: 20px;
    }

    .sidenav a {
        padding: 6px 6px 6px 32px;
        text-decoration: none;
        font-size: 16px;
        color: #818181;
        display: block;
    }

    .sidenav a:hover {
        color: #f1f1f1;
    }
    @media screen and (max-height: 450px) {
        .sidenav {
            padding-top: 15px;
        }
        .sidenav a {
            font-size: 18px;
        }
    }
</style>
