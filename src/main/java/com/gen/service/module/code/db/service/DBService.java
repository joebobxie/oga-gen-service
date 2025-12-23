package com.gen.service.module.code.db.service;

import com.gen.service.module.code.db.dto.DbConfigDTO;
import com.gen.service.module.code.db.vo.DbVO;

import java.util.List;

/**
 * DB Connection
 */
public interface DBService {

    /**
     * Database List
     */
    List<DbVO> dbList(DbConfigDTO dto);
}
