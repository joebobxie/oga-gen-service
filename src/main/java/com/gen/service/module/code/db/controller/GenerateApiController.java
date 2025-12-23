package com.gen.service.module.code.db.controller;

import com.gen.service.common.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags={"Basic Dict"})
@RestController
@RequestMapping("/api/generate")
public class GenerateApiController extends BaseController {

//    /**
//     * connect and get databases
//     *
//     */
//    @RequestMapping(value = "/connect", method = RequestMethod.POST)
//    public ApiResult Connect(@RequestBody QueryDataEntity queryDataEntity) {
//        System.out.println(queryDataEntity.getHost());
//        List<DBEntity> list = Operation.databases(queryDataEntity);
//        return this.Succeed(list);
//    }
}
