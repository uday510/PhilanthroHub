package org.example;

/**
 * Represents the address information.
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    // Getters and setters

    /**
     * Gets the street address.
     *
     * @return The street address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address.
     *
     * @param street The street address to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the city.
     *
     * @return The city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state.
     *
     * @return The state.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state The state to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the ZIP code.
     *
     * @return The ZIP code.
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the ZIP code.
     *
     * @param zip The ZIP code to set.
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
}
