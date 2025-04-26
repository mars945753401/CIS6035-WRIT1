<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="170px">
      <el-form-item label="Course" prop="courseId">
        <el-select v-model="form.courseId" placeholder="Course">
          <el-option
            v-for="option in courseOptions"
            :key="option.value"
            :label="option.label"
            :value="option.value"
          ></el-option>
        </el-select>
      </el-form-item>
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
      <el-form-item label="Reservation start time" prop="startTime">
        <el-date-picker clearable
          v-model="queryParams.startTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="Reservation start time">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="Reservation end time" prop="endTime">
        <el-date-picker clearable
          v-model="queryParams.endTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="Reservation end time">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="Reservation status" prop="crStatus">
        <el-select v-model="queryParams.crStatus" placeholder="Reservation status" clearable>
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
          v-hasPermi="['reservation:courseReservation:add']"
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
          v-hasPermi="['reservation:courseReservation:edit']"
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
          v-hasPermi="['reservation:courseReservation:remove']"
        >Delete</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['reservation:courseReservation:export']"
        >Export</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="reservationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="Reservation ID" align="center" prop="courseReservationId" />
      <el-table-column label="Course ID" align="center" prop="courseId" />
      <el-table-column label="User ID" align="center" prop="userId" />
      <el-table-column label="Reservation purpose" align="center" prop="crPurpose" />
      <el-table-column label="Reservation start time" align="center" prop="startTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Reservation end time" align="center" prop="endTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Reservation status" align="center" prop="crStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.grs_status" :value="scope.row.crStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="Operations" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleCancel(scope.row)"
            v-hasPermi="['reservation:courseReservation:edit']"
            :disabled="scope.row.crStatus == 'cancelled'"
          >Cancel</el-button>
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

    <!-- Add or edit course reservation -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="170px">
        <el-form-item label="Course" prop="courseId">
          <el-select v-model="form.courseId" placeholder="Course">
            <el-option
              v-for="option in courseOptions"
              :key="option.value"
              :label="option.label"
              :value="option.value"
            ></el-option>
          </el-select>
        </el-form-item>
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
        <el-form-item label="Reservation purpose" prop="crPurpose">
          <el-input v-model="form.crPurpose" type="textarea" placeholder="Reservation purpose" />
        </el-form-item>
        <el-form-item label="Reservation start time" prop="startTime">
          <el-date-picker clearable
            v-model="form.startTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="Reservation start time">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="Reservation end time" prop="endTime">
          <el-date-picker clearable
            v-model="form.endTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="Reservation end time">
          </el-date-picker>
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
import { listCourseReservation, getCourseReservation, delCourseReservation, addCourseReservation, updateCourseReservation } from "@/api/reservation/courseReservation";
import { listCourseWithoutPagination } from "@/api/resource/course";
import { listUserWithoutPagination } from "@/api/system/user";

export default {
  name: "Reservation",
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
      // Course reservation records
      reservationList: [],
      // Course options
      courseOptions: [],
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
        courseId: null,
        userId: null,
        crPurpose: null,
        startTime: null,
        endTime: null,
        crStatus: null,
      },
      // Course options search params
      courseSearchParams: {
        courseName: null,
        courseType: null,
        teacher: null,
        releaseDate: null,
        courseDesc: null,
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
        courseId: [
          { required: true, message: "Course cannot be empty", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "User cannot be empty", trigger: "blur" }
        ],
        crPurpose: [
          { required: true, message: "Course reservation purpose cannot be empty", trigger: "blur" }
        ],
        startTime: [
          { required: true, message: "Course reservation start time cannot be empty", trigger: "blur" }
        ],
        endTime: [
          { required: true, message: "Course reservation end time cannot be empty", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getCourseOptions();
    this.getUserOptions();
    this.getList();
  },
  methods: {
    /** Get course options */
    getCourseOptions() {
      this.courseOptions = [];
      listCourseWithoutPagination(this.courseSearchParams).then(response => {
        let allData = response.data;
        for (let i = 0; i < allData.length; i++) {
          let label = allData[i].courseName, value = allData[i].courseId;
          this.courseOptions.push({ label: label, value: value });
        }
      });
    },

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

    /** Search course reservation list */
    getList() {
      this.loading = true;
      listCourseReservation(this.queryParams).then(response => {
        this.reservationList = response.rows;
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
        courseReservationId: null,
        courseId: null,
        userId: null,
        crPurpose: null,
        startTime: null,
        endTime: null,
        crStatus: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
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
      this.resetForm("queryForm");
      this.handleQuery();
    },

    // Handle the change of checkbox
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.courseReservationId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },

    /** Add button's operation */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "Add Course Reservation";
    },

    /** Edit button's operation */
    handleUpdate(row) {
      this.reset();
      const courseReservationId = row.courseReservationId || this.ids
      getCourseReservation(courseReservationId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "Edit Course Reservation";
      });
    },

    /** Cancel button's operation */
    handleCancel(row) {
      this.reset();
      const courseReservationId = row.courseReservationId;
      getCourseReservation(courseReservationId).then(response => {
        let selectedCourseReservation = response.data;
        this.$modal.confirm('Cancel course reservation with id = "' + courseReservationId + '"?').then(function() {
          selectedCourseReservation.crStatus = "cancelled";
          return updateCourseReservation(selectedCourseReservation);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("Cancel successfully!");
        }).catch(() => {});
      });
    },

    /** Submit button's operation */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.courseReservationId != null) {
            updateCourseReservation(this.form).then(response => {
              this.$modal.msgSuccess("Edit successfully!");
              this.open = false;
              this.getList();
            });
          } else {
            addCourseReservation(this.form).then(response => {
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
      const courseReservationIds = row.courseReservationId || this.ids;
      this.$modal.confirm('Delete course reservation with id = "' + courseReservationIds + '"?').then(function() {
        return delCourseReservation(courseReservationIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("Delete successfully!");
      }).catch(() => {});
    },

    /** Export button's operation */
    handleExport() {
      this.download('reservation/courseReservation/export', {
        ...this.queryParams
      }, `reservation_${new Date().getTime()}.xlsx`)
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