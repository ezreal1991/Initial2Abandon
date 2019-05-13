package com.gouqi.service;

import com.gouqi.entity.ParamBean;
import com.gouqi.entity.UrlBean;

import java.util.List;

/**
 * @Description 执行用例相关service
 * @Date 13:35 2019/5/13
 **/
public interface RunCaseService {
//    UrlBean searvhUrlByName(String name);
    /**
     * @Description 拿到所有Url的信息
     * @Date 13:38 2019/5/13
     * @Param []
     * @return java.util.List<com.gouqi.entity.UrlBean>
     **/
    List<UrlBean> showAllUrls();
    /**
     * @Description 拿到所有环境变量
     * @Date 14:56 2019/5/13
     * @Param []
     * @return java.util.List<com.gouqi.entity.ParamBean>
     **/
    List<ParamBean> showAllParams();
}
