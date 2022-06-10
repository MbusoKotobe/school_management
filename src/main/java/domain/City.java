/***
 * City.java
 * Entity for the City
 * @Author: Elvis Ndlangamandla (213063964)
 * Date: 10 June 2022
 */
package domain;

import com.sun.istack.Builder;

public class City {
    private String id;
    private  String name;
    private Country country;

    private City(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.country = builder.country;

    }
    public String getId(){
        return id;

    }
    public String getName() {
        return name;

    }

    public Country getCountry() {
        return country;

    }

    public static class Builder {
        private String id;
        private String name;
        private Country country;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Country setCountry(Country country) {
            this.country = country;

            return country;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", country=" + country +
                    '}';
        }

        public City build() {
            return new City(this);
        }

    }
}






