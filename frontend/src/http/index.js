import Vue from "vue";
import Axios from "axios";
import { Message } from "element-ui";
import store from "../store";
import router from "../router";

console.log("213", process.env.NODE_ENV);

// process.env包含着关于系统环境的信息，NODE_ENV是一个用户自定义的变量，在webpack中它的用途是判断生产环境或开发环境。
// "serve": "vue-cli-service serve", //本地开发运行，会把process.env.NODE_ENV设置为'development'
// "build": "vue-cli-service build", //默认打包模式，会把process.env.NODE_ENV设置为'production'
var baseURL;
if (process.env.NODE_ENV === "development") {
    baseURL = "/api";
    // baseURL = "http://192.168.10.103";
} else if (process.env.NODE_ENV === "production") {
    baseURL = "http://39.100.14.147";
}
// 定义接口根目录，区分开发环境和生产环境
const instance = Axios.create({
    baseURL,
    timeout: 20000,
});

instance.defaults.withCredentials = true;
// 设置发送请求时候头信息携带cookie

// 添加响应拦截器
instance.interceptors.response.use(
    function(response) {
        // 对响应数据做点什么，如果返回的信息是无效token的话，那么就会重新跳转到登陆页面
        if (response.data.msg === "未登录") {
            router.replace({
                name: "login",
            });
        }
        return response;
    },
    function(error) {
        // 对响应错误做点什么
        return Promise.reject(error);
    }
);
// 封装axios方法，定义传递的参数有地址，data，方法和params

export default function http(url, method, params = {}, data = {}) {
    return instance({
            url,
            data,
            method,
            params,
        })
        .then((res) => {
            console.log(res);
            if (res.status >= 200 && res.status < 300) {
                return res.data;
            } else {
                return Promise.reject(res.data.msg);
            }
        })
        .catch((err) => {
            Message.error(err.message);
            return Promise.reject(err);
        });
}