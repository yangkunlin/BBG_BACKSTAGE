package com.bbg.BACKSTAGE.mapper;

import com.bbg.BACKSTAGE.model.CompactPicture;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompactPictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompactPicture record);

    int insertSelective(CompactPicture record);

    CompactPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompactPicture record);

    int updateByPrimaryKey(CompactPicture record);
}