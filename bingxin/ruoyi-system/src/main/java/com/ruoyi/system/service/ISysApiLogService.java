package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysApiLog;

/**
 * 操作日志记录Service接口
 * 
 * @author ruoyi
 * @date 2021-05-25
 */
public interface ISysApiLogService 
{
    /**
     * 查询操作日志记录
     * 
     * @param operId 操作日志记录ID
     * @return 操作日志记录
     */
    public SysApiLog selectSysApiLogById(Long operId);

    /**
     * 查询操作日志记录列表
     * 
     * @param sysApiLog 操作日志记录
     * @return 操作日志记录集合
     */
    public List<SysApiLog> selectSysApiLogList(SysApiLog sysApiLog);

    /**
     * 新增操作日志记录
     * 
     * @param sysApiLog 操作日志记录
     * @return 结果
     */
    public int insertSysApiLog(SysApiLog sysApiLog);

    /**
     * 修改操作日志记录
     * 
     * @param sysApiLog 操作日志记录
     * @return 结果
     */
    public int updateSysApiLog(SysApiLog sysApiLog);

    /**
     * 批量删除操作日志记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysApiLogByIds(String ids);

    /**
     * 删除操作日志记录信息
     * 
     * @param operId 操作日志记录ID
     * @return 结果
     */
    public int deleteSysApiLogById(Long operId);
}
