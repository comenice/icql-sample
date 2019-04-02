package work.icql.springboot.service;


import com.github.pagehelper.PageInfo;
import work.icql.springboot.entity.User;

import java.util.List;

/**
 * @author icql
 * @version 1.0
 * @date 2019/3/28 14:24
 * @Title UserService
 * @Description UserService
 */
public interface UserService {
    /**
     * 获取user
     *
     * @param id
     * @return
     */
    User getUser(long id);

    /**
     * 获取user列表
     *
     * @return
     */
    PageInfo listUser(int pageNum, int pageSize, String username);

    /**
     * 新增user
     *
     * @param userDO
     */
    void insertUser(User userDO);

    /**
     * 新增user-批量
     *
     * @param userDOs
     */
    void insertUser(List<User> userDOs);

    /**
     * 全量更新user
     *
     * @param userDO
     */
    void updateUser(User userDO);

    /**
     * 全量更新user-批量
     *
     * @param userDOs
     */
    void updateUser(List<User> userDOs);

    /**
     * 选择更新user
     *
     * @param userDO
     */
    void updateUserSelective(User userDO);

    /**
     * 选择更新user-批量
     *
     * @param userDOs
     */
    void updateUserSelective(List<User> userDOs);

    /**
     * 删除user
     *
     * @param id
     */
    void deleteUser(long id);

    /**
     * 删除user-批量
     *
     * @param ids
     */
    void deleteUser(String ids);
}
