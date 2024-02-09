package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Nonprofit organization.
 */
public class Nonprofit {
    private String legalName;
    private String ein;
    private String mission;
    private Address address;
    public List<GrantSubmission> grantSubmissions;

    /**
     * Default constructor for Nonprofit class.
     * Initializes the grantSubmissions list.
     */
    public Nonprofit() {
        this.grantSubmissions = new ArrayList<>();
    }

    /**
     * Getter for the legal name of the nonprofit.
     *
     * @return The legal name of the nonprofit.
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * Setter for the legal name of the nonprofit.
     *
     * @param legalName The legal name to set for the nonprofit.
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    /**
     * Getter for the EIN (tax id) of the nonprofit.
     *
     * @return The EIN of the nonprofit.
     */
    public String getEin() {
        return ein;
    }

    /**
     * Setter for the EIN (tax id) of the nonprofit.
     *
     * @param ein The EIN to set for the nonprofit.
     */
    public void setEin(String ein) {
        this.ein = ein;
    }

    /**
     * Getter for the mission of the nonprofit.
     *
     * @return The mission of the nonprofit.
     */
    public String getMission() {
        return mission;
    }

    /**
     * Setter for the mission of the nonprofit.
     *
     * @param mission The mission to set for the nonprofit.
     */
    public void setMission(String mission) {
        this.mission = mission;
    }

    /**
     * Getter for the address of the nonprofit.
     *
     * @return The address of the nonprofit.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setter for the address of the nonprofit.
     *
     * @param address The address to set for the nonprofit.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Getter for the list of grant submissions associated with the nonprofit.
     *
     * @return The list of grant submissions for the nonprofit.
     */
    public List<GrantSubmission> getGrantSubmissions() {
        return grantSubmissions;
    }

    /**
     * Setter for the list of grant submissions associated with the nonprofit.
     *
     * @param grantSubmissions The list of grant submissions to set for the nonprofit.
     */
    public void setGrantSubmissions(List<GrantSubmission> grantSubmissions) {
        this.grantSubmissions = grantSubmissions;
    }
}
