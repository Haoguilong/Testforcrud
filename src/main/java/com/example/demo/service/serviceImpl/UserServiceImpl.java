package com.example.demo.service.serviceImpl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao uo;


    @Override
    public List<User> findall() throws Exception{

        return uo.findAll();
    }

    @Override
    public Optional<User> selectUserById(int id) throws Exception{
        return uo.findById(id);
    }

    @Override
    public void addUser(User user) throws Exception {

        uo.save(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        uo.save(user);
    }

    @Override
    public void deleteById(int id) throws Exception{

        uo.deleteById(id);
    }
}
