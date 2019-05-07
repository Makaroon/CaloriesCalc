package com.caloriescalculator;

public class User {
    private String name;
    private String surname;
    private String username;
    String password;
    private String gender;
    private double weight;
    private double height;
    int age;

    private int currentCalories;
    private int fatPercentage;

    public User(String name, String surname, String username, String gender, double weight, double height) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        currentCalories = 0;
        fatPercentage = 0;
    }

    double countProperWeight(double weight, double height, String gender, int age, int fatPercentage) {
        return (countHarrisonBenedict(weight, height, gender, age) +
                countMifflinStJeor(weight, height, gender, age) +
                countKatchMcArdle(weight, height, age, fatPercentage)) / 3;
    }

    private double countHarrisonBenedict(double weight, double height, String gender, int age) {
        double res = 0;
        switch (gender) {
            case ("male"):
                res = 66 + 13.7 * weight + 5 * height - 6.76 * age;
                break;
            case ("female"):
                res = 655 + 9.6 * weight + 1.8 + height - 4.7 * age;
                break;
            default:
                break;
        }
        return res;
    }

    private double countMifflinStJeor(double weight, double height, String gender, int age) {
        double res = 9.99 * weight + 6.25 * height - 4.92 * age;
        switch (gender) {
            case ("male"):
                res += 5;
                break;
            case ("female"):
                res -= 161;
                break;
            default:
                break;
        }
        return res;
    }

    private double countKatchMcArdle(double weight, double height, int age, int fatPerc) {
        double lbm = (weight * (100 - fatPerc)) / 100;
        return 370 + 21.6 * lbm;
    }

    void increaseCurrentCalories(int delta) {
        currentCalories += delta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getCurrentCalories() {
        return currentCalories;
    }

    public void setCurrentCalories(int currentCalories) {
        this.currentCalories = currentCalories;
    }

    public int getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(int fatPercentage) {
        this.fatPercentage = fatPercentage;
    }
}
