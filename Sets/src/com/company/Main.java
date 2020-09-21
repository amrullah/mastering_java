package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        addHeavenlyBodies();
        printPlanets();

        printMoons(solarSystem.get("Jupiter"));
        printMoons(solarSystem.get("Mars"));

        printAllMoons();


    }

    private static void printAllMoons() {
        Set<HeavenlyBody> allMoons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            allMoons.addAll(planet.getSatellites());
        }
        System.out.println("All the moons of Solar System:");
        for (HeavenlyBody moon : allMoons) {
            System.out.println(moon);
        }
        System.out.println();
    }

    private static void printMoons(HeavenlyBody planet) {
        System.out.printf("%1$s's moons:\n", planet.getName());
        for (HeavenlyBody moon : planet.getSatellites()) {
            System.out.println(moon);
        }
        System.out.println();
    }

    private static void printPlanets() {
        System.out.println("Planets:");
        for (var planet : planets) {
            System.out.println(planet);
        }
        System.out.println();
    }

    private static void addHeavenlyBodies() {
        HeavenlyBody mercury = addHeavenlyBody("Mercury", 88, true);
        HeavenlyBody venus = addHeavenlyBody("Venus", 225, true);

        HeavenlyBody earth = addHeavenlyBody("Earth", 365, true);
        HeavenlyBody moon = addMoon(earth, "Moon", 27);

        HeavenlyBody mars = addHeavenlyBody("Mars", 687, true);
        HeavenlyBody deimos = addMoon(mars, "Deimos", 1.3);
        HeavenlyBody phobos = addMoon(mars, "Phobos", 0.3);

        HeavenlyBody jupiter = addHeavenlyBody("Jupiter", 4332, true);
        HeavenlyBody io = addMoon(jupiter, "Io", 1.8);
        HeavenlyBody europa = addMoon(jupiter, "Europa", 3.5);
        HeavenlyBody ganymede = addMoon(jupiter, "Ganymede", 7.1);
        HeavenlyBody callisto = addMoon(jupiter, "Callisto", 16.7);

        HeavenlyBody saturn = addHeavenlyBody("Saturn", 10759, true);
        HeavenlyBody uranus = addHeavenlyBody("Uranus", 30660, true);
        HeavenlyBody neptune = addHeavenlyBody("Neptune", 165*365, true);
        HeavenlyBody pluto = addHeavenlyBody("Pluto", 248*365, true);
    }

    private static HeavenlyBody addMoon(HeavenlyBody planet, String moonName, double orbitalPeriod) {
        HeavenlyBody moon = addHeavenlyBody(moonName, orbitalPeriod, false);
        planet.addMoon(moon);
        return moon;
    }

    private static HeavenlyBody addHeavenlyBody(String name, double orbitalPeriod, boolean isPlanet) {
        HeavenlyBody heavenlyBody = new HeavenlyBody(name, orbitalPeriod);
        solarSystem.put(heavenlyBody.getName(), heavenlyBody);
        if (isPlanet) {
            planets.add(heavenlyBody);
        }
        return heavenlyBody;
    }
}
