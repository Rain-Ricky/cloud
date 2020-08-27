<template>
  <div id="add_report">
    <el-container class="detail">
      <header class="header">
        <el-form :inline="true" :model="addReport" class="demo-form-inline">
          <el-form-item label="姓名">
            <el-input v-model="addReport.name" placeholder="姓名"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-select v-model="addReport.sex" placeholder="性别">
              <el-option label="男" value="男"></el-option>
              <el-option label="女" value="女"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="年龄">
            <el-input v-model="addReport.age" placeholder=""></el-input>
          </el-form-item>
          <el-form-item label="科别">
            <el-select v-model="addReport.region" placeholder="性别">
              <el-option label="复诊" value="复诊"></el-option>
              <el-option label="初诊" value="初诊"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="科别">
            <el-select v-model="addReport.region" placeholder="性别">
              <el-option label="复诊" value="复诊"></el-option>
              <el-option label="初诊" value="初诊"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
      </header>
      <el-main class="main">
        <div>
          <span> 临床诊断：</span>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="addReport.symptom"
            class="revise_con"
            resize="none"
          >
          </el-input>

          <!-- 当点击修改时，展示input框，其他时候显示p标签 -->
        </div>
        <div>
          <span> 大体检查：</span>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="addReport.dtjc"
            class="revise_con"
            resize="none"
          >
          </el-input>
        </div>
        <div>
          <span> 病理诊断：</span>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="addReport.blzd"
            class="revise_con"
            resize="none"
          >
          </el-input>
        </div>
        <div>
          <span> 免疫/组化：</span>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="addReport.mianyi"
            class="revise_con"
            resize="none"
          >
          </el-input>
        </div>
        <div>
          <span>结果：</span>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="addReport.result"
            class="revise_con"
            resize="none"
          >
          </el-input>
        </div>
        <div>
          <span> 备注：</span>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="addReport.mark"
            class="revise_con"
            resize="none"
          >
          </el-input>
        </div>
        <div>
          <span> 上传附件：</span>
          <p>最多上传三个附件，每个大小不超过2m</p>
        </div>
        <div class="dis">
          <span> 文件描述：</span>
          <el-input placeholder=""></el-input>
          <el-button size="mini">浏览</el-button>
          <el-button size="mini" type="primary">上传</el-button>
        </div>
      </el-main>
      <el-footer class="footer">
        <p class="bg16d" plain>保存</p>
        <p>取消</p>
      </el-footer>
    </el-container>
  </div>
</template>
<script>
export default {
  data() {
    return {
      addReport: {},
    };
  },

  mounted() {},

  methods: {
    // getReportMessage() {
    //   this.$http("/ds1/checkreport/getCheckDetailById", "post", {
    //     checkId: this.checkId,
    //   }).then((res) => {
    //     console.log(res);
    //     this.reportMessage = res.result;
    //   });
    // },
    //获取报告详情数据
  },
};
</script>
<style lang="scss" scoped>
#add_report {
  .detail {
    height: 100%;
  }
  .header {
    display: flex;
    justify-content: space-between;
    font-size: 12px;
    height: 30px;
    .el-input__inner {
      height: 25px;
    }
    p {
      color: #797979;
      display: flex;
      justify-content: center;
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
    > div {
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
    height: 35px !important;
    display: flex;
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
<style lang="scss">
#add_report {
  .el-message-box {
    width: auto !important;
  }
  //   注意 修改element-ui弹窗的样式不能在添加了scoped的style中修改，解决方法：另写一个style添加样式
  .header .el-input__inner {
    height: 30px;
  }
  .header .el-form-item__content {
    width: 105px;
  }
  .main .dis {
    height: 30px;
    .el-input {
      width: 160px;
      flex: 0 0 160px;
      margin-right: 15px;
    }
    .el-input__inner {
      height: 32px;
    }
  }
}
</style>
