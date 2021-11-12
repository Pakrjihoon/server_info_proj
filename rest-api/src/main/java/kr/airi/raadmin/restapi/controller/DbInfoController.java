package kr.airi.raadmin.restapi.controller;

import kr.airi.raadmin.restapi.entity.DbInfo;
import kr.airi.raadmin.restapi.service.DbInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class DbInfoController {

    private DbInfoService dbInfoService;

    @Autowired
    DbInfoController(DbInfoService dbInfoService) {
        this.dbInfoService = dbInfoService;
    }

    @GetMapping(value = "/dbinfo")
    @ResponseBody
    public List<DbInfo> getAllDbInfo() {
        return dbInfoService.getAll();
    }
}
