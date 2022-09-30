package cn.gcuweb.spingboot.service;

import cn.gcuweb.spingboot.entity.User;
import cn.gcuweb.spingboot.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServeic extends ServiceImpl<UserMapper,User>{
    public boolean saveUser(User user) {
//        boolean save = save(user);
//        if (user.getId() == null) {
//            return save(user);
//        }else {
//            return updateById(user);
//        }
        return saveOrUpdate(user);
    }
//    @Autowired
//    private UserMapper userMapper;
//    public  int save(User user){
//        if (user.getId() == null) {//这里的null是指的时回传的 id 不是数据库的id
//            return userMapper.insert(user);
//        }else {
//            return userMapper.update(user);
//        }
//    }
}
