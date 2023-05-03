package com.moaaz.train.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.websocket.OnMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name Must Not Be Empty")
    @NotNull(message = "Name Must Not Be Null")
    private String name;
    @NotEmpty(message = "Phone Must Not Be Empty")
    private String phone;
    @Email
    private String email;
    @Size(min = 8, message = "Password Must Be Greater Than 8")
    private String password;
//
//	public Person(int id, String name, String phone, String email, String password) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.phone = phone;
//		this.email = email;
//		this.password = password;
//		
//	}

//	public Person() {
//
//	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

}
