package Model;

public class PlacesModel {

    private String placeName;
    private int placeId;
    private int coordinates;
    private int placePhoneNumber;
    private String offers;
    private String address;
    private String desc;
    private String photos;

    public PlacesModel(String placeName,String address,int placeId, int coordinates, int placePhoneNumber, String offers, String desc, String photos) {

        this.placeName = placeName;
        this.placeId = placeId;
        this.coordinates = coordinates;
        this.placePhoneNumber = placePhoneNumber;
        this.offers = offers;
        this.desc = desc;
        this.photos = photos;
        this.address=address;
    }

    public String getPlaceName() {
        return placeName;
    }

    public int getPlaceId() {
        return placeId;
    }

    public int getCoordinates() {
        return coordinates;
    }

    public int getPlacePhoneNumber() {
        return placePhoneNumber;
    }

    public String getOffers() {
        return offers;
    }

    public String getDesc() {
        return desc;
    }

    public String getPhotos() {
        return photos;
    }

    public String getAddress() {
        return address;
    }
}