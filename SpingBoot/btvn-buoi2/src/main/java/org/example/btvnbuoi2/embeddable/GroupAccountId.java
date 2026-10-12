package org.example.btvnbuoi2.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class GroupAccountId implements Serializable {

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "account_id")
    private Integer accountId;

    public GroupAccountId() {
    }

    public GroupAccountId(Integer groupId, Integer accountId) {
        this.groupId = groupId;
        this.accountId = accountId;
    }

    // getter/setter cho groupId, accountId
    // equals + hashCode
}