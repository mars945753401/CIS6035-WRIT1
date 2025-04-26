<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="170px">
      <el-form-item label="User" prop="userId">
        <el-select v-model="queryParams.userId" placeholder="User">
          <el-option
            v-for="option in userOptions"
            :key="option.value"
            :label="option.label"
            :value="option.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="Feedback Score" prop="fbScore">
        <el-input
          v-model="queryParams.fbScore"
          placeholder="Feedback score (1~5)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Feedback Status" prop="fbStatus">
        <el-select v-model="queryParams.fbStatus" placeholder="Feedback status" clearable>
          <el-option
            v-for="dict in dict.type.grs_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">Search</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">Reset</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['feedback:feedback:add']"
        >Add</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['feedback:feedback:edit']"
        >Edit</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['feedback:feedback:remove']"
        >Delete</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['feedback:feedback:export']"
        >Export</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="feedbackList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="Feedback ID" align="center" prop="feedbackId" />
      <el-table-column label="User ID" align="center" prop="userId" />
      <el-table-column label="Feedback score" align="center" prop="fbScore" />
      <el-table-column label="Feedback content" align="center" prop="fbContent" />
      <el-table-column label="Feedback reply" align="center" prop="fbReply" />
      <el-table-column label="Feedback status" align="center" prop="fbStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.grs_status" :value="scope.row.fbStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="Operation" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['feedback:feedback:edit']"
          >Edit</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['feedback:feedback:remove']"
          >Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- Add or edit feedback -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="170px">
        <el-form-item label="User" prop="userId">
          <el-select v-model="form.userId" placeholder="User">
            <el-option
              v-for="option in userOptions"
              :key="option.value"
              :label="option.label"
              :value="option.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Feedback score" prop="fbScore">
          <el-input-number v-model="form.fbScore" :min="1" :max="10" placeholder="Feedback score" />
        </el-form-item>
        <el-form-item label="Feedback content" prop="fbContent">
          <el-input v-model="form.fbContent" type="textarea" />
        </el-form-item>
        <el-form-item label="Feedback reply" prop="fbReply">
          <el-input v-model="form.fbReply" type="textarea" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">Submit</el-button>
        <el-button @click="cancel">Cancel</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listFeedback, getFeedback, delFeedback, addFeedback, updateFeedback } from "@/api/feedback/feedback";
import { listUserWithoutPagination } from "@/api/system/user";

export default {
  name: "Feedback",
  dicts: ['grs_status'],
  data() {
    return {
      // Loading level
      loading: true,
      // Selected ids
      ids: [],
      // Is single selection
      single: true,
      // Is multiple selection
      multiple: true,
      // Is show search conditions
      showSearch: true,
      // Total number of records
      total: 0,
      // Feedback records
      feedbackList: [],
      // Equipment options
      equipOptions: [],
      // User options
      userOptions: [], 
      // Dialog's title
      title: "",
      // Is show dialog
      open: false,
      // Search params
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        fbScore: null,
        fbContent: null,
        fbReply: null,
        fbStatus: null,
      },
      // User options search params
      userSearchParams: {
        userId: null,
        userName: null,
        nickName: null,
      },
      // Form params
      form: {},
      // Form rules
      rules: {
        userId: [
          { required: true, message: "User cannot be empty", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getUserOptions();
    this.getList();
  },
  methods: {
    /** Get user options */
    getUserOptions() {
      this.userOptions = [];
      listUserWithoutPagination(this.userSearchParams).then(response => {
        let allData = response.data;
        for (let i = 0; i < allData.length; i++) {
          let label = allData[i].userName, value = allData[i].userId;
          this.userOptions.push({ label: label, value: value });
        }
      });
    },

    /** Search feedback list */
    getList() {
      this.loading = true;
      listFeedback(this.queryParams).then(response => {
        this.feedbackList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

    // Cancel button
    cancel() {
      this.open = false;
      this.reset();
    },

    // Reset form
    reset() {
      this.form = {
        feedbackId: null,
        userId: null,
        fbScore: null,
        fbContent: null,
        fbReply: null,
        fbStatus: null,
        createBy: null,
        createTime: null
      };
      this.resetForm("form");
    },

    /** Search button's operation */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    
    /** Reset button's operation */
    resetQuery() {
      this.queryParams.fbScore = null;
      this.resetForm("queryForm");
      this.handleQuery();
    },

    // Handle the change of checkbox
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.feedbackId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    
    /** Add button's operation */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "Add Feedback";
    },
    
    /** Edit button's operation */
    handleUpdate(row) {
      this.reset();
      const feedbackId = row.feedbackId || this.ids
      getFeedback(feedbackId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "Edit Feedback";
      });
    },

    /** Submit button's operation */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.feedbackId != null) {
            updateFeedback(this.form).then(response => {
              this.$modal.msgSuccess("Edit successfully!");
              this.open = false;
              this.getList();
            });
          } else {
            addFeedback(this.form).then(response => {
              this.$modal.msgSuccess("Add successfully!");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    
    /** Delete button's operation */
    handleDelete(row) {
      const feedbackIds = row.feedbackId || this.ids;
      this.$modal.confirm('Delete feedback with id = "' + feedbackIds + '"?').then(function() {
        return delFeedback(feedbackIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("Delete successfully!");
      }).catch(() => {});
    },
    
    /** Export button's operation */
    handleExport() {
      this.download('feedback/feedback/export', {
        ...this.queryParams
      }, `feedback_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

<style>
  /* Handle the problem of el-input show-word-limit textarea blocks input contents */
  .el-textarea .el-input__count {
    background-color: transparent;
    bottom: -27px;
  }

  /* When contents of el-input area are too long, the contents will be displayed by multiple rows */
  .el-tooltip__popper {
    width: 250px;
    font-size: 13px;
  }
</style>