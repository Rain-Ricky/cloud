<template>
  <div id="hospitalizationAdd">
    <el-container>
      <el-header class="header">
        <h1>添加住院信息</h1>
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

              <el-row class="formInline">
                <el-col :span="11">
                  <el-form-item label="住院状态" prop="sex">
                    <el-select v-model="detailForm.sex" placeholder="性别">
                      <el-option label="男" value="男"></el-option>
                      <el-option label="女" value="女"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="11" :offset="2">
                  <el-form-item label="入院日期" prop="sex">
                    <el-date-picker
                      v-model="detailForm.date"
                      type="date"
                      placeholder="选择日期"
                    >
                    </el-date-picker>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-form-item label="联系电话" prop="name">
                <el-input v-model="detailForm.name"></el-input>
              </el-form-item>
              <el-form-item label="预计出院日期" prop="name">
                <el-date-picker
                  v-model="detailForm.date"
                  type="date"
                  placeholder="选择日期"
                >
                </el-date-picker>
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
              <el-form-item label="病床号码" prop="name">
                <el-input v-model="detailForm.name"></el-input>
              </el-form-item>
              <el-form-item label="病情描述" prop="name">
                <el-input
                  v-model="detailForm.name"
                  type="textarea"
                  :rows="1"
                  resize="none"
                ></el-input>
              </el-form-item>

              <el-form-item label="过敏史" prop="name">
                <el-input v-model="detailForm.name"></el-input>
              </el-form-item>
              <el-form-item label="主治医生" prop="name">
                <el-input v-model="detailForm.name"></el-input>
              </el-form-item>
              <el-form-item label="责任护士" prop="name">
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
      <div class="footer">
        <p class="bg16d" plain>保存</p>
        <p>取消</p>
      </div>
    </el-container>

    <el-dialog title="查询" :visible.sync="dialogFormVisible" width="35%">
      <el-form :model="phone">
        <el-form-item label="请输入手机号" :label-width="formLabelWidth">
          <el-input v-model="phone.num" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button round @click="dialogFormVisible = false" class="bg16d"
          >确定</el-button
        >
        <el-button round @click="dialogFormVisible = false">取 消</el-button>
      </div>
    </el-dialog>
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
      phone: {
        num: "",
      },
      dialogFormVisible: true,
      formLabelWidth: "120px",
    };
  },
};
</script>
<style lang="scss" scoped>
#hospitalizationAdd {
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
#hospitalizationAdd {
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
  .el-date-editor.el-input,
  .el-date-editor.el-input__inner {
    width: auto;
  }
}
</style>
