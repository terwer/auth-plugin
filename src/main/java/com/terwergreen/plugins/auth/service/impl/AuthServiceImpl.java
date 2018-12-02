package com.terwergreen.plugins.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.terwergreen.core.CommonDAO;
import com.terwergreen.plugins.auth.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Terwer
 * @Date 2018/11/23 15:54
 * @Version 1.0
 * @Description 业务实现
 **/
@Service
public class AuthServiceImpl implements AuthService {
    private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private CommonDAO commonDAO;

    @Override
    public String getSystemInfo() {
        List list = null;
        try {
            Map paramMap = new HashMap();
            paramMap.put("optionGroup", "siteConfig");
            list = commonDAO.queryListByMap("getOptionByGroup", paramMap);
        } catch (Exception e) {
            log.error("获取配置项异常", e);
            return "current version:BuguCMS 2.0.0";
        }
        //多个结果返回List，只有一个结果的时候直接返回
        if (!CollectionUtils.isEmpty(list)) {
            if (list.size() == 1) {
                return JSON.toJSONString(list.get(0));
            } else {
                return JSON.toJSONString(list);
            }
        }
        return "no data";
    }
}
