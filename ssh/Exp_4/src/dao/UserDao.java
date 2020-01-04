package dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import po.User;

import java.util.List;

@Service
@Transactional
public interface UserDao {
    /**
     * 加载User实例
     * @param id ɜ?要加载的User实例的主键å??
     * @return 返回加载的User实例
     */
    User get(Integer id);

    /**
     * 保存User实例
     * @param user ɜ?要保存的User实例
     * @return 刚刚保存的User实例的标识属性å??
     */
    Integer save(User user);
    /**
     * 根据用户名查找User
     * @param name 查询的人Ő?
     * @return 指定用户名对应的全部User
     */
    List<User> findByName(String name);
}
