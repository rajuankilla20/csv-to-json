package model.gpod;

import java.util.Date;
import java.util.Objects;

public class UserGpod {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String university;
    private String campus;
    private String mackId;
    private String userType;
    private String userRole;
    private String schoolYear;
    private String graduationDate;
    private String empId;
    private String license;
    private String licenseType;
    private String licenseState;
    private String vregistration;
    private String locationId;
    private String password;
    private boolean isActive;
    private String rememberToken;
    private String apiToken;
    private Date createdTimestamp;
    private Date updatedTimestamp;

    public UserGpod() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getMackId() {
        return mackId;
    }

    public void setMackId(String mackId) {
        this.mackId = mackId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getLicenseState() {
        return licenseState;
    }

    public void setLicenseState(String licenseState) {
        this.licenseState = licenseState;
    }

    public String getVregistration() {
        return vregistration;
    }

    public void setVregistration(String vregistration) {
        this.vregistration = vregistration;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Date getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Date updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    @Override
    public String toString() {
        return "UserGpod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", university='" + university + '\'' +
                ", campus='" + campus + '\'' +
                ", mackId='" + mackId + '\'' +
                ", userType='" + userType + '\'' +
                ", userRole='" + userRole + '\'' +
                ", schoolYear='" + schoolYear + '\'' +
                ", graduationDate=" + graduationDate +
                ", empId='" + empId + '\'' +
                ", license='" + license + '\'' +
                ", licenseType='" + licenseType + '\'' +
                ", licenseState='" + licenseState + '\'' +
                ", vregistration='" + vregistration + '\'' +
                ", locationId='" + locationId + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", rememberToken='" + rememberToken + '\'' +
                ", apiToken='" + apiToken + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}
