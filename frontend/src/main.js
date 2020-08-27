import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
// 引入element-ui和css文件
import "./assets/styles/reset.css";
// 引入样式重置的css样式
import http from "./http";
Vue.prototype.$http = http;
// 引入http文件中定义的http方法，并把http方法挂载为全局的方法
// http文件中定义了axios拦截器，使得每次请求都携带token，并且定义了请求数据的方法http

Vue.config.productionTip = false;
Vue.use(ElementUI);
// 使用element - ui

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
