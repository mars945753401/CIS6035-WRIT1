<template>
  <el-form ref="form" :model="user" :rules="rules" label-width="80px">
    <el-form-item label="Old password" prop="oldPassword">
      <el-input v-model="user.oldPassword" placeholder="Please input old password" type="password" show-password/>
    </el-form-item>
    <el-form-item label="New password" prop="newPassword">
      <el-input v-model="user.newPassword" placeholder="Please input new password" type="password" show-password/>
    </el-form-item>
    <el-form-item label="Sure password" prop="confirmPassword">
      <el-input v-model="user.confirmPassword" placeholder="Please input sure password" type="password" show-password/>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="mini" @click="submit">Submit</el-button>
      <el-button type="danger" size="mini" @click="close">Close</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { updateUserPwd } from "@/api/system/user";

export default {
  data() {
    const equalToPassword = (rule, value, callback) => {
      if (this.user.newPassword !== value) {
        callback(new Error("The two passwords are not same!"));
      } else {
        callback();
      }
    };
    return {
      user: {
        oldPassword: undefined,
        newPassword: undefined,
        confirmPassword: undefined
      },
      // 表单校验
      rules: {
        oldPassword: [
          { required: true, message: "Old password cannot be empty!", trigger: "blur" }
        ],
        newPassword: [
          { required: true, message: "New password cannot be empty!", trigger: "blur" },
          { min: 6, max: 20, message: "Length of password should between 6 and 20!", trigger: "blur" },
          { pattern: /^[^<>"'|\\]+$/, message: "Cannot include illegal character < > \" ' \\\ |", trigger: "blur" }
        ],
        confirmPassword: [
          { required: true, message: "Sure password cannot be empty!", trigger: "blur" },
          { required: true, validator: equalToPassword, trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    submit() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updateUserPwd(this.user.oldPassword, this.user.newPassword).then(response => {
            this.$modal.msgSuccess("Edit successfully!");
          });
        }
      });
    },
    close() {
      this.$tab.closePage();
    }
  }
};
</script>
