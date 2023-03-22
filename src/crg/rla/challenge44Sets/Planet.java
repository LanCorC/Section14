package crg.rla.challenge44Sets;

public class Planet extends HeavenlyBody {
    // write code here
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, HeavenlyBody.BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == BodyTypes.MOON) {
            return super.addSatellite(moon);
        }

        return false;
    }
}