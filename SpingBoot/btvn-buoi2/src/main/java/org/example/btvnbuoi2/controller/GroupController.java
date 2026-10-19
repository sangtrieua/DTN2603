package org.example.btvnbuoi2.controller;

import jakarta.validation.Valid;
import org.example.btvnbuoi2.dto.GroupDTO;
import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Group;
import org.example.btvnbuoi2.form.GroupFrom;
import org.example.btvnbuoi2.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "groups")
@Validated
public class GroupController {
    @Autowired
    private IGroupService groupService;

    @GetMapping
    public List<GroupDTO> findAll() {
        return groupService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GroupDTO findById(@PathVariable Integer id) {
        return groupService.findById(id);
    }

    @PostMapping
    public Group create(@RequestBody @Valid GroupFrom groupFrom) {
        return groupService.create(groupFrom);
    }

    @PutMapping(value = "/{id}")
    public Group update(@PathVariable Integer id, @RequestBody @Valid GroupFrom groupFrom) {
        return groupService.update(id,groupFrom);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {

        groupService.deleteById(id);
    }
}
