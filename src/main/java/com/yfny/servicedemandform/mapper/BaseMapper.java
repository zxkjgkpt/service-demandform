package com.yfny.servicedemandform.mapper;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 微服务通用Mapper
 * Author auto
 * Date  2019-04-09
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {

}
