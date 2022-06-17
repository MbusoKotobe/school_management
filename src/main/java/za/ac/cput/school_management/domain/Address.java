package za.ac.cput.school_management.domain;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

/**
 * @author Mbuso Kotobe (218040385)
 * Entity for Address
 * Date: 10 June 2022
 * */
@Embeddable
public class Address {

    @NotBlank(message = "Unit Number is mandatory")
    private String unitNumber;

    @NotBlank(message = "Complex is mandatory") //Not everyone stays in a complex.
    private String complexName;

    @NotBlank(message = "Street Number is mandatory")
    private String streetNumber;

    @NotBlank(message = "Complex Name is mandatory")
    private String streetName;

    @NotBlank(message = "Postal Code is mandatory")
    private String postalCode;

    @NotNull(message = "City is mandatory")
    @ManyToOne(cascade = { PERSIST, MERGE })
    @NotFound(action = NotFoundAction.IGNORE)
    private City city;

    protected Address(){ }

    private Address(Builder builder)
    {
        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
    }

    public String getUnitNumber()
    {
        return unitNumber;
    }

    public String getComplexName()
    {
        return complexName;
    }

    public String getStreetNumber()
    {
        return streetNumber;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public City getCity()
    {
        return city;
    }

    private void setUnitNumber(String unitNumber)
    {
        this.unitNumber = unitNumber;
    }

    private void setComplexName(String complexName)
    {
        this.complexName = complexName;
    }

    private void setStreetNumber(String streetNumber)
    {
        this.streetNumber = streetNumber;
    }

    private void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    private void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    private void setCity(City city)
    {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city=" + city +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getUnitNumber().equals(address.getUnitNumber()) && getComplexName().equals(address.getComplexName()) && getStreetNumber().equals(address.getStreetNumber()) && getStreetName().equals(address.getStreetName()) && getPostalCode().equals(address.getPostalCode()) && getCity().equals(address.getCity());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUnitNumber(), getComplexName(), getStreetNumber(), getStreetName(), getPostalCode(), getCity());
    }

    public static class Builder
    {
        private String unitNumber;
        private String complexName;
        private String streetNumber;
        private String streetName;
        private String postalCode;
        private City city;

        public Builder setUnitNumber(String unitNumber)
        {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder setComplexName(String complexName)
        {
            this.complexName = complexName;
            return this;
        }

        public Builder setStreetNumber(String streetNumber)
        {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName)
        {
            this.streetName = streetName;
            return this;
        }

        public Builder setPostalCode(String postalCode)
        {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCity(City city)
        {
            this.city = city;
            return this;
        }

        public Builder copy(Address address)
        {
            this.unitNumber = address.unitNumber;
            this.complexName = address.complexName;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postalCode = address.postalCode;
            this.city = address.city;
            return this;
        }

        public Address build()
        {
            return new Address(this);
        }
    }
}