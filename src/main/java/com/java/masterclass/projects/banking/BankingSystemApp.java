package com.java.masterclass.projects.banking;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class BankingSystemApp {
    private BankingSystemApp() {}

    public static final class Account {
        private final String accountNo;
        private BigDecimal balance;

        public Account(String accountNo, BigDecimal balance) {
            this.accountNo = accountNo;
            this.balance = balance;
        }

        public synchronized void deposit(BigDecimal amount) {
            balance = balance.add(amount);
        }

        public synchronized boolean withdraw(BigDecimal amount) {
            if (balance.compareTo(amount) < 0) return false;
            balance = balance.subtract(amount);
            return true;
        }

        public synchronized BigDecimal balance() { return balance; }
        public String accountNo() { return accountNo; }
    }

    public static final class BankingService {
        private final Map<String, Account> accounts = new HashMap<>();

        public void create(String accountNo, BigDecimal opening) {
            accounts.put(accountNo, new Account(accountNo, opening));
        }

        public boolean transfer(String from, String to, BigDecimal amount) {
            Account source = accounts.get(from);
            Account destination = accounts.get(to);
            if (source == null || destination == null) return false;
            synchronized (this) {
                if (!source.withdraw(amount)) return false;
                destination.deposit(amount);
                return true;
            }
        }
    }
}
