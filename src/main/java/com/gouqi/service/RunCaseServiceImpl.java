package com.gouqi.service;

import com.gouqi.dao.UrlDao;
import com.gouqi.entity.ParamBean;
import com.gouqi.entity.UrlBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RunCaseServiceImpl
 * @Description RunCaseService的实现类
 * @Auther Wangjy
 * @Data 2019/5/13 13:39
 **/
@Service("runCaseService")
public class RunCaseServiceImpl implements RunCaseService {
    @Autowired
    private UrlDao urlDao;
    @Override
    public List<UrlBean> showAllUrls() {
        return urlDao.showAllUrls();
    }

    @Override
    public List<ParamBean> showAllParams() {
        return urlDao.showAllParams();
    }
}
