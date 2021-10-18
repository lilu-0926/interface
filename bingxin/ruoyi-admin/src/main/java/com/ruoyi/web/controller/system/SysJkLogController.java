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
import com.ruoyi.system.domain.SysJkLog;
import com.ruoyi.system.service.ISysJkLogService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 操作日志记录Controller
 * 
 * @author ruoyi
 * @date 2021-06-09
 */
@Controller
@RequestMapping("/system/jklog")
public class SysJkLogController extends BaseController
{
    private String prefix = "system/jklog";

    @Autowired
    private ISysJkLogService sysJkLogService;

    @RequiresPermissions("system:jklog:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询操作日志记录列表
     */
    @RequiresPermissions("system:jklog:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysJkLog sysJkLog)
    {
        startPage();
        List<SysJkLog> list = sysJkLogService.selectSysJkLogList(sysJkLog);
        return getDataTable(list);
    }

    /**
     * 导出操作日志记录列表
     */
    @RequiresPermissions("system:jklog:export")
    @Log(title = "操作日志记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysJkLog sysJkLog)
    {
        List<SysJkLog> list = sysJkLogService.selectSysJkLogList(sysJkLog);
        ExcelUtil<SysJkLog> util = new ExcelUtil<SysJkLog>(SysJkLog.class);
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
    @RequiresPermissions("system:jklog:add")
    @Log(title = "操作日志记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysJkLog sysJkLog)
    {
        return toAjax(sysJkLogService.insertSysJkLog(sysJkLog));
    }

    /**
     * 修改操作日志记录
     */
    @GetMapping("/edit/{operId}")
    public String edit(@PathVariable("operId") Long operId, ModelMap mmap)
    {
        SysJkLog sysJkLog = sysJkLogService.selectSysJkLogById(operId);
        mmap.put("sysJkLog", sysJkLog);
        return prefix + "/edit";
    }

    @RequiresPermissions("system:jklog:detail")
    @GetMapping("/detail/{operId}")
    public String detail(@PathVariable("operId") Long operId, ModelMap mmap)
    {
        mmap.put("jklog", sysJkLogService.selectSysJkLogById(operId));
        return prefix + "/detail";
    }

    /**
     * 修改保存操作日志记录
     */
    @RequiresPermissions("system:jklog:edit")
    @Log(title = "操作日志记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysJkLog sysJkLog)
    {
        return toAjax(sysJkLogService.updateSysJkLog(sysJkLog));
    }

    /**
     * 删除操作日志记录
     */
    @RequiresPermissions("system:jklog:remove")
    @Log(title = "操作日志记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysJkLogService.deleteSysJkLogByIds(ids));
    }

    /*@Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @RequiresPermissions("system:jklog:remove")
    @PostMapping("/clean")
    @ResponseBody
    public AjaxResult clean()
    {
        sysJkLogService.cleanOperLog();
        return success();
    }*/
}
