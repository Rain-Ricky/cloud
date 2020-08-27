import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        // login: localStorage.getItem("login") || "",
        // login: true,
    },
    // 在state中定义token，如果本地存储中存有token就从本地存储中拿，没有的话就为空
    mutations: {
        // setLogin(state, data) {
        //     state.login = data;
        //     localStorage.setItem("login", data);
        // },
        // 在本地存储中存储token
    },
});