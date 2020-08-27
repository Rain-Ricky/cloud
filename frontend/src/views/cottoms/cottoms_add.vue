<template>
  <!-- 添加电子病历 -->
  <div id="cottomsAdd">
    <el-container>
      <el-header class="header">
        <h1>病例夹</h1>
      </el-header>
      <el-divider></el-divider>
      <el-main>
        <el-row>
          <el-col :span="7">
            <el-form
              :model="userInfo"
              ref="ruleForm"
              label-width="100px"
              class="demo-ruleForm"
            >
              <el-form-item label="患者姓名" prop="username">
                <el-input v-model="userInfo.username"></el-input>
              </el-form-item>
              <el-row class="formInline">
                <el-col :span="11">
                  <el-form-item label="性别" prop="gender">
                    <el-select v-model="userInfo.gender" placeholder="性别">
                      <el-option label="男" value="1"></el-option>
                      <el-option label="女" value="0"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="11" :offset="2">
                  <el-form-item label="年龄" prop="addAge">
                    <el-input v-model="addAge"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>

              <el-form-item label="就诊日期">
                <el-col :span="10">
                  <el-input
                    placeholder="选择年份"
                    v-model="userInfo.year"
                  ></el-input>
                </el-col>
                <el-col :span="2" style="text-align:center;"
                  >&nbsp;&nbsp;年</el-col
                >
                <el-col :span="10">
                  <el-input
                    placeholder="选择月份"
                    v-model="userInfo.month"
                  ></el-input>
                </el-col>
                <el-col :span="2" style="text-align:center;">&nbsp;月</el-col>
              </el-form-item>
              <el-form-item label="联系电话" prop="phone">
                <el-input v-model="userInfo.phone"></el-input>
              </el-form-item>
              <el-form-item label="地址" prop="adress">
                <el-input v-model="userInfo.address"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="1" class="divider">
            <el-divider direction="vertical"></el-divider>
          </el-col>

          <el-col :span="7">
            <el-form
              :model="addCottoms"
              ref="ruleForm"
              label-width="100px"
              class="demo-ruleForm"
            >
              <el-form-item label="就诊科室">
                <el-select
                  v-model="departvalue"
                  placeholder="就诊科室"
                  @change="getDoctor"
                >
                  <el-option
                    v-for="item in PartmentList"
                    :key="item.id"
                    :label="item.departmentname"
                    :value="item.id"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="病情描述" prop="description">
                <el-input
                  v-model="addCottoms.description"
                  type="textarea"
                  :rows="6"
                  resize="none"
                ></el-input>
              </el-form-item>

              <el-form-item label="过敏史" prop="guomishi">
                <el-input v-model="addCottoms.guomishi"></el-input>
              </el-form-item>
              <el-form-item label="诊断医生" prop="">
                <el-select v-model="doctorvalue" placeholder="诊断医生">
                  <el-option
                    v-for="item in doctorList"
                    :key="item.id"
                    :label="item.username"
                    :value="item.id"
                  >
                  </el-option>
                </el-select>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="1" class="divider">
            <el-divider direction="vertical"></el-divider>
          </el-col>
          <el-col :span="7">
            <el-form :model="addCottoms" ref="ruleForm" class="demo-ruleForm">
              <el-form-item label="用药详情" prop="comment">
                <el-input
                  v-model="addCottoms.comment"
                  type="textarea"
                  :rows="4"
                  resize="none"
                ></el-input>
              </el-form-item>
              <el-form-item label="备注" prop="remark">
                <el-input
                  v-model="addCottoms.remark"
                  type="textarea"
                  :rows="4"
                  resize="none"
                ></el-input>
              </el-form-item>

              <el-form-item label="上传诊断报告" prop="">
                <el-input type="textarea" :rows="4" resize="none"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
        </el-row>
      </el-main>
      <div class="footer">
        <p class="bg16d" plain @click="addCottom">保存</p>
        <p @click="addCottoms = {}">取消</p>
      </div>
    </el-container>

    <el-dialog title="查询" :visible.sync="dialogFormVisible" width="35%">
      <el-form :model="phone">
        <el-form-item label="请输入手机号" :label-width="formLabelWidth">
          <el-input v-model="phone.num" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button round @click="getInfo" class="bg16d">确定</el-button>
        <el-button round @click="dialogFormVisible = false">取 消</el-button>
      </div>
    </el-dialog>

    <el-dialog
      title="提示"
      :visible.sync="centerDialogVisible"
      width="30%"
      center
    >
      <span>未找到患者信息,请输入正确的手机号</span>
      <span slot="footer" class="dialog-footer">
        <el-button round class="bg16d" @click="repeat">确定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
