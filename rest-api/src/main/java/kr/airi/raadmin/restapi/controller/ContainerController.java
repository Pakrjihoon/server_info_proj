package kr.airi.raadmin.restapi.controller;

import kr.airi.raadmin.restapi.dto.ContainerReqDto;
import kr.airi.raadmin.restapi.dto.DbinfoReqDto;
import kr.airi.raadmin.restapi.entity.Container;
import kr.airi.raadmin.restapi.entity.DbInfo;
import kr.airi.raadmin.restapi.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ContainerController {

    private ContainerService containerService;

    @Autowired
    ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping(value = "/containers")
    @ResponseBody
    public List<Container> getAllContainer() {
        return containerService.getAll();
    }

    @PostMapping(value = "/container")
    @ResponseBody
    public Container saveContainer(@RequestBody ContainerReqDto req) {
        return containerService.createOne(req);
    }

    @GetMapping(value = "/container/{number}")
    @ResponseBody
    public Container getContainer(@PathVariable("number")int number){
        return containerService.getOne(number);
    }
}
