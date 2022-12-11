package com.example.mapper.dtt;

import com.example.domain.dtt.DttMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * The mybatis MAPPER interface of xxx
 */
@Mapper
public interface MemberMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(DttMember record);

    int insertOrUpdate(DttMember record);

    int insertOrUpdateSelective(DttMember record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(DttMember record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    DttMember selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(DttMember record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(DttMember record);

    int updateBatch(List<DttMember> list);

    int updateBatchSelective(List<DttMember> list);

    int batchInsert(@Param("list") List<DttMember> list);

    @Select("SELECT * FROM TESTDB.DTT_MEMBER WHERE ID = #{id}")
    DttMember selectById(long id);
}
