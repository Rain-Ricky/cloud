<template>
  <div id="patientDetail">
    <el-container>
      <el-header class="header">
        <h1>病人信息</h1>
      </el-header>
      <!-- 头部导航内容 -->

      <el-divider></el-divider>

      <el-main>
        <el-row>
          <el-col :span="20" :offset="1">
            <el-form
              ref="form"
              :model="patientInfo"
              label-width="100px"
              :disabled="revise"
            >
              <el-form-item label="患者姓名：">
                <el-input v-model="patientInfo.username"></el-input>
              </el-form-item>
              <el-form-item label="性别 :" prop="sex">
                <el-select v-model="patientInfo.gender" placeholder="性别">
                  <el-option label="男" value="1"></el-option>
                  <el-option label="女" value="0"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="诊断结果：">
                <el-input v-model="patientInfo.symptom"></el-input>
              </el-form-item>
              <el-form-item label="用药详情：">
                <el-input v-model="patientInfo.drugsused"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
        </el-row>
      </el-main>

      <div class="footer" v-if="!revise">
        <p class="bg16d" plain @click="save">保存</p>
        <p @click="cancel">取消</p>
      </div>
    </el-container>
  </div>
</template>
<script>
export default {
  data() {
    return {
      revise: this.$route.params.from == "view" ? true : false,
      // 如果是点击查看按钮过来的就是true 否则就是false
      //控制表单是否是可编辑的
      patientInfo: {},
      copypatientInfo: {},
    };
  },

  mounted() {
    this.getPatientDetail();
    //进入页面获取病人详情数据
  },

  methods: {
    getPatientDetail() {
      this.$http("/consultationinfo/detail", "get", {
        consultationId: this.$route.params.id,
      }).then((res) => {
        if (res.msg == "ok") {
          this.patientInfo = res.result;
          this.copypatientInfo = JSON.parse(JSON.stringify(res.result));
          // 对病人详情数据进行深拷贝
        }
      });
    },
    //获取病人详情数据

    cancel() {
      this.patientInfo = this.copypatientInfo;
    },
    //点击取消编辑按钮的时候，让patientInfo数据变为修改前的数据（在获取到数据时保存的copypatientInfo）
    save() {
      this.$http("/consultationinfo/patient", "put", this.patientInfo).then(
        (res) => {
          if (res.msg == "ok") {
            this.patientInfo = res.result;
            this.copypatientInfo = JSON.parse(JSON.stringify(res.result));
          }
        }
      );
    },

    //点击保存
  },
};
</script>
<style lang="scss" scoped>
#patientDetail {
  .header {
    h1 {
      font-weight: normal;
    }
    display: flex;
    justify-content: space-between;
  }
  .el-main {
    padding-top: 0;
    margin-top: 40px;
  }
  .el-divider--horizontal {
    margin: 0;
  }
  .el-col-8 {
    display: flex;
    flex-direction: column;
    // height: 70%;
  }
  .divider {
    height: 420px;
    padding-top: 40px;
    box-sizing: border-box;
    display: flex;
    justify-content: center;
    .el-divider {
      height: 100%;
    }
  }
  .footer {
    display: flex;
    height: 40px;
    justify-content: center;
    p {
      width: 100px;
      height: 35px;
      text-align: center;
      line-height: 35px;
      color: #fff;
    }
    p:nth-child(2) {
      background: #ccc;
      margin-left: 20px;
    }
  }
}
</style>
<style lang="scss"></style>
