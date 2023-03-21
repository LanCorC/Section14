package crg.rla.section14190;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();


    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Planet("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBody body = solarSystem.get("Mars");
        System.out.println("Moons of " + body.getName());
        for(HeavenlyBody jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }

        System.out.println();

        HeavenlyBody pluto = new Planet("Pluto", 842);
        planets.add(pluto); //Test case 1: pass
        for(HeavenlyBody planet : planets) {
            System.out.println(planet.getName() + " (" + planet.getBodyType() +"): "
                    + planet.getOrbitalPeriod());
        }

        Object o = new Object();
        o.equals(o);
        "pluto".equals("");

        //This implements onto the Map, which is more difficult than Set
        HeavenlyBody betaMinor1 = new Planet("BetaMinor", 822);
        solarSystem.put(betaMinor1.getName(), betaMinor1);
        planets.add(betaMinor1);

        System.out.println();

        HeavenlyBody betaMinor2 = new Asteroid("BetaMinor", 822);
        solarSystem.put(betaMinor2.getName(), betaMinor2);
        planets.add(betaMinor2);

//        for(String planet : solarSystem.keySet()) {
//            temp = solarSystem.get(planet);
//            System.out.println(temp.getName() + " (" + temp.getBodyType() +"): "
//                    + temp.getOrbitalPeriod());
//        }
        //Because the map uses the name for the key, same name => replace.
        //

        //This implement is for the set (not a key:value relationship)
        //Test case 5: pass
        for(HeavenlyBody planet : planets) {
            System.out.println(planet.getName() + " (" + planet.getBodyType() +"): "
                    + planet.getOrbitalPeriod());
        }

        System.out.println();

        //Compare check (Test case 2): a.equals(b), b.equals(b), a.equals(a)
        //expecting: xSymmetry, xSymmetry, true
        System.out.println(betaMinor1.equals(betaMinor2) + " " +
                betaMinor2.equals(betaMinor1) + " "
                + betaMinor1.equals(betaMinor1));

        System.out.println();

        //Test case 3: pass
        betaMinor1 = new Planet("BetaMinor", 1);
        planets.add(betaMinor1);
        for(HeavenlyBody planet : planets) {
            System.out.println(planet.getName() + " (" + planet.getBodyType() +"): "
                    + planet.getOrbitalPeriod());
        }

    }
}
