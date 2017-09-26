package lk.sliit.lms.api.controllers;

import lk.sliit.lms.api.models.Student;
import lk.sliit.lms.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jonathan on 9/26/2017.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.GET)
    @ResponseBody
    public Student getCourse(@PathVariable("studentId") String studentId){
        return studentService.getCourse(studentId);
    }


}
