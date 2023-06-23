package org.drools.demo;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class RequestUnit implements RuleUnitData {
    private DataStore<Request> requests;

   public RequestUnit() {
   	this(DataSource.createStore());
   }

   public RequestUnit(DataStore<Request> requests) {
   	this.requests = requests;
   }

    public DataStore<Request> getRequests() {
        return requests;
    }

    public void setRequests(DataStore<Request> requests) {
        this.requests = requests;
    }
}
