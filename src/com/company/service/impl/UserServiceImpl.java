package com.company.service.impl;

import com.company.NotFoundException;
import com.company.dao.UserDao;
import com.company.model.User;
import com.company.service.UserService;

import java.util.List;
import java.util.stream.Stream;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDao();

    public UserServiceImpl() {
    }




    // UserServiceтин ичинде 4 метод болот, userди кошуу, id менен табуу, id менен очуруу жана баардык userлерди алуу

    @Override
    public void addUser(User user) {

//        if (user.getName() == null) {
//            try {
//                throw new NotFoundException("User ne mojet sodirjat null!");
//            } catch (NotFoundException e) {
//                System.out.println(e.getMessage());
//            }

        userDao.addUser(user);
    }

    @Override
    public void idMenenTabu(int id) {

        boolean yesOrNo = userDao.yesOrNo(id);

        if (!yesOrNo) {
            try {
                throw new NotFoundException("Ne nayden User s takim id = " + id);
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        User user = userDao.naydi(id);

        System.out.println(user);
    }

    @Override
    public void shouAllUser() {

        List<User> userList = userDao.getUsers();
        userList.stream().filter(x ->x.getId() != 0).forEach(System.out::println);
    }

    @Override
    public void deleteIdUser(int id) {
        boolean delet = userDao.yesOrNo(id);
        if (!delet) {
            try {
                throw new NotFoundException("Ne smojete udalit' user: id = " + id + " netu");
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        User user = userDao.naydi(id);
        if (user.getId() == id) {
            System.out.println(user + ": is delete! \n");

            user = userDao.getUserArrayList().remove(id);
            shouAllUser();


        }
    }
}
