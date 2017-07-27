package com.matthewddiaz.datastructures.graphs.weightedGraphs;

import com.matthewddiaz.datastructures.graphs.Edge;
import com.matthewddiaz.datastructures.graphs.Vertex;

/**
 * Created by matthewdiaz on 7/23/17.
 */
public class WeightedEdge<T> extends Edge implements Comparable<WeightedEdge<T>>{
    private int weight;

    public WeightedEdge(Vertex<T> source, Vertex<T> destination, int weight){
        super(source, destination);
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedEdge<T> other) {
        if(this.weight == other.weight){
            return 0;
        }else if(this.weight > other.weight){
            return 1;
        }else{
            return -1;
        }
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public String toString(){
        return super.toString() + ", weight: " + this.weight;
    }
}
