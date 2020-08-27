<template>
  <div id="checkReport">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item>
        <el-input
          v-model="formInline.userName"
          placeholder="请输入患者姓名"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-date-picker
          v-model="formInline.date"
          type="date"
          :value="null ? '' : formInline.date"
          placeholder="选择日期"
          value-format="yyyy-MM-dd"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-input
          v-model="formInline.item"
          placeholder="请输入检查项目"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button icon="el-icon-search" circle></el-button>
      </el-form-item>
    </el-form>

    <el-table :data="tables" style="width: 100%">
      <el-table-column prop="checkId" label="序号" width="60">
      </el-table-column>
      <el-table-column prop="conName" label="姓名" width="70">
      </el-table-column>
      <el-table-column label="性别" width="60">
        <template slot-scope="scope">
          <span>{{ scope.row.gender == 1 ? "男" : "女" }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="age" label="年龄" width="60"> </el-table-column>
      <el-table-column prop="deName" label="就诊科室"> </el-table-column>
      <el-table-column prop="diType" label="诊断类型">
        <template slot-scope="scope">
          <span>{{ scope.row.diType == 1 ? "初诊" : "复诊" }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="seektime" label="检查时间" width="180">
      </el-table-column>
      <el-table-column prop="insp" label="检查项目" width="220">
      </el-table-column>
      <el-table-column prop="done" label="操作">
        <template slot-scope="scope">
          <el-button size="mini" type="primary" @click="$router.push({path:'/doctor/report/detail',query:{id:scope.row.checkId}})">查看详情</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 使用element-ui里的表格展示请求到的数据 -->

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
        item: "",
        date: "",
      },
      //定义查询的表单元素
      reportData: [],
      //报告列表数据

      currentPage: 1,
      //当前点击页码数
      pageSize: 10,
      //每页展示数目
    };
  },
  mounted() {
    this.getReportList();
  },
  //进入页面请求报告列表数据
  methods: {
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
       this.getReportList();
    },//点击分页时改变当前页码，重新请求数据
    getReportList() {
      this.$http("/ds1/checkreport/getCheckReportList", "post", {
        pageNo: this.currentPage,
        pageSize: 10,
      }).then((res) => {
        this.reportData = res.result;
      });
    },
    //请求报告列表数据
  },
  computed: {
    tables() {
      return this.reportData.filter((item) => {
        return (
          item.conName.includes(this.formInline.userName) &&
          item.insp.includes(this.formInline.item) &&
          item.seektime.includes(
            this.formInline.date == null ? "" : this.formInline.date
          )
        );
      });
    },
    //根据查询条件过滤报告列表数据
  },
};
</script>
<style lang="scss">
#checkReport {
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
}
</style>
