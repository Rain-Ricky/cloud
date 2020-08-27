<template>
  <div id="patientList">
    <div class="patient_con">
      <patient-item
        v-for="(item, index) in patientList"
        :key="index"
        :info="item"
        @click.native="toggleItem(item, item.id)"
        :class="{ select: item.select }"
      ></patient-item>
      <!-- 每个病人都是一个组件 -->
    </div>
    <div class="beatch_remove">
      <el-button class="bg16d" round icon="el-icon-delete">批量选择</el-button>
      <el-button round type="danger" icon="el-icon-delete" @click="delList"
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
      :pager-count="5"
    >
    </el-pagination>
    <!-- 分页效果 -->
  </div>
</template>
<script>
import patientItem from "../../components/patient_item.vue";
import axios from "axios";
export default {
  data() {
    return {
      currentPage: 1,
      //当前点击页码数
      pageSize: 16,
      //每页展示数目
      patientList: [],
      //病人列表数据
    };
  },
  components: {
    patientItem,
  }, //注册病人列表条目子组件
  mounted() {
    this.getPatientList();
    //进入页面时候获取病人列表
  },
  methods: {
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
    }, //点击分页时改变当前页码，重新请求数据

    toggleItem(item) {
      // if (item.select == false) {
      //   item.select = true;
      // } else {
      //   item.select = false;
      // }
      item.select = !item.select;
    },
    //点击病人列表条目时，切换选中和未选中select字段的状态

    getPatientList() {
      this.$http(
        "/consultationinfo/patientList",
        "post",

        {
          pageNo: 1,
          pageSize: 10,
        }
      ).then((res) => {
        this.patientList = res.result.list;
        //请求到的病人列表数据赋值给data数据patientList
        console.log(this.patientList);
        this.patientList.forEach((item) => {
          this.$set(item, "select", false);
        });
        //为每条数据增加一个key值select代表是否选中，为后期的批量删除作准备
      });
    },
    delList() {
      let ids = [];
      this.patientList.forEach((item) => {
        if (item.select == true) {
          ids.push(item.id);
        }
      });
      // 把所有select字段为true的信息的id都传进数组中
      if (ids.length !== 0)
        this.$http("consultationinfo/patients", "delete", {
          consultationIds: ids.join(","),
          //传递给后台数据，把数组拼接为字符串1，2，的格式
        }).then((res) => {
          if (res.msg == "ok") {
            this.$message({
              showClose: true,
              message: "删除病人成功",
              type: "success",
            });
            location.reload();
          } //删除成功后弹出成功弹窗，并且刷新页面
        });
    },
    //批量删除
  },
};
</script>
<style lang="scss" scoped>
#patientList {
  position: relative;
  .patient_con {
    display: flex;
    flex-wrap: wrap;
    justify-content: left;
  }
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
    .el-button.is-round {
      color: #fff;
      padding: 8px 12px;
    }
  }
  .select {
    // border: 1px solid rgb(211, 143, 143);
    background: rgba($color: #918b8b, $alpha: 0.3);
    // box-sizing: border-box;
  }
}
</style>
<style lang="scss"></style>
