package com.trinasolar.rsbu.mdm.maintenance.mapper;

import com.trinasolar.rsbu.mdm.maintenance.model.response.TUserAreaRelation;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TUserAreaRelationMapper {
    @Delete({
        "delete from t_user_area_relation",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into t_user_area_relation (id, user_id, ",
        "area_code, product_id, ",
        "enable)",
        "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{areaCode,jdbcType=VARCHAR}, #{productId,jdbcType=BIGINT}, ",
        "#{enable,jdbcType=TINYINT})"
    })
    int insert(TUserAreaRelation record);

    @Select({
        "select",
        "id, user_id, area_code, product_id, enable",
        "from t_user_area_relation",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="area_code", property="areaCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="enable", property="enable", jdbcType=JdbcType.TINYINT)
    })
    TUserAreaRelation selectByPrimaryKey(Long id);

    @Select({
        "select",
        "id, user_id, area_code, product_id, enable",
        "from t_user_area_relation"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="area_code", property="areaCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.BIGINT),
        @Result(column="enable", property="enable", jdbcType=JdbcType.TINYINT)
    })
    List<TUserAreaRelation> selectAll();

    @Update({
        "update t_user_area_relation",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "area_code = #{areaCode,jdbcType=VARCHAR},",
          "product_id = #{productId,jdbcType=BIGINT},",
          "enable = #{enable,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TUserAreaRelation record);
}