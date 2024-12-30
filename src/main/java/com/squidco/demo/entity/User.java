package com.squidco.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
// import java.sql.Timestamp;

// Data Model for User 
@Entity
@Table(name="users")
public class User {
    
    public enum UserRole {
        user,
		staff,
		admin;
    }


    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

	@Column(name="password")
	private String password;

    @Column(name="email")
    private String email;

	@Enumerated(EnumType.STRING)
    @Column(name="role")
    private UserRole role;

    @Column(name="date_of_birth")
    private Date birthday;

    //   @Column("created_at")
    // private Timestamp created;
    
    // @Column("updated_at")
    // private Timestamp updated;

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole input) {
		this.role = input;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", role="
				+ role + ", birthday=" + birthday + "]";
	}

    

}
