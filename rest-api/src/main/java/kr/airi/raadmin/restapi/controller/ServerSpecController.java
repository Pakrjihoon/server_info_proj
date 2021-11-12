package kr.airi.raadmin.restapi.controller;

import kr.airi.raadmin.restapi.entity.ServerSpec;
import kr.airi.raadmin.restapi.repository.ServerSpecRepository;
import kr.airi.raadmin.restapi.service.ServerSpecService;
import org.apache.catalina.util.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ServerSpecController {

    private ServerSpecService serverSpecService;

    @Autowired
    ServerSpecController(ServerSpecService serverSpecService) {
        this.serverSpecService = serverSpecService;
    }

    @GetMapping(value = "/server-spec")
    @ResponseBody
    public List<ServerSpec> getAllServerSpec() {
        return serverSpecService.getAll();
    }
}
