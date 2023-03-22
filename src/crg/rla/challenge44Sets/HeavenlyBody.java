package crg.rla.challenge44Sets;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;

    public enum BodyTypes {
        PLANET, DWARF_PLANET, MOON
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        key = new Key(name, bodyType);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public Key getKey() {
        return this.key;
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj != null && obj.getClass() == this.getClass()) { //classCheck
            Key objKey = ((HeavenlyBody) obj).getKey();
            return key.equals(objKey);
        }

        return false;
    }

    @Override
    public final int hashCode() {
//        System.out.println("hashcode called");
        return key.hashCode();
    }

    @Override
    public String toString() {
        return key.toString() + ", " + orbitalPeriod;
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return name.hashCode() + 57 + bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this==obj) { //self check
                return true;
            }

            if (obj == null) { //nullcheck
                return false;
            }


            if (obj instanceof Key) {
                Key objKey = (Key) obj;
                return objKey.getBodyType().equals(bodyType) && objKey.getName().equals(name);
            }

            return false; //not equals in name

        }

        @Override
        public String toString() {
            return name + ": " + bodyType;
        }
    }
}
