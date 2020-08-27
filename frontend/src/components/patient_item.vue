<template>
  <div id="patientItem">
    <el-row>
      <el-col :span="12">
        <img src="../assets/img/patient_pic.png" alt="" />
      </el-col>
      <el-col :span="12">
        <ul class="item_con">
          <li>
            <span>姓名：</span>
            <p>{{ info.username }}</p>
          </li>
          <li>
            <span>性别：</span>
            <p>{{ info.gender == 1 ? "男" : "女" }}</p>
          </li>
          <li>
            <span>年龄：</span>
            <p>11</p>
          </li>
          <li>
            <span>序号：</span>
            <p>{{ info.id }}</p>
          </li>
          <li class="item_icon">
            <i
              class="el-icon-view"
              @click.stop="
                $router.push({
                  path: '/doctor/patient/detail/' + info.id + '/view',
                })
              "
            ></i>
            <i
              class="el-icon-edit"
              @click.stop="
                $router.push({
                  path: '/doctor/patient/detail/' + info.id + '/edit',
                })
              "
            ></i>
            <i
              class="el-icon-delete"
              style="color:red;"
              @click.stop="del(info.id)"
            ></i>
            <!-- 点击删除按钮时删除本条病人数据，要阻止冒泡 -->
          </li>
        </ul>
      </el-col>
    </el-row>
  </div>
</template>
<script>
export default {
  props: ["info"],
  // 接收父组件传递过来的数据info
  methods: {
    del(id) {
      this.$http("consultationinfo/patient", "delete", {
        consultationId: id,
      }).then((res) => {
        if (res.msg == "ok") {
          this.$message({
            showClose: true,
            message: "删除病人成功",
            type: "success",
          });
          location.reload();
        }
      });
    },
    //根据id删除病人信息
  },
};
</script>
<style lang="scss" scope>
#patientItem {
  width: 22%;
  padding: 5px;
  background: #fff;
  margin-bottom: 17px;
  border-radius: 5px;
  box-shadow: -5px 5px 10px #a09d9d;
  margin-right: 20px;
  img {
    width: 95px;
    height: 105px;
  }
  .item_con {
    display: flex;
    flex-direction: column;
    li {
      display: flex;

      span {
        color: #9c9c9c;
      }
      p {
        color: #252525;
      }
    }
    .item_icon {
      display: flex;
      justify-content: space-between;
      width: 60%;
      color: #16dcb8;
    }
  }
}
</style>
