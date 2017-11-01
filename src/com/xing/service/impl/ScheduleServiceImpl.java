package com.xing.service.impl;

import com.xing.dao.PostDao;
import com.xing.dao.ScheduleDao;
import com.xing.domain.Schedule;
import com.xing.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by dllo on 17/11/1.
 */
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    @Qualifier("scheduleDao")
    private ScheduleDao scheduleDao;
    @Override
    public void saveInfo(Schedule schedule) {
        scheduleDao.saveInfo(schedule);
    }
}
