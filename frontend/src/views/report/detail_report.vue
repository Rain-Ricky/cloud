<template>
  <div id="detail_report">
    <el-container
      v-for="(item, index) in reportMessage"
      :key="index"
      class="detail"
    >
      <el-header class="header">
        <p>
          姓名：
          <span>{{ item.conName }}</span>
        </p>
        <p>
          性别：
          <span>{{ item.gende == 1 ? "男" : "女" }}</span>
        </p>
        <p>
          年龄：
          <span>{{ item.age }}</span>
        </p>
        <p>
          科别：
          <span>{{ item.deName }}</span>
        </p>
        <p>
          诊断类型：
          <span>{{ item.diType == 1 ? "初诊" : "复诊" }}</span>
        </p>
        <p v-if="!revise" style="color:red;" @click="edit">
          <i class="el-icon-edit"></i>
          修改信息
        </p>
        <p v-else>
          <el-button type="danger" round size="mini" @click="cancel"
            >取消</el-button
          >
          <el-button type="success" round size="mini" @click="save"
            >保存</el-button
          >
        </p>
      </el-header>
      <el-main class="main">
        <div>
          <span> 临床诊断：</span>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="item.symptom"
            class="revise_con"
            v-if="revise"
            resize="none"
          >
          </el-input>
          <p v-else>{{ item.symptom }}</p>
          <!-- 当点击修改时，展示input框，其他时候显示p标签 -->
        </div>
        <div>
          <span> 大体检查：</span>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="item.dtjc"
            class="revise_con"
            v-if="revise"
          >
          </el-input>
          <p v-else>{{ item.dtjc }}</p>
        </div>
        <div>
          <span> 病理诊断：</span>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="item.blzd"
            class="revise_con"
            v-if="revise"
          >
          </el-input>
          <p v-else>{{ item.blzd }}</p>
        </div>
        <div>
          <span> 免疫/组化：</span>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="item.mianyi"
            class="revise_con"
            v-if="revise"
          >
          </el-input>
          <p v-else>{{ item.mianyi }}</p>
        </div>
        <div>
          <span>结果：</span>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="item.result"
            class="revise_con"
            v-if="revise"
          >
          </el-input>
          <p v-else>{{ item.result }}</p>
        </div>
        <div>
          <span> 备注：</span>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="item.mark"
            class="revise_con"
            v-if="revise"
          >
          </el-input>
          <p v-else>{{ item.mark }}</p>
        </div>
      </el-main>
      <el-divider></el-divider>
      <el-footer class="footer">
        <p>报告医师：{{ item.bgysName }}</p>
        <p>审核医师：{{ item.shysName }}</p>
        <p>报告时间：{{ item.seektime }}</p>
        <p>
          <el-button type="success" class="bg16d" @click="getReport"
            >查看附件</el-button
          >
        </p>
      </el-footer>
    </el-container>
  </div>
</template>
<script>
export default {
  data() {
    return {
      reportMessage: [],
      // 保存报告详情
      //   reportImg:""
      // 保存报告单图片
      revise: false, //是否修改报告内容\
      copyReportMessage: "",
      checkId: this.$route.query.id,
    };
  },

  mounted() {
    this.getReportMessage();
  },

  methods: {
    getReportMessage() {
      this.$http("/ds1/checkreport/getCheckDetailById", "post", {
        checkId: this.checkId,
      }).then((res) => {
        console.log(res);
        this.reportMessage = res.result;
      });
    },
    //获取报告详情数据

    checkReport() {
      this.$http("/ds1/checkreport/getAttachmentUrl", "post", {
        checkId: this.checkId,
      }).then((res) => {
        this.$alert("<img src=" + res.result + ">", {
          dangerouslyUseHTMLString: true,
          showConfirmButton: false,
        });
        // 拿到图片src并在弹窗中显示出来
      });
    },
    //获取报告单图片数据

    getReport() {
      this.checkReport();
    },
    // 在点击查看附件的时候显示详情图片

    edit() {
      this.revise = true;
      this.copyReportMessage = JSON.parse(JSON.stringify(this.reportMessage));
    },
    // 点击编辑按钮，让变量revise变为true，然后把report数据深拷贝一份保存下来

    cancel() {
      this.revise = false;
      this.reportMessage = this.copyReportMessage;
    },
    //点击取消编辑按钮的时候，让reportmessag数据变为修改前的数据（在编辑时保存的copyReportMessage）

    save() {
      this.$http(
        "/ds1/checkreport/updateCheckById",
        "post",
        Object.assign(this.reportMessage[0], { checkId: this.checkId })
      ).then((res) => {
        console.log(res);
        this.revise = false;
      });
    },
    // 点击保存按钮时把checkid和修改的内容通过接口传给后台进行保存
  },
};
</script>
<style lang="scss" scoped>
#detail_report {
  .detail {
    height: 100%;
  }
  .header {
    display: flex;
    justify-content: space-between;
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
