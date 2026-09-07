package example.Practice4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import example.Practice4.model.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired private CourseRepository courseRepository;

    // 1. 등록
    public boolean 과정등록( CourseDto courseDto ){
        // 1. dto --> entity 변환
        
    }


}
