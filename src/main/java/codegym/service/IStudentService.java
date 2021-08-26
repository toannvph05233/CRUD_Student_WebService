package codegym.service;

import codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
    public Page<Student> findAll(Pageable pageable);

    public Student findById(long id);

    public Student save(Student student);

    public void remove(Student student);

}
