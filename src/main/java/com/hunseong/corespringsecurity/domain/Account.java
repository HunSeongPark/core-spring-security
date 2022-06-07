package com.hunseong.corespringsecurity.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hunseong on 2022/06/05
 */
@Entity
@Data
@ToString(exclude = {"userRoles"})
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String email;

    private int age;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "account_roles", joinColumns = { @JoinColumn(name = "account_id") },
            inverseJoinColumns = {@JoinColumn(name = "role_id") })
    private Set<Role> userRoles = new HashSet<>();
}
