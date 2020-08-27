<template>
  <div id="hospitalizationList">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item>
        <el-input
          v-model="formInline.userName"
          placeholder="请输入用户姓名"
        ></el-input>
      </el-form-item>

      <el-form-item>
        <el-date-picker
          v-model="formInline.date"
          type="date"
          :value="null ? '' : formInline.date"
          placeholder="选择入院时间"
          value-format="yyyy-MM-dd"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-input
          v-model="formInline.phoneNum"
          placeholder="请输入手机号码"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-input
          v-model="formInline.code"
          placeholder="请输入住院号"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-input
          v-model="formInline.userName"
          placeholder="请输入病床号"
        ></el-input>
      </el-form-item>

      <el-form-item>
        <el-button icon="el-icon-search" circle></el-button>
      </el-form-item>
    </el-form>

    <el-table
      :data="tables"
      style="width: 100%"
      @selection-change="handleSelectionChange"
      ref="multipleTable"
    >
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="checkId" label="住院号">
        <template slot-scope="scope">
          <span>{{ scope.row.recordCode }}</span>
        </template>
      </el-table-column>
      <el-table-column label="姓名">
        <template slot-scope="scope">
          <span>{{ scope.row.userinfo.username }}</span>
        </template>
      </el-table-column>
      <el-table-column label="性别">
        <template slot-scope="scope">
          <span>{{ scope.row.gender == 1 ? "男" : "女" }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="age" label="年龄">
        <template slot-scope="scope">
          <span>{{
            new Date().getFullYear() - scope.row.userinfo.birthday.split("-")[0]
          }}</span>
        </template>
      </el-table-column>

      <el-table-column prop="id" label="病床号"> </el-table-column>
      <el-table-column prop="deName" label="主治医生">
        <template slot-scope="scope">
          <span>{{ scope.row.empinfo.username }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column prop="deName" label="护士"> </el-table-column> -->
      <!-- <el-table-column prop="state" label="住院状态"> </el-table-column> -->
      <el-table-column prop="deName" label="入院时间">
        <template slot-scope="scope">
          <span>{{ scope.row.seektime.split(" ")[0] }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="deName" label="诊断情况">
        <template slot-scope="scope">
          <span>{{ scope.row.description }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column prop="deName" label="出院时间"> </el-table-column> -->

      <el-table-column prop="done" label="操作">
        <template slot-scope="scope">
          <i
            class="el-icon-edit"
            @click="
              $router.push({
                path: '/doctor/hospitalization/detail',
                query: { id: scope.row.id },
              })
            "
          ></i>
          <i class="el-icon-circle-close"></i>
        </template>
      </el-table-column>
    </el-table>
    <!-- 使用element-ui里的表格展示请求到的数据 -->

    <div class="beatch_remove">
      <el-button @click="betchDel" round type="danger" icon="el-icon-delete"
        >批量删除</el-button
      >
    </div>

    <el-pagination
      class="page"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page.sync="currentPage"
      background
      :page-size="10"
      layout="prev, pager, next, jumper"
      :total="100"
    >
    </el-pagination>
    <!-- 分页效果 -->
  </div>
</template>
<script>
export default {
  data() {
    return {
      formInline: {
        userName: "",
        code: "",
        phoneNum: "",
        date: "",
      },
      //定义查询的表单元素

      currentPage: 1,
      //当前点击页码数
      pageSize: 10,
      //每页展示数目

      multipleSelection: [],
      // 被选中的列表数据

      hospitalList: [],
    };
  },
  mounted() {
    this.getHospitalList();
  },
  //进入页面请求报告列表数据
  methods: {
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
    }, //点击分页时改变当前页码，重新请求数据
    betchDel() {
      //批量删除
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },

    getHospitalList() {
      this.hospitalList = [
        {
          id: 38,
          recordCode: "03797049661",
          phone: "1500000003",
          departmentId: 34,
          seektime: "2019-10-12 00:00:00",
          description: "胃部炎症很严重7",
          guomishi: "无过敏史",
          diagnosis: "胃穿孔",
          prescription: "吃一些健胃消食片",
          userId: null,
          docId: null,
          comment: "一次三片 一天三次",
          remark: "注意不要喝酒",
          state: null,
          createTime: null,
          updateTime: null,
          empinfo: {
            id: 33,
            username: "张医生",
            password: "111111",
            birthday: "2020-04-16 14:40:02",
            phone: "15700085557",
            address: "河南-商丘-夏邑",
            roleId: 1,
            depId: 33,
            titleId: 33,
            comment: "医生界的一枝花，抗击新冠肺炎卓有成效",
            headimg: null,
            experience: "5",
            state: 1,
          },
          diagnostictype: null,
          userinfo: {
            id: null,
            username: "ykq611111111",
            password: null,
            roleid: null,
            phone: "1500000003",
            validatecode: null,
            cid: null,
            birthday: "2020-04-01 10:04:08",
            gender: "1",
            frontimg: null,
            backimg: null,
            address: "河南省-商丘市",
            bedno: null,
            departmentid: null,
            doctorid: null,
            nurseid: null,
            instatus: null,
            state: null,
          },
          departmentinfo: {
            id: 34,
            departmentname: "眼科",
            institutionId: null,
          },
        },
        {
          id: 39,
          recordCode: "49222424520",
          phone: "13734741053",
          departmentId: 34,
          seektime: "2020-04-16 00:00:00",
          description: "眼睛很痛，东西看不清楚",
          guomishi: "无过敏史",
          diagnosis: "红眼病",
          prescription: "滴光明牌眼药水",
          userId: null,
          docId: null,
          comment: "一天三次，一次5ml",
          remark: "注意不要揉眼睛",
          state: null,
          createTime: null,
          updateTime: null,
          empinfo: {
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
          diagnostictype: null,
          userinfo: {
            id: null,
            username: "jklive",
            password: null,
            roleid: null,
            phone: "13734741053",
            validatecode: null,
            cid: null,
            birthday: "2020-04-01 15:33:30",
            gender: "1",
            frontimg: null,
            backimg: null,
            address: "河南省-郑州市",
            bedno: null,
            departmentid: null,
            doctorid: null,
            nurseid: null,
            instatus: null,
            state: null,
          },
          departmentinfo: {
            id: 34,
            departmentname: "眼科",
            institutionId: null,
          },
        },
        {
          id: 41,
          recordCode: "67359425737",
          phone: "13734741054",
          departmentId: 37,
          seektime: "2020-04-16 00:00:00",
          description: "感觉很难受，很恍惚，不清醒",
          guomishi: "无过敏史",
          diagnosis: "神经衰弱",
          prescription: "住院治疗",
          userId: null,
          docId: null,
          comment: "一天一次，一次20分钟",
          remark: "注意不要情绪过激",
          state: null,
          createTime: null,
          updateTime: null,
          empinfo: {
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
          diagnostictype: null,
          userinfo: {
            id: null,
            username: "jklive",
            password: null,
            roleid: null,
            phone: "13734741054",
            validatecode: null,
            cid: null,
            birthday: "2020-04-01 15:33:30",
            gender: "1",
            frontimg: null,
            backimg: null,
            address: "河南省-郑州市",
            bedno: null,
            departmentid: null,
            doctorid: null,
            nurseid: null,
            instatus: null,
            state: null,
          },
          departmentinfo: {
            id: 37,
            departmentname: "神经科",
            institutionId: null,
          },
        },
        {
          id: 42,
          recordCode: "01179565860",
          phone: "13734741055",
          departmentId: 38,
          seektime: "2020-04-16 00:00:00",
          description: "感觉很疼",
          guomishi: "无过敏史",
          diagnosis: "妇科炎症",
          prescription: "住院治疗",
          userId: null,
          docId: null,
          comment: "一天一次，一次20分钟",
          remark: "注意好好保养",
          state: null,
          createTime: null,
          updateTime: null,
          empinfo: {
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
          diagnostictype: null,
          userinfo: {
            id: null,
            username: "jklive",
            password: null,
            roleid: null,
            phone: "13734741055",
            validatecode: null,
            cid: null,
            birthday: "2020-04-01 15:33:30",
            gender: "1",
            frontimg: null,
            backimg: null,
            address: "河南省-郑州市",
            bedno: null,
            departmentid: null,
            doctorid: null,
            nurseid: null,
            instatus: null,
            state: null,
          },
          departmentinfo: {
            id: 38,
            departmentname: "精神科",
            institutionId: null,
          },
        },
        {
          id: 44,
          recordCode: "38444916294",
          phone: "13739999001",
          departmentId: 38,
          seektime: "2020-01-27 00:00:00",
          description: "感冒发烧",
          guomishi: "无过敏史",
          diagnosis: "轻微感冒",
          prescription: "快克",
          userId: null,
          docId: null,
          comment: "一天一次，一次一片",
          remark: "不要着凉",
          state: null,
          createTime: null,
          updateTime: null,
          empinfo: {
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
          diagnostictype: null,
          userinfo: {
            id: null,
            username: "jklive",
            password: null,
            roleid: null,
            phone: "13739999001",
            validatecode: null,
            cid: null,
            birthday: "2020-04-01 15:33:30",
            gender: "1",
            frontimg: null,
            backimg: null,
            address: "河南省-郑州市",
            bedno: null,
            departmentid: null,
            doctorid: null,
            nurseid: null,
            instatus: null,
            state: null,
          },
          departmentinfo: {
            id: 38,
            departmentname: "精神科",
            institutionId: null,
          },
        },
      ];

      // this.$http("/medicalrecord/list", "post", {
      //   pageNo: this.currentPage,
      //   pageSize: 10,
      // }).then((res) => {
      //   this.cottomsList = res.result.list;
      // });
    },
  },
  computed: {
    tables() {
      return this.hospitalList.filter((item) => {
        console.log(item);
        return (
          item.userinfo.username.includes(this.formInline.userName) &&
          item.recordCode.includes(this.formInline.code) &&
          item.seektime.includes(
            this.formInline.date == null ? "" : this.formInline.date
          )
        );
      });
    },
    // 根据查询条件过滤报告列表数据,
  },
};
</script>
<style lang="scss">
#hospitalizationList {
  position: relative;
  .el-input__inner {
    border-radius: 20px;
  }
  .page {
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    bottom: 20px;
  }
  .beatch_remove {
    position: absolute;
    bottom: 20px;
    left: 50px;
  }
  .el-form--inline .el-form-item,
  .el-date-editor.el-input,
  .el-date-editor.el-input__inner {
    width: 150px;
  }
}
</style>
