package org.example.btvnbuoi2.controller;

import org.example.btvnbuoi2.dto.AccountDTO;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.form.AccountForm;
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
    public List<AccountDTO> findAll() {
        return accountService.findAll();
    }

    @GetMapping(value = "/{id}")
    public AccountDTO findById(@PathVariable Integer id) {
    return accountService.findById(id);
    }

    @PostMapping
    public Account create(@RequestBody AccountForm accountForm) {
        return accountService.create(accountForm);
    }

    @PutMapping(value = "/{id}")
    public Account update(@PathVariable Integer id, @RequestBody AccountForm accountForm) {
        return accountService.update(id,accountForm);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        accountService.deleteById(id);
    }
}
