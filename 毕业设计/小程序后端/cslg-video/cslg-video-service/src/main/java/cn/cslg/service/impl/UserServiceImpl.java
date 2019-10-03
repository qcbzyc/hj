package cn.cslg.service.impl;

import cn.cslg.mapper.UserMapper;
import cn.cslg.pojo.User;
import cn.cslg.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Sid sid;

    //如果其他bean调用这个方法,在其他bean中声明事务,那就用事务.如果其他bean没有声明事务,那就不用事务
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        User user = new User();
        user.setUsername(username);
        User result = userMapper.selectOne(user);
        return result==null?false:true;
    }

    //如果有事务, 那么加入事务, 没有的话新建一个
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveUser(User user) {

        String userId = sid.nextShort();
        user.setId(userId);
        userMapper.insert(user);
    }

    @Override
    public User querUserForLogin(String username, String md5Str) {
        Example userExample = new Example(User.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("password",md5Str);
        User result = userMapper.selectOneByExample(userExample);
        return result;
    }
}
