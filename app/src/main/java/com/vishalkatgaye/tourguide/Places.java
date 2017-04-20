package com.vishalkatgaye.tourguide;

/**
 * Created by ViSh on 02-04-2017.
 * <p>
 * {@Link Places} represents place images and information that the user seek. </p>
 */

public class Places {
    /**
     * @param mPlaceInfo Constant value that saves the places information.
     * @param mPlaceName Constant value that saves the place name.
     */
    private String mPlaceInfo;
    private String mPlaceName;

    /**
     * Constant value that represents no image provided to the places.
     */
    private final static int NO_IMAGE_PROVIDED = -1;

    /**
     * Images resource ID for places
     */
    private int mImagesResourceId = NO_IMAGE_PROVIDED;

    /**
     * This is a parameterize constructor will take two string.
     *
     * @param placeName        will provide name of the place.
     * @param info             will provide information of a given place.
     * @param imagesResourceId will provide image resource id.
     **/
    public Places(String placeName, String info, int imagesResourceId) {
        mPlaceName = placeName;
        mPlaceInfo = info;
        mImagesResourceId = imagesResourceId;
    }

    /**
     * This constructor will take two values.
     *
     * @param placeName        stores name of the place.
     * @param imagesResourceId stores image of the place.
     */
    public Places(String placeName, int imagesResourceId) {
        mPlaceName = placeName;
        mImagesResourceId = imagesResourceId;
    }

    /**
     * Will show name of the place.
     */
    public String getPlaceName() {
        return mPlaceName;
    }

    /**
     * Will get place information.
     */
    public String getInfo() {
        return mPlaceInfo;
    }

    /**
     * Get specified location image
     *
     * @return mImageResourceId
     */
    public int getImagesResourceId() {
        return mImagesResourceId;
    }

    /**
     * @return this method returns true if there is image available.
     */
    public boolean hasImage() {
        return mImagesResourceId != NO_IMAGE_PROVIDED;
    }

}
