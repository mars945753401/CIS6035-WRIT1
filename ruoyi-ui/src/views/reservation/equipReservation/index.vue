<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="170px">
      <el-form-item label="Equipment" prop="equipId">
        <el-select v-model="form.equipId" placeholder="Equipment">
          <el-option
            v-for="option in equipOptions"
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
      <el-form-item label="Reservation Start Time" prop="startTime">
        <el-date-picker clearable
          v-model="queryParams.startTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="Reservation start time">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="Reservation End Time" prop="endTime">
        <el-date-picker clearable
          v-model="queryParams.endTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="Reservation end time">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="Reservation status" prop="erStatus">
        <el-select v-model="queryParams.erStatus" placeholder="Reservation status" clearable>
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
          v-hasPermi="['reservation:equipReservation:add']"
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
          v-hasPermi="['reservation:equipReservation:edit']"
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
          v-hasPermi="['reservation:equipReservation:remove']"
        >Delete</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['reservation:equipReservation:export']"
        >Export</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="reservationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="Reservation ID" align="center" prop="equipReservationId" />
      <el-table-column label="Equip ID" align="center" prop="equipId" />
      <el-table-column label="User ID" align="center" prop="userId" />
      <el-table-column label="Reservation purpose" align="center" prop="erPurpose" />
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
      <el-table-column label="Reservation status" align="center" prop="erStatus">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.grs_status" :value="scope.row.erStatus"/>
        </template>
      </el-table-column>
      <el-table-column label="Operations" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleCancel(scope.row)"
            v-hasPermi="['reservation:equipReservation:edit']"
            :disabled="scope.row.erStatus == 'cancelled'"
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

    <!-- Add or edit equipment reservation -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="170px">
        <el-form-item label="Equipment" prop="equipId">
          <el-select v-model="form.equipId" placeholder="Equipment">
            <el-option
              v-for="option in equipOptions"
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
        <el-form-item label="Reservation purpose" prop="erPurpose">
          <el-input v-model="form.erPurpose" type="textarea" placeholder="Reservation purpose" />
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
import { listEquipReservation, getEquipReservation, delEquipReservation, addEquipReservation, updateEquipReservation } from "@/api/reservation/equipReservation";
import { listEquipWithoutPagination } from "@/api/resource/equip";
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
      // Equipment reservation records
      reservationList: [],
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
        equipId: null,
        userId: null,
        erPurpose: null,
        startTime: null,
        endTime: null,
        erStatus: null,
      },
      // Equip options search params
      equipSearchParams: {
        equipName: null,
        equipType: null,
        supplier: null,
        productDate: null,
        equipDesc: null,
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
        equipId: [
          { required: true, message: "Equip cannot be empty", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "User cannot be empty", trigger: "blur" }
        ],
        erPurpose: [
          { required: true, message: "Equipment reservation purpose cannot be empty", trigger: "blur" }
        ],
        startTime: [
          { required: true, message: "Equipment reservation start time cannot be empty", trigger: "blur" }
        ],
        endTime: [
          { required: true, message: "Equipment reservation end time cannot be empty", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getEquipOptions();
    this.getUserOptions();
    this.getList();
  },
  methods: {
    /** Get equipment options */
    getEquipOptions() {
      this.equipOptions = [];
      listEquipWithoutPagination(this.equipSearchParams).then(response => {
        let allData = response.data;
        for (let i = 0; i < allData.length; i++) {
          let label = allData[i].equipName, value = allData[i].equipId;
          this.equipOptions.push({ label: label, value: value });
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
    
    /** Search equipment reservation list */
    getList() {
      this.loading = true;
      listEquipReservation(this.queryParams).then(response => {
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
        equipReservationId: null,
        equipId: null,
        userId: null,
        erPurpose: null,
        startTime: null,
        endTime: null,
        erStatus: null,
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
      this.ids = selection.map(item => item.equipReservationId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    
    /** Add button's operation */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "Add Equipment Reservation";
    },
    
    /** Edit button's operation */
    handleUpdate(row) {
      this.reset();
      const equipReservationId = row.equipReservationId || this.ids
      getEquipReservation(equipReservationId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "Edit Equipment Reservation";
      });
    },

    /** Cancel button's operation */
    handleCancel(row) {
      this.reset();
      const equipReservationId = row.equipReservationId;
      getEquipReservation(equipReservationId).then(response => {
        let selectedEquipReservation = response.data;
        this.$modal.confirm('Cancel equipment reservation with id = "' + equipReservationId + '"?').then(function() {
          selectedEquipReservation.erStatus = "cancelled";
          return updateEquipReservation(selectedEquipReservation);
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
          if (this.form.equipReservationId != null) {
            updateEquipReservation(this.form).then(response => {
              this.$modal.msgSuccess("Edit successfully!");
              this.open = false;
              this.getList();
            });
          } else {
            addEquipReservation(this.form).then(response => {
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
      const equipReservationIds = row.equipReservationId || this.ids;
      this.$modal.confirm('Delete equipment reservation with id = "' + equipReservationIds + '"?').then(function() {
        return delEquipReservation(equipReservationIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("Delete successfully!");
      }).catch(() => {});
    },

    /** Export button's operation */
    handleExport() {
      this.download('reservation/equipReservation/export', {
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