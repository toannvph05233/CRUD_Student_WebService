package codegym.controller;

import codegym.model.Student;
import codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class HomeControllerAPI {
    @Autowired
    IStudentService iStudentService;

    @GetMapping
    public Page<Student> students(@RequestParam(defaultValue = "0") int page) {
        return iStudentService.findAll(PageRequest.of(page, 2));
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return new ResponseEntity(iStudentService.save(student), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> showEdit(@PathVariable long id) {
        return new ResponseEntity(iStudentService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> edit(@RequestBody Student student) {
        return new ResponseEntity(iStudentService.save(student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        iStudentService.remove(iStudentService.findById(id));
        return new ResponseEntity(HttpStatus.OK);
    }

}
