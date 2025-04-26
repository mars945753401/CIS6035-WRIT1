<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="150px">
      <el-form-item label="Course Name" prop="courseName">
        <el-input
          v-model="queryParams.courseName"
          placeholder="Course name"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Course Type" prop="courseType">
        <el-select v-model="queryParams.courseType" placeholder="Course type" clearable>
          <el-option
            v-for="dict in dict.type.grs_course_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="Course Teacher" prop="teacher">
        <el-input
          v-model="queryParams.teacher"
          placeholder="Course teacher"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Release Date" prop="releaseDate">
        <el-date-picker clearable
          v-model="queryParams.releaseDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="Course release date">
        </el-date-picker>
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
          v-hasPermi="['resource:course:add']"
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
          v-hasPermi="['resource:course:edit']"
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
          v-hasPermi="['resource:course:remove']"
        >Delete</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['resource:course:export']"
        >Export</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="courseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="Course ID" align="center" width="120" prop="courseId" />
      <el-table-column label="Course Name" align="center" prop="courseName" />
      <el-table-column label="Course Type" align="center" prop="courseType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.grs_course_type" :value="scope.row.courseType"/>
        </template>
      </el-table-column>
      <el-table-column label="Course Teacher" align="center" prop="teacher" />
      <el-table-column label="Release date" align="center" prop="releaseDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.releaseDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Course description" align="center" prop="courseDesc" />
      <el-table-column label="Operations" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['resource:course:edit']"
          >Edit</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['resource:course:remove']"
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

    <!-- Add or edit course dialog -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="160px">
        <el-form-item label="Course Name" prop="courseName">
          <el-input v-model="form.courseName" placeholder="Course name" />
        </el-form-item>
        <el-form-item label="Course Type" prop="courseType">
          <el-select v-model="form.courseType" placeholder="Course type">
            <el-option
              v-for="dict in dict.type.grs_course_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Course Teacher" prop="teacher">
          <el-input v-model="form.teacher" placeholder="Course teacher" />
        </el-form-item>
        <el-form-item label="Release Date" prop="releaseDate">
          <el-date-picker clearable
            v-model="form.releaseDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="Course release date">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="Course Description" prop="courseDesc">
          <el-input v-model="form.courseDesc" type="textarea" placeholder="Course Description" />
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
import { listCourse, getCourse, delCourse, addCourse, updateCourse } from "@/api/resource/course";

export default {
  name: "Course",
  dicts: ['grs_course_type'],
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
      // Course records
      courseList: [],
      // Dialog's title
      title: "",
      // Is show dialog
      open: false,
      // Search params
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        courseName: null,
        courseType: null,
        teacher: null,
        releaseDate: null,
        courseDesc: null,
      },
      // Form params
      form: {},
      // Form rules
      rules: {
        courseName: [
          { required: true, message: "Course name cannot be empty", trigger: "blur" }
        ],
        courseType: [
          { required: true, message: "Course type cannot be empty", trigger: "blur" }
        ],
        teacher: [
          { required: true, message: "Course teacher cannot be empty", trigger: "blur" }
        ],
        releaseDate: [
          { required: true, message: "Course release date cannot be empty", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** Search course list */
    getList() {
      this.loading = true;
      listCourse(this.queryParams).then(response => {
        this.courseList = response.rows;
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
        courseId: null,
        courseName: null,
        courseType: null,
        teacher: null,
        releaseDate: null,
        courseDesc: null,
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
      this.ids = selection.map(item => item.courseId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** Add button's operation */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "Add Course";
    },
    /** Edit button's operation */
    handleUpdate(row) {
      this.reset();
      const courseId = row.courseId || this.ids
      getCourse(courseId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "Edit Course";
      });
    },
    /** Submit button's operation */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.courseId != null) {
            updateCourse(this.form).then(response => {
              this.$modal.msgSuccess("Edit successfully!");
              this.open = false;
              this.getList();
            });
          } else {
            addCourse(this.form).then(response => {
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
      const courseIds = row.courseId || this.ids;
      this.$modal.confirm('Delete course with id = "' + courseIds + '"?').then(function() {
        return delCourse(courseIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("Delete successfully!");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('resource/course/export', {
        ...this.queryParams
      }, `course_${new Date().getTime()}.xlsx`)
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