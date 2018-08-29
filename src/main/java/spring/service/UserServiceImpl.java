package spring.service;

import org.springframework.stereotype.Service;
import spring.mapper.UsersMapper;
import spring.pojo.Users;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements  UserService {

    @Resource
    private UsersMapper mapper;


    public UsersMapper getMapper() {
        return mapper;
    }

    public void setMapper(UsersMapper mapper) {
        this.mapper = mapper;
    }

    public int addUsers(Users users) {
        return mapper.addUsers(users);
    }

    public int updateUsers(Users users) {
        return mapper.updateUsers(users);
    }

    public Users findUser(String id) {
        return mapper.findUser(id);
    }
}
