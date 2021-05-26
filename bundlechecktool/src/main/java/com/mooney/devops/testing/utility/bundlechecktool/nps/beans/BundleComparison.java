package com.mooney.devops.testing.utility.bundlechecktool.nps.beans;

public class BundleComparison {
    private String mainEnvBundleName;
    private String mainEnvBundleVersion;
    private String envToCheckBundleVersion;
    private String envToCheckBundleName;

    public String getMainEnvBundleName() {
        return mainEnvBundleName;
    }

    public void setMainEnvBundleName(String mainEnvBundleName) {
        this.mainEnvBundleName = mainEnvBundleName;
    }

    public String getMainEnvBundleVersion() {
        return mainEnvBundleVersion;
    }

    public void setMainEnvBundleVersion(String mainEnvBundleVersion) {
        this.mainEnvBundleVersion = mainEnvBundleVersion;
    }

    public String getEnvToCheckBundleVersion() {
        return envToCheckBundleVersion;
    }

    public void setEnvToCheckBundleVersion(String envToCheckBundleVersion) {
        this.envToCheckBundleVersion = envToCheckBundleVersion;
    }

    public String getEnvToCheckBundleName() {
        return envToCheckBundleName;
    }

    public void setEnvToCheckBundleName(String envToCheckBundleName) {
        this.envToCheckBundleName = envToCheckBundleName;
    }

    public BundleComparison() {
    }

    public BundleComparison(String mainEnvBundleName, String mainEnvBundleVersion, String envToCheckBundleVersion, String envToCheckBundleName) {
        this.mainEnvBundleName = mainEnvBundleName;
        this.mainEnvBundleVersion = mainEnvBundleVersion;
        this.envToCheckBundleVersion = envToCheckBundleVersion;
        this.envToCheckBundleName = envToCheckBundleName;
    }
}
