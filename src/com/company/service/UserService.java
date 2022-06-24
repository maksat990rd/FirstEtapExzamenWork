package com.company.service;

import com.company.model.User;

public interface UserService {
//    userди кошуу, id менен табуу, id менен очуруу жана баардык userлерди алуу

        void addUser(User user);

        void idMenenTabu(int id);

        void deleteIdUser(int id);

        void shouAllUser();
}
