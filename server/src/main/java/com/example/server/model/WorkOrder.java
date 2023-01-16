package com.example.server.model;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class WorkOrder {
    private final UUID uuid;
    private int estimatedTimeInMinutes;
    private int flightNumber;
    private Employee assignee;
    private Instant startDate;
    private Instant completionDate;

    private WorkOrder(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getEstimatedTimeInMinutes() {
        return estimatedTimeInMinutes;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public Employee getAssignee() {
        return assignee;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Instant getCompletionDate() {
        return completionDate;
    }

    public void complete(){
        this.completionDate = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkOrder workOrder = (WorkOrder) o;
        return Objects.equals(uuid, workOrder.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "Work{" +
                "uuid=" + uuid +
                ", estimatedTimeInMinutes=" + estimatedTimeInMinutes +
                ", flightNumber=" + flightNumber +
                ", assignee=" + assignee +
                ", startDate=" + startDate +
                ", completionDate=" + completionDate +
                '}';
    }

    public static final class Builder {
        private UUID id;
        private int estimatedTimeInMinutes;
        private int flightNumber;
        private Employee assignee;
        private Instant startDate;
        private Instant completionDate;

        public Builder estimatedTimeInMinutes(int estimatedTimeInMinutes) {
            this.estimatedTimeInMinutes = estimatedTimeInMinutes;
            return this;
        }

        public Builder assignee(Employee assignee) {
            this.assignee = assignee;
            return this;
        }

        public Builder startDate(Instant startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder flightNumber(int flightNumber) {
            this.flightNumber = flightNumber;
            return this;
        }

        public WorkOrder build() {
            if(flightNumber == 0){
                throw new IllegalStateException("Flight number required.");
            }

            WorkOrder work = id != null ? new WorkOrder(id) : new WorkOrder(UUID.randomUUID());
            work.estimatedTimeInMinutes = estimatedTimeInMinutes;
            work.assignee = assignee;
            work.flightNumber = flightNumber;
            work.startDate = startDate;
            return work;
        }
    }
}
