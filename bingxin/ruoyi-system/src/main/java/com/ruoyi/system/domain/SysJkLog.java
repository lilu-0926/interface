package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 操作日志记录对象 sys_jk_log
 * 
 * @author ruoyi
 * @date 2021-06-09
 */
public class SysJkLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日志主键seq_sys_jk_log.nextval */
    private Long operId;

    /** 体检号 */
    @Excel(name = "体检号")
    private String tjh000;

    /** 方法名称 */
    @Excel(name = "方法名称")
    private String method;

    /** 方法说明 */
    @Excel(name = "方法说明")
    private String directions;

    /** 参数 */
    @Excel(name = "参数")
    private String parameter;

    /** 操作状态（1正常 0异常） */
    @Excel(name = "操作状态", readConverterExp = "1=正常,0=异常")
    private Long status;

    /** 操作时间 */
    @Excel(name = "操作时间")
    private String operTime;

    public void setOperId(Long operId) 
    {
        this.operId = operId;
    }

    public Long getOperId() 
    {
        return operId;
    }
    public void setTjh000(String tjh000) 
    {
        this.tjh000 = tjh000;
    }

    public String getTjh000() 
    {
        return tjh000;
    }
    public void setMethod(String method) 
    {
        this.method = method;
    }

    public String getMethod() 
    {
        return method;
    }
    public void setDirections(String directions) 
    {
        this.directions = directions;
    }

    public String getDirections() 
    {
        return directions;
    }
    public void setParameter(String parameter) 
    {
        this.parameter = parameter;
    }

    public String getParameter() 
    {
        return parameter;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setOperTime(String operTime) 
    {
        this.operTime = operTime;
    }

    public String getOperTime() 
    {
        return operTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("operId", getOperId())
            .append("tjh000", getTjh000())
            .append("method", getMethod())
            .append("directions", getDirections())
            .append("parameter", getParameter())
            .append("status", getStatus())
            .append("operTime", getOperTime())
            .toString();
    }
}
