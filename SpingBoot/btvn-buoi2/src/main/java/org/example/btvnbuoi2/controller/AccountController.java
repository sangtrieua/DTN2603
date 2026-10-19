package org.example.btvnbuoi2.controller;

import jakarta.validation.Valid;
import org.example.btvnbuoi2.dto.AccountDTO;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.form.AccountForm;
import org.example.btvnbuoi2.form.AccountSearchForm;
import org.example.btvnbuoi2.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "accounts")
@Validated
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping
    public ResponseEntity<Page<AccountDTO>> findAll(AccountSearchForm searchForm, Pageable pageable) {
        return new ResponseEntity<>(accountService.findAll(searchForm,pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public AccountDTO findById(@PathVariable Integer id) {
    return accountService.findById(id);
    }

    @PostMapping
    public Account create(@RequestBody @Valid AccountForm accountForm) {
        return accountService.create(accountForm);
    }

    @PutMapping(value = "/{id}")
    public Account update(@PathVariable Integer id, @RequestBody @Valid AccountForm accountForm) {
        return accountService.update(id,accountForm);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        accountService.deleteById(id);
    }
}
