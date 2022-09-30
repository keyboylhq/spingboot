package cn.gcuweb.spingboot.service.impl;

import cn.gcuweb.spingboot.entity.User;
import cn.gcuweb.spingboot.mapper.UserMapper;
import cn.gcuweb.spingboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author keyboy
 * @since 2022-09-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
