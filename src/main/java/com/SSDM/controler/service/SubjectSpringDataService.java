package com.SSDM.controler.service;

import com.SSDM.model.entity.Subject;
import com.SSDM.model.entityVO.SubjectVO;
import com.SSDM.model.repository.SubjectRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectSpringDataService {

    @Autowired
    private SubjectRepository repository;

    @Autowired
    private transient Mapper mapper;
    
    private SubjectVO mapEntity(Subject subject){
        return mapper.map(subject, SubjectVO.class);
    }
    private List<SubjectVO> mapEntity(List<Subject> subjects){
        ArrayList<SubjectVO> subjectVOs = new ArrayList<>();
        for (Subject subject : subjects) {
            subjectVOs.add(mapper.map(subject, SubjectVO.class));
        }
        return subjectVOs;
    }


    public SubjectVO addOrUpdate(SubjectVO subjectVO) {
        Subject subject = mapper.map(subjectVO, Subject.class);
        return mapEntity(repository.save(subject));
    }
    public void delete(long id) {
        repository.delete(id);
    }
    public SubjectVO getById(long id) {
        return mapEntity(repository.findOne(id));
    }
    public List<SubjectVO> getAll() {
        return mapEntity(repository.findAll());
    }
}
