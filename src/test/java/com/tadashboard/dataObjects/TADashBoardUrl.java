package com.tadashboard.dataObjects;

public enum TADashBoardUrl {
    LOGIN("http://localhost/TADashboard/login.jsp"),
    DASHBOARD("http://localhost/TADashboard/cooed143v86q.page");

    public final String Url;

    TADashBoardUrl(String Url) {
        this.Url = Url;
    }

    public String getUrl() {
        return this.Url;
    }
}
