package spring.mapper;

import spring.pojo.Users;

public interface UsersMapper {
    //添加用户
    public  int addUsers(Users users);

    //修改用户
    public  int updateUsers(Users users) ;

    //查询单个用户
    Users findUser(String id);
}
