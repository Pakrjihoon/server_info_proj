package kr.airi.raadmin.restapi.service;

import kr.airi.raadmin.restapi.dto.ContainerReqDto;
import kr.airi.raadmin.restapi.dto.DbinfoReqDto;
import kr.airi.raadmin.restapi.entity.Container;
import kr.airi.raadmin.restapi.entity.DbInfo;
import kr.airi.raadmin.restapi.repository.ContainerRepository;
import kr.airi.raadmin.restapi.repository.DbInfoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ContainerService {
    private ContainerRepository containerRepository;

    ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    @Transactional
    public Container getOne(int number) {
        return containerRepository.findById(number).get();
    }

    @Transactional
    public List<Container> getAll() {
        return containerRepository.findAll();
    }

    @Transactional
    public Container createOne(ContainerReqDto req) {
        Container container = req.toEntity();
        return containerRepository.save(container);
    }
}
