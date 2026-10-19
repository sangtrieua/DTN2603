package org.example.btvnbuoi2.service.impl;

import jakarta.transaction.Transactional;
import org.example.btvnbuoi2.dto.GroupDTO;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Group;
import org.example.btvnbuoi2.exception.BusinessException;
import org.example.btvnbuoi2.form.GroupFrom;
import org.example.btvnbuoi2.repository.IAccountRepository;
import org.example.btvnbuoi2.repository.IGroupAccountRepository;
import org.example.btvnbuoi2.repository.IGroupRepository;
import org.example.btvnbuoi2.service.IAccountService;
import org.example.btvnbuoi2.service.IGroupAccountService;
import org.example.btvnbuoi2.service.IGroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    private IGroupRepository groupRepository;
    @Autowired
    private IGroupAccountRepository groupAccountRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<GroupDTO> findAll() {
        List<Group> groups = groupRepository.findAll();
        List<GroupDTO> dtos=new ArrayList<>();
        for(Group group:groups){
            GroupDTO groupDTO= modelMapper.map(group,GroupDTO.class);
            dtos.add(groupDTO);
        }
        return dtos;
    }

    @Override
    public GroupDTO findById(Integer id) {
        return modelMapper.map(groupRepository.findById(id).orElse(null),GroupDTO.class);
    }

    @Override
    public Group create(GroupFrom groupFrom) {

        if(groupRepository.existsGroupByName(groupFrom.getName())){
            throw new BusinessException("đã tồn tại tồn tại Group"+groupFrom.getName(),500);
        }
        Account account=accountRepository.findAccountByUserName(groupFrom.getAccountCreatorUserName());
        if(Objects.isNull(account)){
            throw new BusinessException("không tồn tại tồn tại account"+groupFrom.getAccountCreatorUserName(),500);
        }
        Group groupNew=new Group();
        groupNew.setName(groupFrom.getName());
        groupNew.setAccountCreator(account);
        groupNew.setCreateDate(new Date());
        return groupRepository.save(groupNew);
    }

    @Override
    public Group update(Integer id, GroupFrom groupFromUpdate) {
        Group group1 = groupRepository.findById(id).orElse(null);
        if(group1==null){
            throw new BusinessException("không tồn tại group id "+id,500);
        }
        else {
            if(groupRepository.existsGroupByNameAndIdNot(groupFromUpdate.getName(),id)){
                throw new BusinessException("đã tồn tại tồn tại Group"+groupFromUpdate.getName(),500);
            }
            Account account=accountRepository.findAccountByUserName(groupFromUpdate.getAccountCreatorUserName());
            if(Objects.isNull(account)){
                throw new BusinessException("không tồn tại tồn tại account"+groupFromUpdate.getAccountCreatorUserName(),500);
            }
            group1.setName(groupFromUpdate.getName());
            group1.setAccountCreator(account);
            return groupRepository.save(group1);
        }
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Group group1 = groupRepository.findById(id).orElse(null);
        if(group1==null){
            throw new BusinessException("không tồn tại group id "+id,500);
        }
        else {
            groupAccountRepository.deleteGroupAccountByGroup(group1);
            groupRepository.deleteById(id);
        }
    }
}
