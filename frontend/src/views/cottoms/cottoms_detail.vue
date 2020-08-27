<template>
  <!-- 电子病例详情页 -->
  <div id="cottomsDetail">
    <el-container>
      <el-header class="header">
        <h1>病例夹</h1>
        <p v-if="!revamp" style="color:red;" @click="edit">
          <i class="el-icon-edit"></i>
          修改信息
        </p>
        <!-- 修改信息按钮 该按钮是否显示由revamp变量控制，点击时候执行edit方法 -->
      </el-header>
      <!-- 头部导航内容 -->

      <el-divider></el-divider>

      <el-main>
        <el-row>
          <el-col :span="7">
            <el-form
              :model="cottomsDetail"
              ref="ruleForm"
              label-width="100px"
              class="demo-ruleForm"
              :disabled="!revamp"
            >
              <el-form-item label="患者姓名" prop="name">
                <el-input v-model="cottomsDetail.userinfo.username"></el-input>
              </el-form-item>
              <el-row class="formInline">
                <el-col :span="11">
                  <el-form-item label="性别" prop="sex">
                    <el-select
                      v-model="cottomsDetail.userinfo.gender"
                      placeholder="性别"
                    >
                      <el-option label="男" value="1"></el-option>
                      <el-option label="女" value="0"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="11" :offset="2">
                  <el-form-item label="年龄" prop="age">
                    <el-input v-model="cottomsAge"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>

              <el-form-item label="就诊日期">
                <el-col :span="10">
                  <!-- <el-date-picker
                    type="year"
                    placeholder="选择年份"
                    style="width: 100%;"
                    v-model="cottomsDetail.seektime"
                  ></el-date-picker> -->

                  <el-input
                    :placeholder="date.year"
                    v-model="date.year"
                    :value="date.year"
                  ></el-input>
                </el-col>
                <el-col :span="2" style="text-align:center;"
                  >&nbsp;&nbsp;年</el-col
                >
                <el-col :span="10">
                  <!-- <el-date-picker
                    placeholder="选择月份"
                    style="width: 100%;"
                    type="month"
                    v-model="cottomsDetail.seektime"
                  ></el-date-picker> -->
                  <el-input
                    :placeholder="date.month"
                    :value="date.month"
                    v-model="date.month"
                  ></el-input>
                </el-col>
                <el-col :span="2" style="text-align:center;">&nbsp;月</el-col>
              </el-form-item>
              <el-form-item label="联系电话" prop="name">
                <el-input v-model="cottomsDetail.phone"></el-input>
              </el-form-item>
              <el-form-item label="地址" prop="name">
                <el-input v-model="cottomsDetail.userinfo.address"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="1" class="divider">
            <el-divider direction="vertical"></el-divider>
          </el-col>

          <el-col :span="7">
            <el-form
              :disabled="!revamp"
              :model="cottomsDetail"
              ref="ruleForm"
              label-width="100px"
              class="demo-ruleForm"
            >
              <el-form-item label="就诊科室" prop="name">
                <el-input
                  v-model="cottomsDetail.departmentinfo.departmentname"
                ></el-input>
              </el-form-item>
              <el-form-item label="病情描述" prop="name">
                <el-input
                  v-model="cottomsDetail.description"
                  type="textarea"
                  :rows="6"
                  resize="none"
                ></el-input>
              </el-form-item>

              <el-form-item label="过敏史" prop="name">
                <el-input v-model="cottomsDetail.guomishi"></el-input>
              </el-form-item>
              <el-form-item label="诊断医生" prop="name">
                <el-input v-model="cottomsDetail.empinfo.username"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="1" class="divider">
            <el-divider direction="vertical"></el-divider>
          </el-col>
          <el-col :span="7">
            <el-form
              :disabled="!revamp"
              :model="cottomsDetail"
              ref="ruleForm"
              class="demo-ruleForm"
            >
              <el-form-item label="用药详情" prop="name">
                <el-input
                  v-model="cottomsDetail.comment"
                  type="textarea"
                  :rows="4"
                  resize="none"
                ></el-input>
              </el-form-item>
              <el-form-item label="备注" prop="name">
                <el-input
                  v-model="cottomsDetail.remark"
                  type="textarea"
                  :rows="4"
                  resize="none"
                ></el-input>
              </el-form-item>

              <el-form-item label="上传诊断报告" prop="name">
                <!-- <el-input
                  v-model="cottomsDetail.name"
                  type="textarea"
                  :rows="4"
                  resize="none"
                ></el-input> -->
                <div>
                  <img
                    src="../../assets/img/upload_bg.png"
                    style="border:1px solid #DCDFE6;"
                    alt=""
                  />
                </div>
              </el-form-item>
            </el-form>
          </el-col>
        </el-row>
      </el-main>
      <div class="footer" v-if="revamp">
        <p class="bg16d" plain @click="save">保存</p>
        <p @click="cancel">取消</p>
      </div>
    </el-container>
  </div>
