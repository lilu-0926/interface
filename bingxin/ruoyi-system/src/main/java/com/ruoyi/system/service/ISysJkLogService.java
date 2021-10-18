package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysJkLog;

/**
 * 操作日志记录Service接口
 * 
 * @author ruoyi
 * @date 2021-06-09
 */
public interface ISysJkLogService 
{
    /**
     * 查询操作日志记录
     * 
     * @param operId 操作日志记录ID
     * @return 操作日志记录
     */
    public SysJkLog selectSysJkLogById(Long operId);

    /**
     * 查询操作日志记录列表
     * 
     * @param sysJkLog 操作日志记录
     * @return 操作日志记录集合
     */
    public List<SysJkLog> selectSysJkLogList(SysJkLog sysJkLog);

    /**
     * 新增操作日志记录
     * 
     * @param sysJkLog 操作日志记录
     * @return 结果
     */
    public int insertSysJkLog(SysJkLog sysJkLog);

    /**
     * 修改操作日志记录
     * 
     * @param sysJkLog 操作日志记录
     * @return 结果
     */
    public int updateSysJkLog(SysJkLog sysJkLog);

    /**
     * 批量删除操作日志记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysJkLogByIds(String ids);

    /**
     * 删除操作日志记录信息
     * 
     * @param operId 操作日志记录ID
     * @return 结果
     */
    public int deleteSysJkLogById(Long operId);
}
