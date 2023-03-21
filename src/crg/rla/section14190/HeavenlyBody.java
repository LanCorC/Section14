package crg.rla.section14190;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final HeavenlyBodyType bodyType;

    public HeavenlyBody(String name, double orbitalPeriod,
                        HeavenlyBodyType bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        if (bodyType == HeavenlyBodyType.PLANET &&
                moon.bodyType == HeavenlyBodyType.MOON) {
            return this.satellites.add(moon);
        }
        System.out.println(
                "Invalid type: PLANETS can only have MOON satellites");
        return false;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<HeavenlyBody>(satellites);
    }

    public HeavenlyBodyType getBodyType() {
        return bodyType;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

//        System.out.println("obj.getClass() is " + obj.getClass());
//        System.out.println("this.getClass() is " + this.getClass());

        if ((obj== null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        HeavenlyBodyType objType = ((HeavenlyBody) obj).getBodyType();
        return this.name.equals(objName) &&
                this.bodyType.equals(objType);
    }

    @Override
    public final int hashCode() {
//        System.out.println("hashCode() called");
        return this.name.hashCode() + 57 + bodyType.hashCode();
    }
}

class Star extends HeavenlyBody {

    public Star(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, HeavenlyBodyType.STAR);
    }
}

class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, HeavenlyBodyType.PLANET);
    }
}

class Moon extends HeavenlyBody {

    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, HeavenlyBodyType.MOON);
    }
}

class Asteroid extends HeavenlyBody {

    public Asteroid(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, HeavenlyBodyType.ASTEROID);
    }
}