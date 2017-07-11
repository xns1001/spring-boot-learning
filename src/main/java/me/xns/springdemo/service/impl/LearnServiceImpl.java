package me.xns.springdemo.service.impl;

import me.xns.springdemo.dao.LearnMapper;
import me.xns.springdemo.domain.LearnResouce;
import me.xns.springdemo.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by xns on 2017/7/11.
 */
@Service
public class LearnServiceImpl implements LearnService {
    @Autowired
    LearnMapper learnMapper;

    @Override
    public int add(LearnResouce learnResouce) {
        return learnMapper.add(learnResouce);
    }

    @Override
    public int update(LearnResouce learnResouce) {
        return learnMapper.update(learnResouce);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return learnMapper.deleteByIds(ids);
    }

    @Override
    public LearnResouce queryLearnResouceById(Long learnResouce) {
        return learnMapper.queryLearnResouceById(learnResouce);
    }

    @Override
    public List<LearnResouce> queryLearnResouceList(Map<String, Object> params) {
        return learnMapper.queryLearnResouceList(params);
    }
}
