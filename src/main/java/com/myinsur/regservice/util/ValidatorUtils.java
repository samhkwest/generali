package com.myinsur.regservice.util;

public class ValidatorUtils {
	public static boolean checkPhoneNo(String phoneNo) {
		return (phoneNo.length() == 8);
	}
}
