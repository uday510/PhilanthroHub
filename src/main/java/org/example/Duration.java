package org.example;

/**
 * Represents the duration of a grant with grant start and end dates.
 */
public class Duration {
    private String grantStart;
    private String grantEnd;

    /**
     * Default constructor for Duration.
     */
    public Duration() {
    }

    /**
     * Get the grant start date.
     *
     * @return The grant start date.
     */
    public String getGrantStart() {
        return grantStart;
    }

    /**
     * Set the grant start date.
     *
     * @param grantStart The grant start date to set.
     */
    public void setGrantStart(String grantStart) {
        this.grantStart = grantStart;
    }

    /**
     * Get the grant end date.
     *
     * @return The grant end date.
     */
    public String getGrantEnd() {
        return grantEnd;
    }

    /**
     * Set the grant end date.
     *
     * @param grantEnd The grant end date to set.
     */
    public void setGrantEnd(String grantEnd) {
        this.grantEnd = grantEnd;
    }
}
