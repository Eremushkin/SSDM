package com.SSDM.model.service;

import com.SSDM.model.entity.Student;
import com.SSDM.model.repository.StudentRepository;
import com.SSDM.model.entityVO.StudentVO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentSpringDataService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private transient Mapper mapper;

    public StudentSpringDataService() {
    }

    private StudentVO mapEntity(Student student){
        return mapper.map(student, StudentVO.class);
    }
    private List<StudentVO> mapEntity(List<Student> students){
        ArrayList<StudentVO> studentVOList = new ArrayList<>();
        for (Student student : students) {
            studentVOList.add(mapper.map(student, StudentVO.class));
        }
        return studentVOList;
    }
    public StudentVO addOrUpdate(Student student) {
        return mapEntity(repository.save(student));
    }
    public void delete(long id) {
        repository.delete(id);
    }
    public StudentVO getById(long id) {
        return mapEntity(repository.findOne(id));
    }

    public List<StudentVO> getAll() {
       return mapEntity(repository.findAll());
    }


}
