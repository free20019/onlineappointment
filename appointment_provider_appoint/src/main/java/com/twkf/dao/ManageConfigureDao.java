package com.twkf.dao;

        import org.apache.ibatis.annotations.Insert;
        import org.apache.ibatis.annotations.Param;
        import org.apache.ibatis.annotations.Select;
        import org.apache.ibatis.annotations.Update;
        import org.springframework.stereotype.Repository;

        import java.util.HashMap;
        import java.util.List;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2021/2/1 - 14:01
 */
@Repository
public interface ManageConfigureDao {

    @Update("update tb_manage_configure set surplus_number = surplus_number+${number} where id = #{id} and fbtype=0 and (surplus_number>0 or ${number}=1)")
    int updateByIncrease(@Param("id") String id,@Param("number") Integer number);

    @Select("select count(*) count, phone from tb_appoint where phone is not null and appoint_type!=2 group by phone")
    List<HashMap<String,Object>> findPhoneCount();

//    @Insert("insert into tb_visit (visit_number, update_time) values" +
//            " (IFNULL((select max(visit_number) from (select * from tb_visit) a),0)+${number}, now())")
    @Insert("insert into tb_visit (visit_number, update_time) values" +
            " (#{number}, now())")
    int visit(@Param("number") Integer number);
}
