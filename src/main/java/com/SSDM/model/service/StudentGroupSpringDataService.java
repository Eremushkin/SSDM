package com.SSDM.model.service;


import com.SSDM.model.entity.StudentGroup;
import com.SSDM.model.entityVO.StudentGroupVO;
import com.SSDM.model.repository.StudentGroupRepository;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentGroupSpringDataService {

    @Autowired
    StudentGroupRepository repository;
    @Autowired
    Mapper mapper;

    public StudentGroupSpringDataService() {
    }

    private StudentGroupVO mapEntity(StudentGroup student){
        return mapper.map(student, StudentGroupVO.class);
    }
    private List<StudentGroupVO> mapEntity(List<StudentGroup> studentGroups){
        ArrayList<StudentGroupVO> StudentGroupVOList = new ArrayList<>();
        for (StudentGroup studentGroup : studentGroups) {
            StudentGroupVOList.add(mapper.map(studentGroup, StudentGroupVO.class));
        }
        return StudentGroupVOList;
    }

    public StudentGroupVO addOrUpdate(StudentGroup studentGroup) {
        return mapEntity(repository.save(studentGroup));
    }
    public void delete(long id) {
        repository.delete(id);
    }
    public StudentGroupVO getById(long id) {
        return mapEntity(repository.findOne(id));
    }
    public List<StudentGroupVO> getAll() {
        return mapEntity(repository.findAll());
    }
    public StudentGroupVO getByNumber(String number){
        return mapEntity(repository.findByGroupNumber(number));
    }
}
