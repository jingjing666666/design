package com.ssm.promotion.core.dao;

import com.ssm.promotion.core.entity.Classify;
import java.util.List;

public interface ClassifyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Classify record);

    Classify selectByPrimaryKey(Integer id);

    List<Classify> selectAll();

    int updateByPrimaryKey(Classify record);
}