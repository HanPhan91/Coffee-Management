package com.codegym.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberInvalid {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String PHONE_REGEX= "^[0][\\d]{9}$";
    public PhoneNumberInvalid(){
        pattern= Pattern.compile(PHONE_REGEX);
    }
    public boolean validate(String regex){
        matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
