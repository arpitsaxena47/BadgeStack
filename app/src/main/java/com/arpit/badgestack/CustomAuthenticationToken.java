package com.arpit.badgestack;

import android.provider.ContactsContract;

public class CustomAuthenticationToken {

    String Email;
    String Password;
    String username;
    String identity;

    public CustomAuthenticationToken( String Email , String Password , String username, String identity) {
        this.Email = Email;
        this.Password = Password;
        this.username = username;
        this.identity = identity;
    }
}
