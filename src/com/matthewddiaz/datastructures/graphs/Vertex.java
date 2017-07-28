package com.matthewddiaz.datastructures.graphs;

/**
 * Created by matthewdiaz on 7/23/17.
 */
public class Vertex<T extends Comparable> implements Comparable<Vertex<T>>{
    T id;
    //Distance from source vertex. Used in BFS.
    int distance;
    //parent vertex
    Vertex parent;
    //either 0,1, or 2 for undiscovered, discovered, or finished
    int visit_state;

    public void setId(T id) {
        this.id = id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public int getVisit_state() {
        return visit_state;
    }

    public void setVisit_state(int visit_state) {
        this.visit_state = visit_state;
    }

    public int getDiscoveredTimeStamp() {
        return discoveredTimeStamp;
    }

    public void setDiscoveredTimeStamp(int discoveredTimeStamp) {
        this.discoveredTimeStamp = discoveredTimeStamp;
    }

    public int getFinishedTimeStamp() {
        return finishedTimeStamp;
    }

    public void setFinishedTimeStamp(int finishedTimeStamp) {
        this.finishedTimeStamp = finishedTimeStamp;
    }

    //used in DFS
    int discoveredTimeStamp;
    //used in DFS
    int finishedTimeStamp;

    public Vertex(T id) {
        this.id = id;
        distance = Integer.MAX_VALUE;
        parent = null;
        visit_state = 0;
        discoveredTimeStamp = 0;
        finishedTimeStamp = 0;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer("Vector ID: " + this.id + "\n");
        buffer.append("Distance From source: " + this.distance + "\n");
        buffer.append("Predecessor: ");
        if (this.parent == null) {
            buffer.append("null");
        } else {
            buffer.append(this.parent.id);
        }
        buffer.append("\n");
        buffer.append("Discovered time stamp: " + this.discoveredTimeStamp + "\n");
        buffer.append("Finished time stamp: " + this.finishedTimeStamp);
        buffer.append("\n");

        return buffer.toString();
    }

    public T getId() {
        return this.id;
    }

    @Override
    public int compareTo(Vertex<T> other) {
        int compareVal =  this.getId().compareTo(other.getId());

        if(compareVal == 0){
            return 0;
        }else if(compareVal > 0){
            return 1;
        }else{
            return -1;
        }
    }
}

