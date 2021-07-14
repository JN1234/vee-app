package com;

import javax.persistence.*;

@Entity
@Table
public class Issues {

    @Id
    @SequenceGenerator(
            name = "issues_sequence",
            sequenceName = "issues_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "issues_sequence"
    )
    private long id;

    @Column(nullable = true, length = 45)
    private String equipment;
    @Column(nullable = true, length = 45)
    private String description;
    @Column(nullable = true, length = 250)
    private String equipState;
    @Column(nullable = true, length = 250)
    private String location;
    @Column(nullable = true, length = 250)
    private String inspector;
    @Column(nullable = true, length = 250)
    private String supervisor;
    @Column(nullable = true, length = 250)
    private String superFeedback;

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getSuperFeedback() {
        return superFeedback;
    }

    public void setSuperFeedback(String superFeedback) {
        this.superFeedback = superFeedback;
    }

    public Issues() {
        this.supervisor="not yet";
        this.superFeedback="no feedback yet";
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEquipState() { return equipState; }

    public void setEquipState(String equipState) { this.equipState = equipState; }
}
