package crg.rla.challenge44Sets;

public class Planet extends HeavenlyBody {
    // write code here
    public Planet(String name, double orbitalPeriod) {
        super(name, HeavenlyBody.BodyTypes.PLANET, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == BodyTypes.MOON) {
            return super.addSatellite(moon);
        }

        return false;
    }
}