<template>
  <!-- 电子病例分页列表页 -->
  <div id="cottomsList">
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
          placeholder="选择就诊时间"
          value-format="yyyy-MM-dd"
        >
        </el-date-picker>
      </el-form-item>

      <el-form-item>
        <el-button icon="el-icon-search" circle></el-button>
      </el-form-item>
    </el-form>
    <!-- 筛选列表内容 -->

    <el-table
      :data="cottomsList"
      style="width: 100%"
      @selection-change="handleSelectionChange"
      ref="multipleTable"
    >
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column label="住院号" width="150">
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
          <span>{{ scope.row.userinfo.gender == 1 ? "男" : "女" }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="age" label="年龄">
        <template slot-scope="scope">
          <span>{{
            new Date().getFullYear() - scope.row.userinfo.birthday.split("-")[0]
          }}</span>
        </template>
      </el-table-column>

      <el-table-column prop="deName" label="省">
        <template slot-scope="scope">
          <span>{{ scope.row.userinfo.address.split("-")[0] }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="deName" label="市">
        <template slot-scope="scope">
          <span>{{ scope.row.userinfo.address.split("-")[1] }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="deName" label="就诊科室">
        <template slot-scope="scope">
          <span>{{ scope.row.departmentinfo.departmentname }}</span>
        </template>
      </el-table-column>
      <el-table-column prop="deName" label="诊断类型"> </el-table-column>
      <el-table-column label="就诊时间" width="100">
        <template slot-scope="scope">
          <span>{{ scope.row.seektime.split(" ")[0] }}</span>
        </template>
      </el-table-column>

      <el-table-column prop="done" label="操作">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="primary"
            @click="
              $router.push({
                path: '/doctor/cottoms/detail',
                query: { id: scope.row.id },
              })
            "
            >查看详情</el-button
          >
        </template>
      </el-table-column>
      <!-- 点击查看详情按钮时跳转到电子病历详情页 -->
    </el-table>
    <!-- 使用element-ui里的表格展示请求到的数据 -->

    <div class="beatch_remove">
      <el-button round type="danger" icon="el-icon-delete" @click="batchRemove"
        >批量删除</el-button
      >
    </div>
    <!-- 批量删除按钮 -->

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
        date: "",
      },
      //定义查询的表单元素

      cottomsList: [],
      //电子病历列表数据

      currentPage: 1,
      //当前点击页码数
      pageSize: 10,
      //每页展示数目

      multipleSelection: [],
      // 被选中的列表数据
    };
  },
  mounted() {
    this.getCottomsList();
  },
  //进入页面请求电子病例列表数据

  methods: {
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getCottomsList();
    }, //点击分页时改变当前页码，重新请求数据
    //在这里val就是分页组件中用户切换的页码值，赋值给currentPage，再次请求数据的时候 请求的就是用户切换的页码值的数据了

    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    //保存选中的列表数据

    getCottomsList() {
      console.log("111");
      this.$http("/medicalrecord/list", "get", {
        pageNo: this.currentPage,
        pageSize: 10,
      }).then((res) => {
        this.cottomsList = res.result.list;
      });
    },
    //获取电子病历列表

    batchRemove() {
      let idlist = [];
      this.multipleSelection.forEach((item) => {
        idlist.push(item.id);
      });
      console.log(idlist);
      this.$http("/medicalrecord/batchDelete", "get", {
        ids: idlist.join(","),
      }).then((res) => {
        location.reload();
      });
    },
    //批量删除电子病历
  },
  computed: {
    tables() {
      return this.cottomsList.filter((item) => {
        return (
          item.userinfo.username.includes(this.formInline.userName) &&
          item.seektime.includes(
            this.formInline.date == null ? "" : this.formInline.date
          )
        );
      });
    },
    // 根据查询条件过滤病例列表数据
  },
};
</script>
<style lang="scss">
#cottomsList {
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
}
</style>
