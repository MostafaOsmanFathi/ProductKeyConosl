package com.productkeyconsole.model.account;


import com.productkeyconsole.enumeration.AccountStatus;

public abstract sealed class Account permits CustomerAccount, SellerAccount, AdminAccount {
    private final String email;
    private String name;
    private String password;
    private double balance;
    private final int accountNumber;
    private static int accountCounter;
    private AccountStatus accountStatus;
    private Address address;

    static {
        accountCounter = 0;
    }


    public Account(String name, String email, String password, Address address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
        this.address = address;
        accountStatus = AccountStatus.ACTIVE;
        accountNumber = ++accountCounter;
    }

    public String getEmail() {
        return email;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void ChangeName(String oldPassword, String newName) {
        if (oldPassword.equals(this.password)) {
            this.name = newName;
        }
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean ChangePassword(String oldPassword, String newPassword) {
        if (checkPassword(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    public void deactivateAccount() {
        accountStatus = AccountStatus.INACTIVE;
    }

    public void setBlacklistedStatus(Object ob) {
        if (ob instanceof AdminAccount) {
            accountStatus = AccountStatus.BLACKLISTED;
        }
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
        }
        return false;
    }

    public void changeAddress(Address address) {
        this.address = address;
    }

    public String getAddress() {
        return address.toString();
    }

    @Override
    public String toString() {
        return email + " " + name + accountNumber + " " + balance;
    }
}
