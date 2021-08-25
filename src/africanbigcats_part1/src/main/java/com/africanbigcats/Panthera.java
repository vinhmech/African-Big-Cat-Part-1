package com.africanbigcats;

import java.util.Random;
/*
 * Panthera base class that simulates GPS information
 */
public class Panthera extends PantheraGPS {

    /*
        TIP:
        Students will need to add additional attributes and methods to complete this classes
        implementation.
     */

    // constants 
    private final Integer maxWeight = 600;
    private final Integer minWeight = 10;

    // attributes
    private Integer weight;
    //private Float speed;
    private Random weightRandom;


    // constructor
    public Panthera(String name) {

        // call the super-class (parent) to instatiate it
        super(name);

        // initialize attributes
        this.setSpecies("panthera");

        // seed the random number generators for repeatable results
        this.weightRandom = new Random();
        this.weightRandom.setSeed(this.seed(name + "weight"));
        // set weight = weightRandom
        this.weight = weightRandom.nextInt(maxWeight - minWeight + 1) + minWeight;
    }

    // make a seed, based on the name
    private Integer seed(String s) {
        Integer seed = 0;

        for (Integer i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            seed += (int) ch;
        }

        return seed;
    }

    // getters
    public Integer getWeight(){
        return this.weight;
    }

    // roar method
    public void roar(){
        System.out.print("Rrrrrrrrroooooooaaaaarrrrr!");
    }


    // serializes attributes into a string
    @Override // override superclass method
    public String toString() {
        String s;

        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + this.name();
        s += ", ";
        s += "species: " + this.species();
        s += ", ";
        s += "longitude: " + this.longitude();
        s += ", ";
        s += "latitude: " + this.latitude();
        s += " }";
        s += "weight: " + this.getWeight();
        s += " }";
        return s;
    }
}
