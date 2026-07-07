package com.java.masterclass.designpatterns;

public final class BuilderPattern {
    private BuilderPattern() {}

    public static final class User {
        private final String name;
        private final String email;

        private User(Builder builder) {
            this.name = builder.name;
            this.email = builder.email;
        }

        public String name() { return name; }
        public String email() { return email; }

        public static final class Builder {
            private String name;
            private String email;

            public Builder name(String name) {
                this.name = name;
                return this;
            }

            public Builder email(String email) {
                this.email = email;
                return this;
            }

            public User build() {
                return new User(this);
            }
        }
    }
}
