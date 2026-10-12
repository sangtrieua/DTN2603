package org.example.btvnbuoi2.service.impl;

import jakarta.transaction.Transactional;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Group;
import org.example.btvnbuoi2.repository.IAccountRepository;
import org.example.btvnbuoi2.repository.IGroupRepository;
import org.example.btvnbuoi2.service.IAccountService;
import org.example.btvnbuoi2.service.IGroupAccountService;
import org.example.btvnbuoi2.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    private IGroupRepository groupRepository;
    @Autowired
    private IGroupAccountService groupAccountService;
    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findById(Integer id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group update(Integer id, Group groupUpdate) {
        Group group1 = groupRepository.findById(id).orElse(null);
        if(group1==null){
            throw new RuntimeException("không tồn tại group id "+id);
        }
        else {
            group1.setName(groupUpdate.getName());
            group1.setAccountCreator(groupUpdate.getAccountCreator());
            group1.setCreateDate(groupUpdate.getCreateDate());
            return groupRepository.save(group1);
        }
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Group group1 = groupRepository.findById(id).orElse(null);
        if(group1==null){
            throw new RuntimeException("không tồn tại group id "+id);
        }
        else {
            groupAccountService.deleteByGroup(group1);
            groupRepository.deleteById(id);
        }
    }
}
