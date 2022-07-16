package com.unittest.project;

import java.util.Scanner;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

class AuthorizeUserTest {

	boolean auth() {
		AuthorizeUser au = new AuthorizeUser();
		return au.authorizeUser();
	}

	@Test
	@EnabledIf("auth")
	public void runIfTrue() {
		System.out.println("User Authorization positive test Succeed..");
	}
	@Test
	@DisabledIf("auth")
	public void runsIfFalse() {
		System.out.println("User Authorization negative test Succeed ..");
	}

}
