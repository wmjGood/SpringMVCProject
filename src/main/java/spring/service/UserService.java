package spring.service;

import spring.pojo.Users;

public interface UserService {
    public  int addUsers(Users users);

    public  int updateUsers(Users users) ;

    //查询单个用户
    Users findUser(String id);
}
