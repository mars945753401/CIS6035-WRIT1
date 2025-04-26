<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="150px">
      <el-form-item label="Equip Name" prop="equipName">
        <el-input
          v-model="queryParams.equipName"
          placeholder="Equip name"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Equip Type" prop="equipType">
        <el-select v-model="queryParams.equipType" placeholder="Equip type" clearable>
          <el-option
            v-for="dict in dict.type.grs_equipment_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="Equip Supplier" prop="supplier">
        <el-input
          v-model="queryParams.supplier"
          placeholder="Equip supplier"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Equip Product Date" prop="productDate">
        <el-date-picker clearable
          v-model="queryParams.productDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="Equip product date">
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
          v-hasPermi="['resource:equip:add']"
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
          v-hasPermi="['resource:equip:edit']"
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
          v-hasPermi="['resource:equip:remove']"
        >Delete</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['resource:equip:export']"
        >Export</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="equipList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="Equip ID" align="center" width="120" prop="equipId" />
      <el-table-column label="Equip Name" align="center" prop="equipName" />
      <el-table-column label="Equip Type" align="center" prop="equipType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.grs_equipment_type" :value="scope.row.equipType"/>
        </template>
      </el-table-column>
      <el-table-column label="Equip Supplier" align="center" prop="supplier" />
      <el-table-column label="Equip Product Date" align="center" prop="productDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.productDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Equip Description" align="center" prop="equipDesc" show-overflow-tooltip />
      <el-table-column label="Operations" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['resource:equip:edit']"
          >Edit</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['resource:equip:remove']"
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

    <!-- Add or edit equipment dialog -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="160px">
        <el-form-item label="Equip Name" prop="equipName">
          <el-input v-model="form.equipName" placeholder="Equip name" />
        </el-form-item>
        <el-form-item label="Equip Type" prop="equipType">
          <el-select v-model="form.equipType" placeholder="Equip type">
            <el-option
              v-for="dict in dict.type.grs_equipment_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Equip Supplier" prop="supplier">
          <el-input v-model="form.supplier" placeholder="Equip supplier" />
        </el-form-item>
        <el-form-item label="Equip Product Date" prop="productDate">
          <el-date-picker clearable
            v-model="form.productDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="Equip product date">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="Equip Description" prop="equipDesc">
          <el-input v-model="form.equipDesc" type="textarea" maxlength="500" show-word-limit :autosize="{ minRows: 5, maxRows: 10 }" placeholder="Equip description" />
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
import { listEquip, getEquip, delEquip, addEquip, updateEquip } from "@/api/resource/equip";

export default {
  name: "Equip",
  dicts: ['grs_equipment_type'],
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
      // Equipment records
      equipList: [],
      // Dialog's title
      title: "",
      // Is show dialog
      open: false,
      // Search params
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        equipName: null,
        equipType: null,
        supplier: null,
        productDate: null,
        equipDesc: null,
      },
      // Form params
      form: {},
      // Form rules
      rules: {
        equipName: [
          { required: true, message: "Equip name cannot be empty", trigger: "blur" }
        ],
        equipType: [
          { required: true, message: "Equip type cannot be empty", trigger: "blur" }
        ],
        supplier: [
          { required: true, message: "Equip supplier cannot be empty", trigger: "blur" }
        ],
        productDate: [
          { required: true, message: "Equip product date cannot be empty", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** Search equipment list */
    getList() {
      this.loading = true;
      listEquip(this.queryParams).then(response => {
        this.equipList = response.rows;
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
        equipId: null,
        equipName: null,
        equipType: null,
        supplier: null,
        productDate: null,
        equipDesc: null,
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
      this.ids = selection.map(item => item.equipId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** Add button's operation */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "Add Equipment";
    },
    /** Edit button's operation */
    handleUpdate(row) {
      this.reset();
      const equipId = row.equipId || this.ids
      getEquip(equipId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "Edit Equipment";
      });
    },
    /** Submit button's operation */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.equipId != null) {
            updateEquip(this.form).then(response => {
              this.$modal.msgSuccess("Edit successfully!");
              this.open = false;
              this.getList();
            });
          } else {
            addEquip(this.form).then(response => {
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
      const equipIds = row.equipId || this.ids;
      this.$modal.confirm('Delete equipment with id = "' + equipIds + '"?').then(function() {
        return delEquip(equipIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("Delete successfully!");
      }).catch(() => {});
    },
    /** Export button's operation */
    handleExport() {
      this.download('resource/equip/export', {
        ...this.queryParams
      }, `equip_${new Date().getTime()}.xlsx`)
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