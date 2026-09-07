package example.Practice4.controller;

import example.Practice4.dto.CourseDto;
import example.Practice4.model.repository.EnrollRepository;
import example.Practice4.service.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import example.Practice4.service.EnrollService;

@RestController 
@RequestMapping ("/api/enroll")
public class EnrollController {

    @Autowired private EnrollService enrollService;

}