export default {
  data() {
    return {
      userInfo: {
        birthday: "",
      },
      //根据手机号码获取到的用户的信息
      phone: {
        num: "",
      },
      //输入查询的手机号码

      dialogFormVisible: true,
      //定义输入手机号码的弹窗是否显示
      centerDialogVisible: false,
      //定义提示手机号码不正确的弹窗是否显示
      formLabelWidth: "120px",

      addCottoms: {
        description: "",
        guomishi: "",
        prescription: "",
        comment: "",
        remark: "",
      },
      // 添加病例的病情信息

      PartmentList: [],
      //科室信息列表
      departvalue: "",
      // 被选中的科室信息

      doctorList: [],
      // 选中科室下的医生信息
      doctorvalue: "",
      // 选中的诊断医生value
    };
  },

  mounted() {
    this.getPartMentList();
    // 进入页面就获取科室信息列表
  },

  computed: {
    addAge() {
      let year = new Date().getFullYear();
      let bir = this.userInfo.birthday.split("-")[0];
      return year - bir;
    },
  },
  // 计算用户年龄

  methods: {
    getUserInfo() {
      this.$http("/user/findByPhone", "post", {
        phone: this.phone.num,
      }).then((res) => {
        if (res.msg == "ok") {
          this.userInfo = res.result;
        } else {
          this.centerDialogVisible = true;
          this.dialogFormVisible = false;
        }
      });
    },
    // 根据手机号码获取用户信息

    getInfo() {
      this.dialogFormVisible = false;
      this.getUserInfo();
    },
    //点击手机号码确认框确认时执行函数

    repeat() {
      this.centerDialogVisible = false;
      this.dialogFormVisible = true;
    },

    //如果手机号码输入不对，那就再次显示电话号码输入框

    getPartMentList() {
      this.$http("/departmentinfo/list", "get").then((res) => {
        this.PartmentList = res.result;
      });
    },
    //获取科室信息列表

    getDoctor() {
      this.doctorvalue = "";
      this.$http("/empinfo/findByDid", "get", { id: this.departvalue }).then(
        (res) => {
          this.doctorList = res.result;
        }
      );
    },
    // 根据科室信息获取医生信息

    addCottom() {
      this.$http(
        "/medicalrecord/insert",
        "post",
        Object.assign(this.addCottoms, {
          phone: this.userInfo.phone,
          seektime: this.userInfo.year + "-" + this.userInfo.month,
          userId: this.userInfo.id,
          docId: this.doctorvalue,
          departmentId: this.departvalue,
        })
      ).then((res) => {
        // console.log(res);
        if (res.suc == true) {
          this.$message({
            showClose: true,
            message: "添加病例成功",
            type: "success",
          });
        } else {
          this.$message({
            showClose: true,
            message: "添加病例失败",
            type: "error",
          });
        }
        // 成功的弹窗和失败的弹窗
      });
    },
    // 添加病例
    // 检查结果	Checkinfo
    // 诊断结果	diagnosis
    // 这两个字段未上传
  },

  // 取消按钮还没写
};
</script>
<style lang="scss" scoped>
#cottomsAdd {
  .header {
    h1 {
      font-weight: normal;
    }
    display: flex;
    justify-content: space-between;
  }
  .el-main {
    padding-top: 0;
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
  .el-dialog {
    border-radius: 10px;
    .el-button {
      width: 100px;
    }
    .el-button:nth-child(2) {
      background: #ccc;
    }
  }
}
</style>
<style lang="scss">
#cottomsAdd {
  .el-form-item__content {
    margin-left: 0px !important;
  }
  .el-form-item__label {
    width: 100% !important;
    text-align: left !important;
  }
  .el-form-item {
    margin-bottom: 10px;
  }
}
</style>
