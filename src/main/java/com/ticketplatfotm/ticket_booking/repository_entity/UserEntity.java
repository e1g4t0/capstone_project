package com.ticketplatfotm.ticket_booking.repository_entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@SequenceGenerator(name="user_seq",sequenceName="mv_user_seq", allocationSize = 1)
public class UserEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
    private Long userId;
    @NotEmpty (message = "Username can not be empty")
    @Column(name = "username")
    private String username;
    @NotEmpty (message = "Firstname can not be empty")
    @Column(name = "first_name")
    private String firstname;
    @NotEmpty (message = "Lastname can not be empty")
    @Column(name = "last_name")
    private String lastname;
    @NotEmpty (message = "Password can not be empty")
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @NotNull(message = "Birth date can not be empty")
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @NotEmpty (message = "Telephone can not be empty")
    @Column(name = "telephone")
    private String telephone;
    @NotEmpty (message = "Email can not be empty")
    @Column(name = "email")
    private String email;

    public UserEntity() {
    }

    public UserEntity(Long userId, String username, String firstname, String lastname, String password, String role, LocalDate birthDate, String telephone, String email) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
        this.birthDate = birthDate;
        this.telephone = telephone;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", birthDate=" + birthDate +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
