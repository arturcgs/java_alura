package br.com.alura.screenwatch.models;

public class Movie {

    // atributes
    private String name;
    private int yearLaunch;
    private int durationInMinutes;
    private boolean includedInPlan;
    private double avaluationsSum;
    private int numberOfAvaluations;

    // getters

    public String getName() {
        return name;
    }

    public int getYearLaunch() {
        return yearLaunch;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    public int getNumberOfAvaluations() {
        return numberOfAvaluations;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setYearLaunch(int yearLaunch) {
        this.yearLaunch = yearLaunch;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    // functionality methods

    public void showsInformation() {
        System.out.println("Movie name: " + name);
        System.out.println("Launch year: " + yearLaunch);
        System.out.println("Duration in minutes: " + durationInMinutes);
        System.out.println("Included in Plan: " + includedInPlan);
    }

    public void avaluate(double avaluation) {
       avaluationsSum += avaluation;
       numberOfAvaluations++;
    }

    public double getMean(){
        return avaluationsSum / numberOfAvaluations;
    }

}