package org.example.btvnbuoi2.controller;

import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "accounts")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Account findById(@PathVariable Integer id) {
    return accountService.findById(id);
    }

    @PostMapping
    public Account create(@RequestBody Account account) {
        return accountService.create(account);
    }

    @PutMapping(value = "/{id}")
    public Account update(@PathVariable Integer id, @RequestBody Account account) {
        return accountService.update(id,account);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        accountService.deleteById(id);
    }
}
