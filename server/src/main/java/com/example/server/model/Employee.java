package com.example.server.model;


public class Employee {
    private boolean assigned;
    private WorkOrder workOrder;
    private ServiceType serviceType;

    public Employee(ServiceType serviceType) {
        this.assigned = false;
        this.serviceType = serviceType;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    public void notifyWorkDone(){
        this.assigned = false;
        this.workOrder.complete();
        this.workOrder = null;
    }
}
