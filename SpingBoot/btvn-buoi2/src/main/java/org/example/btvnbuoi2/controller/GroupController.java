package org.example.btvnbuoi2.controller;

import org.example.btvnbuoi2.entity.Account;
import org.example.btvnbuoi2.entity.Group;
import org.example.btvnbuoi2.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "groups")
public class GroupController {
    @Autowired
    private IGroupService groupService;

    @GetMapping
    public List<Group> findAll() {
        return groupService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Group findById(@PathVariable Integer id) {
        return groupService.findById(id);
    }

    @PostMapping
    public Group create(@RequestBody Group group) {
        return groupService.create(group);
    }

    @PutMapping(value = "/{id}")
    public Group update(@PathVariable Integer id, @RequestBody Group group) {
        return groupService.update(id,group);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {

        groupService.deleteById(id);
    }
}
