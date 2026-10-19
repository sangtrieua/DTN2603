package org.example.btvnbuoi2.controller;

import jakarta.validation.Valid;
import org.example.btvnbuoi2.dto.GroupAccountDTO;
import org.example.btvnbuoi2.embeddable.GroupAccountId;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.example.btvnbuoi2.form.GroupAccountForm;
import org.example.btvnbuoi2.service.IGroupAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "group_account")
@Validated
public class GroupAccountController {
    @Autowired
    IGroupAccountService groupAccountService;
    @GetMapping(value = "/all")
    public List<GroupAccountDTO> findAll() {
        return groupAccountService.findAll();
    }
    @PostMapping
    public GroupAccount addAccountToGroup(@RequestBody @Valid GroupAccountForm groupAccountForm) {
        return groupAccountService.addAccountToGroup(groupAccountForm);
    }
    @GetMapping(value = "/findbyaccountid")
    public List<GroupAccountDTO> findAllByAccountId(@RequestParam Integer accountId) {

       return groupAccountService.findAllByAccountId(accountId);
    }
    @GetMapping(value = "/findbygroupid")
    public List<GroupAccountDTO> findAllByGroupId(@RequestParam Integer groupId) {
        return groupAccountService.findAllByGroupId(groupId);
    }
}
