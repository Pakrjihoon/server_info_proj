package kr.airi.raadmin.restapi.service;

import kr.airi.raadmin.restapi.entity.DbInfo;
import kr.airi.raadmin.restapi.repository.DbInfoRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class DbInfoService {

    private DbInfoRepository dbInfoRepository;

    DbInfoService(DbInfoRepository dbInfoRepository) {
        this.dbInfoRepository = dbInfoRepository;
    }

    @Transactional
    public DbInfo getOne(int number) {
        return dbInfoRepository.findById(number).get();
    }

    @Transactional
    public List<DbInfo> getAll() {
        return dbInfoRepository.findAll();
    }

//    @Transactional
//    public Monitoring createOne(MonitoringReqDto req) {
//        Monitoring monitoring = req.toEntity();
//        return monitoring.save(monitoring);
//    }
}
