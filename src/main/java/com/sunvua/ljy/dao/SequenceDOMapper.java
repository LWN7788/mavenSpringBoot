package com.sunvua.ljy.dao;

import com.sunvua.ljy.model.SequenceModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SequenceDOMapper {
    SequenceModel getSequenceByName(String name);

    int updateByPrimaryKeySelective(SequenceModel sequenceModel);
}
