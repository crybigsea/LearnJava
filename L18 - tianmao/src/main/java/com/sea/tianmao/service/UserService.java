package com.sea.tianmao.service;

import com.sea.tianmao.dao.UserDAO;
import com.sea.tianmao.pojo.User;
import com.sea.tianmao.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public Page4Navigator<User> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<User> page = userDAO.findAll(pageable);
        return new Page4Navigator<>(page, navigatePages);
    }
}