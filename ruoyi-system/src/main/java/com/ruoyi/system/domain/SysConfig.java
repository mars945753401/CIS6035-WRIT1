package com.ruoyi.system.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * System config
 * 
 * @author Tianyang Pan
 */
public class SysConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Config ID */
    @Excel(name = "Config ID", cellType = ColumnType.NUMERIC)
    private Long configId;

    /** Config name */
    @Excel(name = "Config name")
    private String configName;

    /** Config key */
    @Excel(name = "Config key")
    private String configKey;

    /** Config value */
    @Excel(name = "Config value")
    private String configValue;

    /** Is system inner (Y/N) */
    @Excel(name = "Is system inner")
    private String configType;

    public Long getConfigId()
    {
        return configId;
    }

    public void setConfigId(Long configId)
    {
        this.configId = configId;
    }

    @NotBlank(message = "Config name cannot be empty")
    @Size(min = 0, max = 100, message = "Length of config name cannot be more than 100")
    public String getConfigName()
    {
        return configName;
    }

    public void setConfigName(String configName)
    {
        this.configName = configName;
    }

    @NotBlank(message = "Config key cannot be empty")
    @Size(min = 0, max = 100, message = "Length of config key cannot be more than 100")
    public String getConfigKey()
    {
        return configKey;
    }

    public void setConfigKey(String configKey)
    {
        this.configKey = configKey;
    }

    @NotBlank(message = "Config value cannot be empty")
    @Size(min = 0, max = 500, message = "Length of config value cannot be more than 100")
    public String getConfigValue()
    {
        return configValue;
    }

    public void setConfigValue(String configValue)
    {
        this.configValue = configValue;
    }

    public String getConfigType()
    {
        return configType;
    }

    public void setConfigType(String configType)
    {
        this.configType = configType;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("configId", getConfigId())
            .append("configName", getConfigName())
            .append("configKey", getConfigKey())
            .append("configValue", getConfigValue())
            .append("configType", getConfigType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
