package com.example.moattravel_3.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.moattravel_3.entity.User;

public class UserDetailsImpl implements UserDetails {
	private final User user;
	private final Collection<GrantedAuthority> authorities;

	public UserDetailsImpl(User user, Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}

	public User getUser() {
		return user;
	}

	//ハッシュ化したパスワードを返す
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	//ログイン時に利用するメールを返す
	@Override
	public String getUsername() {
		return user.getEmail();
	}

	//ロールのコレクションを返す
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	//アカウントが期限切れ出なければtrue
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//ユーザがロックされてなければtrue
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//ユーザが有効であればtrue
	@Override
	public boolean isEnabled() {
		return user.getEnabled();
	}
}
