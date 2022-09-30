package cn.gcuweb.spingboot.controller;

import cn.gcuweb.spingboot.entity.User;
import cn.gcuweb.spingboot.mapper.UserMapper;
import cn.gcuweb.spingboot.service.UserServeic;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserServeic userServeic;

    //    新曾和修改
    @PostMapping
    public boolean save(@RequestBody User user) {
        return userServeic.saveUser(user);
    }

    //    查
    @GetMapping("/")
    public List<User> index() {
        return userServeic.list();
//        List<User> all = userMapper.findAll();
//        return all;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
//        return userMapper.deleteById(id);
        return userServeic.removeById(id);
    }


    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
//        return userMapper.deleteById(id);
        return userServeic.removeByIds(ids);
    }
    //    // 分页查询
//    //  接口路径：/user/page?pageNum=1&pageSize=10
//    @GetMapping("/page")//接口路径 user/page
//    public Map<String,Object> findPage(@RequestParam Integer pageNum,
//                                       @RequestParam Integer pageSize,
//                                       @RequestParam String username){
//        pageNum = (pageNum-1)*pageSize;
////        username = "%" + username + "%";
//        List<User> data = userMapper.selectPage(pageNum,pageSize,username);
//        Integer total = userMapper.selectTotal(username);
//        Map<String,Object> res = new HashMap<>();
//        res.put("data",data);
//        res.put("total",total);
//
//        return res;
//    }
// 分页查询
//  接口路径：/user/page?pageNum=1&pageSize=10
    @GetMapping("/page")//接口路径 user/page
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username,
//                                   @RequestParam(defaultValue = "") String nickname,
                                @RequestParam(defaultValue = "") String email,
                                @RequestParam(defaultValue = "") String address

//                                   @RequestParam String nickname,
    ) {

        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", username);
//    queryWrapper.like("nickname",nickname);
        queryWrapper.like("email", email);
        queryWrapper.like("address", address);
        queryWrapper.orderByDesc("id");
//    queryWrapper.like("nickname",nickname);
        return userServeic.page(page, queryWrapper);
    }
}
