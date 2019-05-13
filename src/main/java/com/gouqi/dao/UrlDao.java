package com.gouqi.dao;

import com.gouqi.entity.ParamBean;
import com.gouqi.entity.UrlBean;

import java.util.List;

/**
 * @Description UrlDao
 * @Date 13:44 2019/5/13
 **/
public interface UrlDao {
    List<UrlBean> showAllUrls();
    List<ParamBean> showAllParams();
}
