package work.icql.springboot.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work.icql.springboot.annotation.DataSource;
import work.icql.springboot.entity.Teacher;
import work.icql.springboot.mapper.TeacherMapper;
import work.icql.springboot.service.TeacherService;

import java.util.List;

@Service
@DataSource("db1")
@Slf4j
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    //@Override
    //@DataSource(DataSourceEnum.DB2)
    //public boolean insert(Teacher entity) {
    //    return super.insert(entity);
    //}
    //
    //@Override
    //@DataSource(DataSourceEnum.DB2)
    //public boolean deleteById(Serializable id) {
    //    return super.deleteById(id);
    //}
    //
    //@Override
    //@DataSource(DataSourceEnum.DB2)
    //public boolean updateById(Teacher entity) {
    //    return super.updateById(entity);
    //}
    //
    //@Override
    //@DataSource(DataSourceEnum.DB2)
    //public Teacher selectById(Serializable id) {
    //    return super.selectById(id);
    //}

    @Override
    @DataSource("db2")
    @Cacheable(value = "test",key="")
    public List<Teacher> selectList(Wrapper<Teacher> wrapper) {
        log.error("缓存了++");

        return super.selectList(wrapper);
    }

    //@Override
    //@DataSource(DataSourceEnum.DB2)
    //public Page<Teacher> selectPage(Page<Teacher> page) {
    //    return super.selectPage(page);
    //}
    //
    //@Override
    //@DataSource(DataSourceEnum.DB2)
    //public Page<Teacher> selectPage(Page<Teacher> page, Wrapper<Teacher> wrapper) {
    //    return super.selectPage(page, wrapper);
    //}
}
