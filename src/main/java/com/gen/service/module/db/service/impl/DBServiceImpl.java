package com.gen.service.module.db.service.impl;

import com.gen.service.module.db.dto.DbConfigDTO;
import com.gen.service.module.db.service.DBService;
import com.gen.service.module.db.vo.DbVO;
import com.gen.service.utility.JdbcHelper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DB Connection
 */
@Service
public class DBServiceImpl implements DBService {

    /**
     * Database List
     */
    @Override
    public List<DbVO> dbList(DbConfigDTO dto) {
        System.out.println(dto.getUrl());

        List<DbVO> list = new ArrayList<>();
        JdbcHelper db = new JdbcHelper(dto);
        db.openConnection();
        ResultSet rs = db.execQuery("SELECT SCHEMA_NAME as name,DEFAULT_COLLATION_NAME as charset FROM information_schema.SCHEMATA WHERE SCHEMA_NAME NOT IN ('information_schema', 'mysql', 'performance_schema', 'sys'); ");
        try {
            while (rs.next()) {
                DbVO entity = new DbVO();
                entity.setName(rs.getString(1))
                        .setCharset(rs.getString(2))
                        .setLeaf(1)
                        .setLabel(entity.getName());
                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeAll();
        }
        return list;
    }
}
