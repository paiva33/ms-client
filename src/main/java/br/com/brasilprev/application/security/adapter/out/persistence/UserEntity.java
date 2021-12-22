package br.com.brasilprev.application.security.adapter.out.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity(name = "User")
//@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "password")
    private String password;

    @Column(name = "account_non_expired")
    private Boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired;

    @Column(name = "enabled")
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permission", joinColumns = { @JoinColumn (name = "id_user") },
            inverseJoinColumns = { @JoinColumn (name = "id_permission")})
    private List<PermissionEntity> permissions;

    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        for (PermissionEntity permission : this.permissions) {
            roles.add(permission.getDescription());
        }
        return roles;
    }


}
