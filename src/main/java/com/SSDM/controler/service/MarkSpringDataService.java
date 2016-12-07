package com.SSDM.controler.service;

import com.SSDM.model.entity.Mark;
import com.SSDM.model.entityVO.MarkVO;
import com.SSDM.model.repository.MarkRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkSpringDataService {
    @Autowired
    private MarkRepository repository;

    @Autowired
    private transient Mapper mapper;

    private MarkVO mapEntity(Mark mark){
        return mapper.map(mark, MarkVO.class);
    }
    private List<MarkVO> mapEntity(List<Mark> marks){
        ArrayList<MarkVO> markVOs = new ArrayList<>();
        for (Mark mark : marks) {
            markVOs.add(mapper.map(mark, MarkVO.class));
        }
        return markVOs;
    }

    public MarkVO addOrUpdate(MarkVO markVO) {
        Mark mark = mapper.map(markVO, Mark.class);
        return mapEntity(repository.save(mark));
    }
    public void delete(long id) {
        repository.delete(id);
    }
    public MarkVO getById(long id) {
        return mapEntity(repository.findOne(id));
    }
    public List<MarkVO> getAll() {
        return mapEntity(repository.findAll());
    }
}

