package com.SSDM.controler.service;

import com.SSDM.model.entity.Teacher;
import com.SSDM.model.entityVO.TeacherVO;
import com.SSDM.model.repository.TeacherRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherSpringDataService {

    @Autowired
    private TeacherRepository repository;

    @Autowired
    private transient Mapper mapper;

    private TeacherVO mapEntity(Teacher teacher){
        return mapper.map(teacher, TeacherVO.class);
    }
    private List<TeacherVO> mapEntity(List<Teacher> teachers){
        ArrayList<TeacherVO> teacherVOs = new ArrayList<>();
        for (Teacher teacher : teachers) {
            teacherVOs.add(mapper.map(teacher, TeacherVO.class));
        }
        return teacherVOs;
    }

    public TeacherVO addOrUpdate(TeacherVO teacherVO) {
        Teacher teacher = mapper.map(teacherVO, Teacher.class);
        return mapEntity(repository.save(teacher));
    }
    public void delete(long id) {
        repository.delete(id);
    }
    public TeacherVO getById(long id) {
        return mapEntity(repository.findOne(id));
    }
    public List<TeacherVO> getAll() {
        return mapEntity(repository.findAll());
    }
}
