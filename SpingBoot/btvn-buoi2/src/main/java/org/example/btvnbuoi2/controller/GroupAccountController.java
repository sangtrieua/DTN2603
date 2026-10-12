package org.example.btvnbuoi2.controller;

import org.example.btvnbuoi2.embeddable.GroupAccountId;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.example.btvnbuoi2.service.IGroupAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "group_account")
public class GroupAccountController {
    @Autowired
    IGroupAccountService groupAccountService;
    @GetMapping(value = "/all")
    public List<GroupAccount> findAll() {
        return groupAccountService.findAll();
    }
    @PostMapping
    public GroupAccount addAccountToGroup(@RequestParam Integer groupId, @RequestParam Integer accountId) {
        return groupAccountService.addAccountToGroup(groupId,accountId);
    }
    @GetMapping(value = "/findbyaccountid")
    public List<GroupAccount> findAllByAccountId(@RequestParam Integer accountId) {

       return groupAccountService.findAllByAccountId(accountId);
    }
    @GetMapping(value = "/findbygroupid")
    public List<GroupAccount> findAllByGroupId(@RequestParam Integer groupId) {
        return groupAccountService.findAllByGroupId(groupId);
    }
}
