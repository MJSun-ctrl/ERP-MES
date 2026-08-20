package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MesTask;

/**
 * MES生产任务Service接口
 * 
 * @author ruoyi
 * @date 2026-08-19
 */
public interface IMesTaskService 
{
    /**
     * 查询MES生产任务
     * 
     * @param taskId MES生产任务主键
     * @return MES生产任务
     */
    public MesTask selectMesTaskByTaskId(Long taskId);

    /**
     * 查询MES生产任务列表
     * 
     * @param mesTask MES生产任务
     * @return MES生产任务集合
     */
    public List<MesTask> selectMesTaskList(MesTask mesTask);

    /**
     * 新增MES生产任务
     * 
     * @param mesTask MES生产任务
     * @return 结果
     */
    public int insertMesTask(MesTask mesTask);

    /**
     * 修改MES生产任务
     * 
     * @param mesTask MES生产任务
     * @return 结果
     */
    public int updateMesTask(MesTask mesTask);

    /**
     * 批量删除MES生产任务
     * 
     * @param taskIds 需要删除的MES生产任务主键集合
     * @return 结果
     */
    public int deleteMesTaskByTaskIds(String taskIds);

    /**
     * 删除MES生产任务信息
     * 
     * @param taskId MES生产任务主键
     * @return 结果
     */
    public int deleteMesTaskByTaskId(Long taskId);
}
