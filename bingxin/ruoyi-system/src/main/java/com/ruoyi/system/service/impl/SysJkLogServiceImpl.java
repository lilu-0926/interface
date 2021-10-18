package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysJkLogMapper;
import com.ruoyi.system.domain.SysJkLog;
import com.ruoyi.system.service.ISysJkLogService;
import com.ruoyi.common.core.text.Convert;

/**
 * 操作日志记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-09
 */
@Service
public class SysJkLogServiceImpl implements ISysJkLogService 
{
    @Autowired
    private SysJkLogMapper sysJkLogMapper;

    /**
     * 查询操作日志记录
     * 
     * @param operId 操作日志记录ID
     * @return 操作日志记录
     */
    @Override
    public SysJkLog selectSysJkLogById(Long operId)
    {
        return sysJkLogMapper.selectSysJkLogById(operId);
    }

    /**
     * 查询操作日志记录列表
     * 
     * @param sysJkLog 操作日志记录
     * @return 操作日志记录
     */
    @Override
    public List<SysJkLog> selectSysJkLogList(SysJkLog sysJkLog)
    {
        return sysJkLogMapper.selectSysJkLogList(sysJkLog);
    }

    /**
     * 新增操作日志记录
     * 
     * @param sysJkLog 操作日志记录
     * @return 结果
     */
    @Override
    public int insertSysJkLog(SysJkLog sysJkLog)
    {
        return sysJkLogMapper.insertSysJkLog(sysJkLog);
    }

    /**
     * 修改操作日志记录
     * 
     * @param sysJkLog 操作日志记录
     * @return 结果
     */
    @Override
    public int updateSysJkLog(SysJkLog sysJkLog)
    {
        return sysJkLogMapper.updateSysJkLog(sysJkLog);
    }

    /**
     * 删除操作日志记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysJkLogByIds(String ids)
    {
        return sysJkLogMapper.deleteSysJkLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除操作日志记录信息
     * 
     * @param operId 操作日志记录ID
     * @return 结果
     */
    @Override
    public int deleteSysJkLogById(Long operId)
    {
        return sysJkLogMapper.deleteSysJkLogById(operId);
    }
}