</template>
<script>
import cottoms_listVue from "./cottoms_list.vue";
export default {
  data() {
    return {
      revamp: false,
      //   是否修改数据
      date: {
        year: "",
        month: "",
      },
      //定义时间变量 以便后期拼接后向后台传递数据

      // cottomsDetail是保存病例详情的变量
      cottomsDetail: {
        id: null,
        recordCode: "67359425737", //病历编号
        phone: "13734741054", //用户手机号
        departmentId: 37, //就诊科室ID
        seektime: "2020-04-16 00:00:00", //就诊日期
        description: "感觉很难受，很恍惚，不清醒", //病情描述
        guomishi: "无过敏史", //过敏史
        diagnosis: "神经衰弱", //诊断结果
        prescription: "住院治疗", //处方
        userId: null, //用户id
        docId: null, //医生ID
        comment: "一天一次，一次20分钟", //用药详情
        remark: "注意不要情绪过激", //备注
        state: null,
        createTime: null, //创建时间
        updateTime: null, //修改时间
        empinfo: {
          //下面这部分和根据科室ID查询该科室医生注释一样~~~，都是医生信息
          id: 34,
          username: "王医生",
          password: "111111",
          birthday: "2020-04-01 15:35:20",
          phone: "13734741053",
          address: "河南-郑州-金水",
          roleId: 1,
          depId: 34,
          titleId: 33,
          comment: "医生界的扛把子，抗击新冠肺炎一马当先",
          headimg: null,
          experience: "10",
          state: 1,
        },
        diagnostictype: null, //诊断类型
        userinfo: {
          //下面这不分和根据手机号查询用户信息注释一样~~~，都是用户信息
          id: 34,
          username: "jklive",
          password: "123456",
          roleid: 1,
          phone: "13734741053",
          validatecode: null,
          cid: "15262919956789003",
          birthday: "2020-04-01 15:33:30",
          gender: "1",
          frontimg:
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3497380956,3644779616&fm=26&gp=0.jpg",
          backimg:
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3387134982,2837425777&fm=26&gp=0.jpg",
          address: "河南省-郑州市",
          bedno: null,
          departmentid: null,
          doctorid: null,
          nurseid: null,
          instatus: null,
          state: 1,
        },
        departmentinfo: {
          id: 34,
          departmentname: "眼科",
          institutionId: null,
        },
      },
    };
  },
  mounted() {
    this.getCottomsDetail();
  },
  // 进入页面的时候加载病例详情数据
  computed: {
    cottomsAge() {
      let year = new Date().getFullYear();
      let bir = this.cottomsDetail.userinfo.birthday.split("-")[0];
      return year - bir;
    },
    // 根据用户的出生日期计算用户的年龄
  },
  methods: {
    getCottomsDetail() {
      this.$http("/medicalrecord/detail", "get", {
        id: this.$route.query.id,
        //通过this.$route.query.id获取到跳转时传递过来的id数据，作为参数传递给服务器，告诉服务器要请求的是哪个病历的详情信息
      }).then((res) => {
        // console.log(res.result);
        this.cottomsDetail = res.result;
        this.date.year = this.cottomsDetail.seektime.split("-")[0];
        this.date.month = this.cottomsDetail.seektime.split("-")[1];
        //拆分seektime为年月
      });
    },
    //获取病例详情数据

    edit() {
      this.revamp = true;
      this.copyCottomsMessage = JSON.parse(JSON.stringify(this.cottomsDetail));
    },
    // 点击编辑按钮，让变量revamp变为true，然后把cottomsDetail数据深拷贝一份保存下来

    cancel() {
      this.revamp = false;
      this.cottomsDetail = this.copyCottomsMessage;
    },
    //点击取消编辑按钮的时候，让commentsDetail数据变为修改前的数据（在编辑时保存的copyCottomsMessage）

    save() {
      let {
        id,
        userId,
        gender,
        seektime,
        phone,
        description,
        guomishi,
        prescription,
        comment,
        remark,
      } = this.cottomsDetail;
      // 解构出cottomsDetail中需要的字段，保存下来，在请求接口的时候作为参数传递
      this.$http(
        "/medicalrecord/update",
        "post",

        {
          id,
          userId: this.cottomsDetail.userinfo.id,
          gender: this.cottomsDetail.userinfo.gender,
          address: this.cottomsDetail.userinfo.address,
          seektime: this.date.year + "-" + this.date.month,
          phone,
          departmentId: this.cottomsDetail.departmentinfo.id,
          description,
          guomishi,
          prescription,
          comment,
          remark,
          doctorid: this.cottomsDetail.empinfo.id,
          username: this.cottomsDetail.userinfo.username,
          // 拿到需要的字段传递给后台，seektime对date进行拼接
        }
      ).then((res) => {
        if (res.msg == "ok") {
          this.revamp = false;
        } else {
          this.$message({
            showClose: true,
            message: "修改失败",
            type: "error",
          });
        }
      });
    },
    // 点击保存按钮时把修改的内容通过接口传给后台进行保存
  },
};
</script>
<style lang="scss" scoped>
#cottomsDetail {
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
}
</style>
<style lang="scss">
#cottomsDetail {
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
