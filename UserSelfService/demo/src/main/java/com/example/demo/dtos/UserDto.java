package com.example.demo.dtos;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
	private String name;
	private String email;
	private List<Role> roles;

	public static UserDto from(User user){
		UserDto userDto = new UserDto();
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setRoles(user.getRoles());

		return userDto;
	}
}
