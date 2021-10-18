package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysApiLogMapper;
import com.ruoyi.system.domain.SysApiLog;
import com.ruoyi.system.service.ISysApiLogService;
import com.ruoyi.common.core.text.Convert;

/**
 * 操作日志记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-25
 */
@Service
public class SysApiLogServiceImpl implements ISysApiLogService 
{
    @Autowired
    private SysApiLogMapper sysApiLogMapper;

    /**
     * 查询操作日志记录
     * 
     * @param operId 操作日志记录ID
     * @return 操作日志记录
     */
    @Override
    public SysApiLog selectSysApiLogById(Long operId)
    {
        return sysApiLogMapper.selectSysApiLogById(operId);
    }

    /**
     * 查询操作日志记录列表
     * 
     * @param sysApiLog 操作日志记录
     * @return 操作日志记录
     */
    @Override
    public List<SysApiLog> selectSysApiLogList(SysApiLog sysApiLog)
    {
        return sysApiLogMapper.selectSysApiLogList(sysApiLog);
    }

    /**
     * 新增操作日志记录
     * 
     * @param sysApiLog 操作日志记录
     * @return 结果
     */
    @Override
    public int insertSysApiLog(SysApiLog sysApiLog)
    {
        return sysApiLogMapper.insertSysApiLog(sysApiLog);
    }

    /**
     * 修改操作日志记录
     * 
     * @param sysApiLog 操作日志记录
     * @return 结果
     */
    @Override
    public int updateSysApiLog(SysApiLog sysApiLog)
    {
        return sysApiLogMapper.updateSysApiLog(sysApiLog);
    }

    /**
     * 删除操作日志记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysApiLogByIds(String ids)
    {
        return sysApiLogMapper.deleteSysApiLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除操作日志记录信息
     * 
     * @param operId 操作日志记录ID
     * @return 结果
     */
    @Override
    public int deleteSysApiLogById(Long operId)
    {
        return sysApiLogMapper.deleteSysApiLogById(operId);
    }
}
