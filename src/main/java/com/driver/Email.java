package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(password.equals(oldPassword)) {
            if(isValidPass(newPassword)){
                this.password = newPassword;
            }
        }
    }
    private boolean isValidPass(String newPass){
        int len = newPass.length();
        boolean hasUC = false;  //UC - UpperCase
        boolean hasLC = false;  //LC - Lowercase
        boolean hasDig = false; //Dig - Digit
        boolean hasSC = false;  //SC - Special Character
        if(len<8) return false;
        for(int i =0; i<len; i++){
            char val = newPass.charAt(i);
            if(val>='A' && val<='Z') hasUC = true;
            else if(val>='0' && val<='9')  hasDig = true;
            else if(val>='a' && val<='z')  hasLC = true;
            else hasSC = true;
        }
        if(hasSC && hasLC && hasUC && hasDig) return true;
        return false;
    }
}
