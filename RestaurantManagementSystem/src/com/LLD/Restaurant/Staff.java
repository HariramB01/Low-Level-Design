    package com.LLD.Restaurant;

    public class Staff {
        private String id;
        private String name;
        private String role;
        private String contact;

        public Staff(String id, String name, String role, String contact) {
            this.id = id;
            this.name = name;
            this.role = role;
            this.contact = contact;
        }

        @Override
        public String toString() {
            return "Staff{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", role='" + role + '\'' +
                    ", contact='" + contact + '\'' +
                    '}';
        }
    }
