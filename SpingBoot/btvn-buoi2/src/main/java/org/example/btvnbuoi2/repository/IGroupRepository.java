package org.example.btvnbuoi2.repository;

import org.example.btvnbuoi2.embeddable.GroupAccountId;
import org.example.btvnbuoi2.entity.Group;
import org.example.btvnbuoi2.entity.GroupAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupRepository extends JpaRepository<Group, Integer> {

}
