import Vue from "vue";
import VueRouter from "vue-router";
import store from "../store";

import Login from "../views/login.vue";
import Doctor from "../views/doctorSystem.vue";
// 1.引入组件login和doctor

import Report from "../views/report/index.vue";
import checkReport from "../views/report/check_report.vue";
import addReport from "../views/report/add_report.vue";
import detailReport from "../views/report/detail_report.vue";
// 引入报告查询的组件

import Discharge from "../views/discharge/index.vue";
import dischargeManage from "../views/discharge/discharge_manage.vue";
import dischargePrint from "../views/discharge/discharge_print.vue";
// 引入住院管理的组件

import Recipe from "../views/recipe/index.vue";
import recipeManage from "../views/recipe/recipe.vue";
// 引入处方管理的组件

import Cottoms from "../views/cottoms/index.vue";
import cottomsList from "../views/cottoms/cottoms_list.vue";
import cottomsDetail from "../views/cottoms/cottoms_detail.vue";
import cottomsAdd from "../views/cottoms/cottoms_add.vue";
//引入电子病例的组件

import Personal from "../views/personal/index.vue";
import personalInfo from "../views/personal/personal_info.vue";
// 引入个人信息的组件

import Counsel from "../views/counsel/index.vue";
import counselList from "../views/counsel/counsel_list.vue";
// 引入就诊咨询的组件

import Hospitalization from "../views/hospitalization/index.vue";
import hospitalizationList from "../views/hospitalization/hospitalization_list.vue";
import hospitalizationDetail from "../views/hospitalization/hospitalization_detail.vue";
import hospitalizationAdd from "../views/hospitalization/hospitalization_add.vue";
// 引入住院管理组件

import Patient from "../views/mypatient/index.vue";
import patientList from "../views/mypatient/patient_list.vue";
import patientDetail from "../views/mypatient/patient_detail.vue";
// 引入我的病人组件

Vue.use(VueRouter);

const routes = [{
        path: "/",
        redirect: "/login",
    },
    {
        path: "/login",
        name: "login",
        component: Login,
    },
    {
        path: "/doctor",
        name: "doctor",
        component: Doctor,
        redirect: "/doctor/cottoms/list",
        children: [{
                path: "report",
                component: Report,
                redirect: "/doctor/report/check",
                children: [{
                        path: "check",
                        component: checkReport,
                    },
                    {
                        path: "add",
                        component: addReport,
                    },
                    {
                        path: "detail",
                        component: detailReport,
                    },
                ],
            },
            {
                path: "discharge",
                component: Discharge,
                redirect: "/doctor/discharge/manage",
                children: [{
                        path: "manage",
                        component: dischargeManage,
                    },
                    {
                        path: "print",
                        component: dischargePrint,
                    },
                ],
            },
            {
                path: "recipe",
                component: Recipe,
                redirect: "/doctor/recipe/list",
                children: [{
                    path: "list",
                    component: recipeManage,
                }, ],
            },
            {
                path: "cottoms",
                component: Cottoms,
                redirect: "/doctor/cottoms/list",
                children: [{
                        path: "list",
                        component: cottomsList,
                    },
                    {
                        path: "add",
                        component: cottomsAdd,
                    },
                    {
                        path: "detail",
                        component: cottomsDetail,
                    },
                ],
            },
            {
                path: "personal",
                component: Personal,
                redirect: "/doctor/personal/info",
                children: [{
                    path: "info",
                    component: personalInfo,
                }, ],
            },
            {
                path: "counsel",
                component: Counsel,
                redirect: "/doctor/counsel/list",
                children: [{
                    path: "list",
                    component: counselList,
                }, ],
            },
            {
                path: "hospitalization",
                component: Hospitalization,
                redirect: "/doctor/hospitalization/list",
                children: [{
                        path: "list",
                        component: hospitalizationList,
                    },
                    {
                        path: "add",
                        component: hospitalizationAdd,
                    },
                    {
                        path: "detail",
                        component: hospitalizationDetail,
                    },
                ],
            },
            {
                path: "patient",
                component: Patient,
                redirect: "/doctor/patient/list",
                children: [{
                        path: "list",
                        component: patientList,
                    },
                    {
                        path: "detail/:id/:from",
                        component: patientDetail,
                    },
                ],
            },
        ],
    },
    // 2.在路由规则中定义路径和对应的组件，并把首页重定向到登录页面
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes,
});
const routerPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
    return routerPush.call(this, location).catch((error) => error);
};

// router.beforeEach((to, from, next) => {
//     // 检查前端路由 要to 的 path 是否需要进行权限认证,
//     //
//     console.log(to.path);
//     if (to.path.startsWith("/doctor")) {
//         if (!store.state.login) {
//             router.push({ path: "/login" });
//             return;
//         }
//     }
//     next();
// });
export default router;