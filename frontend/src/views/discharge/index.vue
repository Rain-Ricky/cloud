<template>
  <div id="discharge">
    <div class="nav">
      <span class="check_tab">出院管理</span>
    </div>
    <router-view class="content"> </router-view>
  </div>
</template>
<script>
export default {
  data() {
    return {};
  },
  methods: {},
};
</script>
<style lang="scss" scoped>
#discharge {
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
