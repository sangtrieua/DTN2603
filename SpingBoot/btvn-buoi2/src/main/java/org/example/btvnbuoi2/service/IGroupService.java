package org.example.btvnbuoi2.service;

import org.example.btvnbuoi2.dto.GroupDTO;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Group;
import org.example.btvnbuoi2.form.GroupFrom;

import java.util.List;

public interface IGroupService {

    List<GroupDTO> findAll();

    GroupDTO findById(Integer id);

    Group create(GroupFrom groupFrom);

    Group update(Integer id, GroupFrom groupFrom);

    void deleteById(Integer id);
}
