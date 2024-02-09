package org.example;

import java.util.List;

/**
 * Represents a grant submission with details such as nonprofit ID, grant name, requested amount, awarded amount, grant type,
 * tags, and duration.
 */
public class GrantSubmission {
    private int nonprofitId;
    private String grantName;
    private String requestedAmount;
    private String awardedAmount;
    private GrantType grantType;
    private List<String> tags;
    private Duration duration;

    /**
     * Get the nonprofit ID associated with the grant submission.
     *
     * @return The nonprofit ID.
     */
    public int getNonprofitId() {
        return nonprofitId;
    }

    /**
     * Set the nonprofit ID associated with the grant submission.
     *
     * @param nonprofitId The nonprofit ID to set.
     */
    public void setNonprofitId(int nonprofitId) {
        this.nonprofitId = nonprofitId;
    }

    /**
     * Get the name of the grant.
     *
     * @return The grant name.
     */
    public String getGrantName() {
        return grantName;
    }

    /**
     * Set the name of the grant.
     *
     * @param grantName The grant name to set.
     */
    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    /**
     * Get the requested amount for the grant.
     *
     * @return The requested amount.
     */
    public String getRequestedAmount() {
        return requestedAmount;
    }

    /**
     * Set the requested amount for the grant.
     *
     * @param requestedAmount The requested amount to set.
     */
    public void setRequestedAmount(String requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    /**
     * Get the awarded amount for the grant.
     *
     * @return The awarded amount.
     */
    public String getAwardedAmount() {
        return awardedAmount;
    }

    /**
     * Set the awarded amount for the grant.
     *
     * @param awardedAmount The awarded amount to set.
     */
    public void setAwardedAmount(String awardedAmount) {
        this.awardedAmount = awardedAmount;
    }

    /**
     * Get the type of the grant.
     *
     * @return The grant type.
     */
    public GrantType getGrantType() {
        return grantType;
    }

    /**
     * Set the type of the grant.
     *
     * @param grantType The grant type to set.
     */
    public void setGrantType(GrantType grantType) {
        this.grantType = grantType;
    }

    /**
     * Get the list of tags associated with the grant.
     *
     * @return The list of tags.
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * Set the list of tags associated with the grant.
     *
     * @param tags The list of tags to set.
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * Get the duration of the grant.
     *
     * @return The duration.
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Set the duration of the grant.
     *
     * @param duration The duration to set.
     */
    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
