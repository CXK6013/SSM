package org.example.ioc;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author XingKe
 * @date 2021-02-12 17:51
 */
@Service
public class StudentService {


    private Student student;

    @Inject
    public StudentService(Student student) {
        this.student = student;
    }

    public void print(){
        System.out.println(student);
    }
}
