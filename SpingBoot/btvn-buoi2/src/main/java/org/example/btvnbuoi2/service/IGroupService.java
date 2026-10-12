package org.example.btvnbuoi2.service;

import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Group;

import java.util.List;

public interface IGroupService {

    List<Group> findAll();

    Group findById(Integer id);

    Group create(Group group);

    Group update(Integer id, Group group);

    void deleteById(Integer id);
}
