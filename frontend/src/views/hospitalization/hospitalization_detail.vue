<template>
  <div id="cottomsDetail">
    <el-container>
      <el-header class="header">
        <h1>病例夹</h1>
        <p v-if="!revamp" style="color:red;" @click="revamp = true">
          <i class="el-icon-edit"></i>
          修改信息
        </p>
      </el-header>
      <el-divider></el-divider>
      <el-main>
        <el-row>
          <el-col :span="7">
            <el-form
              :model="detailForm"
              ref="ruleForm"
              label-width="100px"
              class="demo-ruleForm"
            >
              <el-form-item label="患者姓名" prop="name">
                <el-input v-model="detailForm.name"></el-input>
              </el-form-item>
              <el-row class="formInline">
                <el-col :span="11">
                  <el-form-item label="性别" prop="sex">
                    <el-select v-model="detailForm.sex" placeholder="性别">
                      <el-option label="男" value="男"></el-option>
                      <el-option label="女" value="女"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="11" :offset="2">
                  <el-form-item label="年龄" prop="age">
                    <el-input v-model="detailForm.age"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>

              <el-form-item label="就诊日期">
                <el-col :span="10">
                  <el-date-picker
                    type="year"
                    placeholder="选择年份"
                    style="width: 100%;"
                  ></el-date-picker>
                </el-col>
                <el-col :span="2" style="text-align:center;"
                  >&nbsp;&nbsp;年</el-col
                >
                <el-col :span="10">
                  <el-date-picker
                    placeholder="选择月份"
                    style="width: 100%;"
                    type="month"
                  ></el-date-picker>
                </el-col>
                <el-col :span="2" style="text-align:center;">&nbsp;月</el-col>
              </el-form-item>
              <el-form-item label="联系电话" prop="name">
                <el-input v-model="detailForm.name"></el-input>
              </el-form-item>
              <el-form-item label="地址" prop="name">
                <el-input v-model="detailForm.name"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="1" class="divider">
            <el-divider direction="vertical"></el-divider>
          </el-col>

          <el-col :span="7">
            <el-form
              :model="detailForm"
              ref="ruleForm"
              label-width="100px"
              class="demo-ruleForm"
            >
              <el-form-item label="就诊科室" prop="name">
                <el-input v-model="detailForm.name"></el-input>
              </el-form-item>
              <el-form-item label="病情描述" prop="name">
                <el-input
                  v-model="detailForm.name"
                  type="textarea"
                  :rows="6"
                  resize="none"
                ></el-input>
              </el-form-item>

              <el-form-item label="过敏史" prop="name">
                <el-input v-model="detailForm.name"></el-input>
              </el-form-item>
              <el-form-item label="诊断医生" prop="name">
                <el-input v-model="detailForm.name"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
          <el-col :span="1" class="divider">
            <el-divider direction="vertical"></el-divider>
          </el-col>
          <el-col :span="7">
            <el-form :model="detailForm" ref="ruleForm" class="demo-ruleForm">
              <el-form-item label="用药详情" prop="name">
                <el-input
                  v-model="detailForm.name"
                  type="textarea"
                  :rows="4"
                  resize="none"
                ></el-input>
              </el-form-item>
              <el-form-item label="备注" prop="name">
                <el-input
                  v-model="detailForm.name"
                  type="textarea"
                  :rows="4"
                  resize="none"
                ></el-input>
              </el-form-item>

              <el-form-item label="上传诊断报告" prop="name">
                <el-input
                  v-model="detailForm.name"
                  type="textarea"
                  :rows="4"
                  resize="none"
                ></el-input>
              </el-form-item>
            </el-form>
          </el-col>
        </el-row>
      </el-main>
      <div class="footer" v-if="revamp">
        <p class="bg16d" plain>保存</p>
        <p>取消</p>
      </div>
    </el-container>
  </div>
</template>
<script>
export default {
  data() {
    return {
      detailForm: {
        name: "",
        sex: "",
        age: "",
      },
      revamp: false,
      //   是否修改数据
    };
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
