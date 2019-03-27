package work.icql.springboot.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import work.icql.springboot.entity.Student;
import work.icql.springboot.mapper.StudentMapper;
import work.icql.springboot.service.StudentService;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
