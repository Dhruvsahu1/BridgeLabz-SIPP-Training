public class earth_volume {
    public static void main(String[] args) {
        int radiusEarth = 6378;
        double radiusEarthInMiles = radiusEarth * 0.6;
        double volumeinMiles = (4.0 / 3.0) * Math.PI * Math.pow(radiusEarthInMiles, 3);
        double volumeEarth = (4.0 / 3.0) * Math.PI * Math.pow(radiusEarth, 3);

        System.out.printf("The volume of Earth in cubic kilometers is %.2f and in cubic miles is %.2f\n", volumeEarth, volumeinMiles);
    }
}
