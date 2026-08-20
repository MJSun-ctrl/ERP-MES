package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MesTaskMapper;
import com.ruoyi.system.domain.MesTask;
import com.ruoyi.system.service.IMesTaskService;
import com.ruoyi.common.core.text.Convert;

/**
 * MES生产任务Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-08-19
 */
@Service
public class MesTaskServiceImpl implements IMesTaskService 
{
    @Autowired
    private MesTaskMapper mesTaskMapper;

    /**
     * 查询MES生产任务
     * 
     * @param taskId MES生产任务主键
     * @return MES生产任务
     */
    @Override
    public MesTask selectMesTaskByTaskId(Long taskId)
    {
        return mesTaskMapper.selectMesTaskByTaskId(taskId);
    }

    /**
     * 查询MES生产任务列表
     * 
     * @param mesTask MES生产任务
     * @return MES生产任务
     */
    @Override
    public List<MesTask> selectMesTaskList(MesTask mesTask)
    {
        return mesTaskMapper.selectMesTaskList(mesTask);
    }

    /**
     * 新增MES生产任务
     * 
     * @param mesTask MES生产任务
     * @return 结果
     */
    @Override
    public int insertMesTask(MesTask mesTask)
    {
        mesTask.setCreateTime(DateUtils.getNowDate());
        return mesTaskMapper.insertMesTask(mesTask);
    }

    /**
     * 修改MES生产任务
     * 
     * @param mesTask MES生产任务
     * @return 结果
     */
    @Override
    public int updateMesTask(MesTask mesTask)
    {
        mesTask.setUpdateTime(DateUtils.getNowDate());
        return mesTaskMapper.updateMesTask(mesTask);
    }

    /**
     * 批量删除MES生产任务
     * 
     * @param taskIds 需要删除的MES生产任务主键
     * @return 结果
     */
    @Override
    public int deleteMesTaskByTaskIds(String taskIds)
    {
        return mesTaskMapper.deleteMesTaskByTaskIds(Convert.toStrArray(taskIds));
    }

    /**
     * 删除MES生产任务信息
     * 
     * @param taskId MES生产任务主键
     * @return 结果
     */
    @Override
    public int deleteMesTaskByTaskId(Long taskId)
    {
        return mesTaskMapper.deleteMesTaskByTaskId(taskId);
    }
}
