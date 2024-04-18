package com.example.usersAdmin.entity;

import org.springframework.beans.BeanUtils;

import com.example.usersAdmin.dto.UserPerfilDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_user_perfil")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserPerfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "perfil_id")
    private PerfilEntity perfil;

    public UserPerfilEntity(UserPerfilDto userPerfilDto) {
        BeanUtils.copyProperties(userPerfilDto, this);
    }
}
