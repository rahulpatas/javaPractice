package OpenDoor;

public class Home {

    int num_bedrooms;
    int num_bathrooms;
    double living_area;
    double lat;
    double lon;
    int exterior_stories;
    short pool;
    short dwelling_type;

    public Home(int num_bedrooms, int num_bathrooms,
                double living_area, double lat, double lon,
                int exterior_stories, short pool, short dwelling_type) {
        this.num_bedrooms = num_bedrooms;
        this.num_bathrooms = num_bathrooms;
        this.living_area = living_area;
        this.lat = lat;
        this.lon = lon;
        this.exterior_stories = exterior_stories;
        this.pool = pool;
        this.dwelling_type = dwelling_type;
    }


    public int getNum_bedrooms() {
        return num_bedrooms;
    }

    public int getNum_bathrooms() {
        return num_bathrooms;
    }

    public double getLiving_area() {
        return living_area;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public int getExterior_stories() {
        return exterior_stories;
    }

    public short getPool() {
        return pool;
    }

    public short getDwelling_type() {
        return dwelling_type;
    }
}
