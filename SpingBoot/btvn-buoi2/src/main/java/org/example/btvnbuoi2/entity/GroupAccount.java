package org.example.btvnbuoi2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.btvnbuoi2.embeddable.GroupAccountId;

import java.util.Date;

@Entity
@Table(name = "group_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupAccount {

    @EmbeddedId
    private GroupAccountId id = new GroupAccountId();

    @MapsId("groupId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "join_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;
}