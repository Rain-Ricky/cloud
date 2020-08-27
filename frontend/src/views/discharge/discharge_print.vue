<template>
  <div id="dischargePrint">
    <el-container class="detail">
      <el-header class="header">
        <div class="right_con">
          <p>
            姓名：
            <span>{{ dischargeMessage.userName }}</span>
          </p>
          <p>
            性别：
            <span>{{ dischargeMessage.gende == 1 ? "男" : "女" }}</span>
          </p>
          <p>
            年龄：
            <span>{{ dischargeMessage.age }}</span>
          </p>
          <p>
            科别：
            <span>{{ dischargeMessage.deName }}</span>
          </p>
          <p>
            住院时间：
            <span>{{ dischargeMessage.date }}</span>
          </p>
          <br />
          <p>
            住院号：
            <span>{{ dischargeMessage.code }}</span>
          </p>
          <p>
            病床号：
            <span>{{ "data" }}</span>
          </p>
          <p>
            主治医师：
            <span>{{ dischargeMessage.empName }}</span>
          </p>
          <p>
            护士：
            <span>{{ "data" }}</span>
          </p>
        </div>
        <div>
          <el-button
            type="success"
            round
            icon="el-icon-edit-outline"
            class="bg16d"
            >打印证明</el-button
          >
        </div>
      </el-header>
      <el-divider></el-divider>
      <el-main class="main">
        <div>
          <span> 诊断症状：</span>

          <p>{{ dischargeMessage.symptom }}</p>
          <!-- 当点击修改时，展示input框，其他时候显示p标签 -->
        </div>
        <div>
          <span> 手术：</span>

          <p>{{ dischargeMessage.dtjc }}</p>
        </div>
        <div>
          <span> 恢复情况：</span>

          <p>{{ dischargeMessage.blzd }}</p>
        </div>
        <div>
          <span> 备注：</span>

          <p>{{ dischargeMessage.miany }}</p>
        </div>
      </el-main>
      <el-divider></el-divider>
      <el-footer class="footer">
        <p>报告医师：{{ "item.bgysName " }}</p>
        <p>审核医师：{{ "item.shysName" }}</p>
        <p></p>
      </el-footer>
    </el-container>
  </div>
</template>
<script>
export default {
  data() {
    return {
      dischargeMessage: {},
      // 保存报告详情
      //   reportImg:""
      // 保存报告单图片
      revise: false, //是否修改报告内容\
      copyReportMessage: "",
    };
  },

  mounted() {
    this.dischargeMessage = {
      userName: "zhangsan",
      gender: 1,
      age: 18,
      deName: "眼科",
      date: "2020.5.10",
      code: 1002,
      empName: "王老师",
      symptom: "咳嗽上火",
      dtjc: "不需要手术",
      blzd: "吃药就好了",
      miany: "不要吃凉的和辣的",
    };
  },

  methods: {},
};
</script>
<style lang="scss" scoped>
#dischargePrint {
  .detail {
    height: 100%;
  }
  .header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    .right_con {
      display: flex;
      // justify-content: space-between;
      flex-wrap: wrap;
      width: 780px;
    }

    p {
      color: #797979;
      display: flex;
      width: 155px;
      //   justify-content: center;
      align-items: center;
      span {
        color: #333;
      }
    }
  }
  .main {
    color: #333;
    display: flex;
    flex-direction: column;
    div {
      flex: 1;
      display: flex;
      margin-bottom: 13px;
      span {
        display: inline-block;
        width: 100px;
        text-align: right;
      }
      p {
        flex: 1;
      }
      .revise_con {
        flex: 1;
      }
    }
  }
  .footer {
    display: flex;
    justify-content: space-between;
    p {
      display: flex;
      justify-content: center;
      align-items: center;
    }
  }
}
</style>
<style lang="scss">
.el-message-box {
  width: auto !important;
}
//   注意 修改element-ui弹窗的样式不能在添加了scoped的style中修改，解决方法：另写一个style添加样式
</style>
