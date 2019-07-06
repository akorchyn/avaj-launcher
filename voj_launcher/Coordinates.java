package voj_launcher;

public class Coordinates {
    private int longitude = 0;
    private int latitude = 0;
    private int height = 0;

    Coordinates(int longitude, int latitude, int height) throws AvajException {
        if (longitude < 0 || latitude < 0 || height < 0)
            throw new AvajException("Invalid coordinates");
        updateHeight(height);
        updateLongitude(longitude);
        updateLatitude(latitude);
    }

    public int getLongitude() {
        return longitude;
    }
    public int getLatitude() {
        return latitude;
    }
    public int getHeight() {
        return height;
    }

    public void updateLongitude(int delta) {
        longitude += delta;
    }
    public void updateLatitude(int delta) {
        latitude += delta;
    }
    public void updateHeight(int delta) {
        height += delta;
        if (height < 0)
            height = 0;
        else if (height > 100)
            height = 100;
    }
}
