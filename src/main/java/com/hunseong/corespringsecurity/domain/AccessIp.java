package com.hunseong.corespringsecurity.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Hunseong on 2022/06/08
 */
@Table(name = "ACCESS_IP")
@Data
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccessIp {

    @Id @GeneratedValue
    @Column(name = "IP_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "IP_ADDRESS", nullable = false)
    private String ipAddress;
}
