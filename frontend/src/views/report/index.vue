<template>
  <div id="report">
    <div class="nav">
      <span @click="check" :class="['tab', flag == 'check' ? 'check_tab' : '']"
        >报告查询</span
      >
      <span :class="['tab', flag == 'add' ? 'check_tab' : '']" @click="add"
        >添加报告</span
      >
    </div>
    <router-view class="content"> </router-view>
    <!-- 定义报告查询入口组件，里面分为查询页面和添加页面，点击相应按钮执行路由的跳转 -->
  </div>
</template>
<script>
export default {
  data() {
    return {
      flag: "check",
    };
  },
  methods: {
    check() {
      this.$router.push({ path: "/doctor/report/check" });
      this.flag = "check";
    },
    add() {
      this.$router.push({ path: "/doctor/report/add" });
      this.flag = "add";
    },
  },
  watch: {
    "$route.path": {
      immediate: true,
      handler(newVal, oldVal) {
        if (newVal == "/doctor/report/add") {
          this.flag = "add";
        } else {
          this.flag = "check";
        }
      },
    },
  },
};
</script>
<style lang="scss" scoped>
#report {
  display: flex;
  flex-direction: column;
  height: 100%;
  .nav {
    height: 42px;
  }
  .tab {
    color: #333;
    background: url(../../assets/img/title_bg.png) 0 -55px no-repeat;
    display: inline-block;
    width: 150px;
    height: 42px;
    line-height: 42px;
    text-align: center;
  }
  .check_tab {
    color: #fff;
    background: url(../../assets/img/title_bg.png) 0 -8px no-repeat;
    display: inline-block;
    width: 150px;
    height: 42px;
    line-height: 42px;
    text-align: center;
  }
  .content {
    // width: 100%;
    flex: 1;
    background: rgba(255, 255, 255, 0.7);
    padding: 30px;
    box-sizing: border-box;
  }
}
</style>
