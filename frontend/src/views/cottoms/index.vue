<template>
  <div id="cottoms">
    <div class="nav">
      <span @click="check" :class="['tab', flag == 'check' ? 'check_tab' : '']">
        {{ change ? "病例查看" : "电子病例" }}</span
      >
      <span
        v-if="!change"
        :class="['tab', flag == 'add' ? 'check_tab' : '']"
        @click="add"
        >添加病例</span
      >
    </div>
    <router-view class="content"> </router-view>
    <!-- 定义电子病历入口组件，里面分为查询电子病例页面和添加电子病历页面，点击相应按钮执行路由的跳转 -->
  </div>
</template>
<script>
export default {
  data() {
    return {
      flag: "check",
      change: false,
    };
  },
  methods: {
    check() {
      this.$router.push({ path: "/doctor/cottoms/list" });
      this.flag = "check";
    },
    //点击电子病历按钮跳转到分页列表页
    add() {
      this.$router.push({ path: "/doctor/cottoms/add" });
      this.flag = "add";
    },
    //点击电子病历按钮跳转到添加病例页
  },
  watch: {
    "$route.path": {
      immediate: true,
      handler(newVal, oldVal) {
        if (newVal == "/doctor/cottoms/detail") {
          this.change = true;
        } else {
          this.change = false;
        }
        // 如果是详情页的话 添加病例按钮不出现

        if (newVal == "/doctor/cottoms/add") {
          this.flag = "add";
        } else {
          this.flag = "check";
        }
        //确保用户如果刷新 按钮的选中状态还是正确的
      },
    },
    //通过watch监听路由的变化，控制导航菜单的变化
  },
};
</script>
<style lang="scss" scoped>
#cottoms {
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
