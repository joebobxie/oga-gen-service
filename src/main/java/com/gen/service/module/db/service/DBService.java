package com.gen.service.module.db.service;

import com.gen.service.module.db.dto.DbConfigDTO;
import com.gen.service.module.db.vo.DbVO;

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
