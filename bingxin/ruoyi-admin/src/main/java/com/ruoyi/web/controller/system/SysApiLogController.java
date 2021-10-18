package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysApiLog;
import com.ruoyi.system.service.ISysApiLogService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 操作日志记录Controller
 * 
 * @author ruoyi
 * @date 2021-05-25
 */
@Controller
@RequestMapping("/system/log")
public class SysApiLogController extends BaseController
{
    private String prefix = "system/log";

    @Autowired
    private ISysApiLogService sysApiLogService;

    @RequiresPermissions("system:log:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询操作日志记录列表
     */
    @RequiresPermissions("system:log:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysApiLog sysApiLog)
    {
        startPage();
        List<SysApiLog> list = sysApiLogService.selectSysApiLogList(sysApiLog);
        return getDataTable(list);
    }

    /**
     * 导出操作日志记录列表
     */
    @RequiresPermissions("system:log:export")
    @Log(title = "操作日志记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysApiLog sysApiLog)
    {
        List<SysApiLog> list = sysApiLogService.selectSysApiLogList(sysApiLog);
        ExcelUtil<SysApiLog> util = new ExcelUtil<SysApiLog>(SysApiLog.class);
        return util.exportExcel(list, "操作日志记录数据");
    }

    /**
     * 新增操作日志记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存操作日志记录
     */
    @RequiresPermissions("system:log:add")
    @Log(title = "操作日志记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysApiLog sysApiLog)
    {
        return toAjax(sysApiLogService.insertSysApiLog(sysApiLog));
    }

    /**
     * 修改操作日志记录
     */
    @GetMapping("/edit/{operId}")
    public String edit(@PathVariable("operId") Long operId, ModelMap mmap)
    {
        SysApiLog sysApiLog = sysApiLogService.selectSysApiLogById(operId);
        mmap.put("sysApiLog", sysApiLog);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:log:detail")
    @GetMapping("/detail/{operId}")
    public String detail(@PathVariable("operId") Long operId, ModelMap mmap)
    {
        mmap.put("apiLog", sysApiLogService.selectSysApiLogById(operId));
        return prefix + "/detail";
    }

    /**
     * 修改保存操作日志记录
     */
    @RequiresPermissions("system:log:edit")
    @Log(title = "操作日志记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysApiLog sysApiLog)
    {
        return toAjax(sysApiLogService.updateSysApiLog(sysApiLog));
    }

    /**
     * 删除操作日志记录
     */
    @RequiresPermissions("system:log:remove")
    @Log(title = "操作日志记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysApiLogService.deleteSysApiLogByIds(ids));
    }

}
