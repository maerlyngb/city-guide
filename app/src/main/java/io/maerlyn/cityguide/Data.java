package io.maerlyn.cityguide;

import android.content.Context;

import java.util.ArrayList;

/**
 * This class is responsible for providing the application with data
 *
 * @author Maerlyn Broadbent
 */
class Data {

    /**
     * Returns a list of places to visit
     *
     * @param c c
     * @return visit list
     */
    static ArrayList<Attraction> getVisitList(Context c) {
        ArrayList<Attraction> attrList = new ArrayList<>();

        // Sydey Opera House
        attrList.add(new Attraction(
                c.getString(R.string.oh_name),
                (float) 4.7,
                R.drawable.opera_house,
                c.getString(R.string.oh_desc),
                c.getString(R.string.oh_phone_num),
                c.getString(R.string.oh_url),
                 -33.8567844, 151.2152967));

        // Royal Botanic Gardens
        attrList.add(new Attraction(
                c.getString(R.string.rbg_name),
                (float) 4.7,
                R.drawable.gardens,
                c.getString(R.string.rbg_desc),
                c.getString(R.string.rbg_phone_num),
                c.getString(R.string.rbg_url),
                 -33.8641859, 151.2165708));

        // Blue Mountains
        attrList.add(new Attraction(
                c.getString(R.string.bm_name),
                (float) 4.6,
                R.drawable.blue_mountains,
                c.getString(R.string.bm_desc),
                c.getString(R.string.bm_phone_num),
                c.getString(R.string.bm_url),
                 -33.3496913,  150.0163484));

        // Manly Beach
        attrList.add(new Attraction(
                c.getString(R.string.mb_name),
                (float) 4.5,
                R.drawable.manly,
                c.getString(R.string.mb_desc),
                c.getString(R.string.mb_phone_num),
                c.getString(R.string.mb_url),
                 -33.7964693,  151.2846034));

        return attrList;
    }

    /**
     * Returns a list of places to eat
     *
     * @return eat list
     */
    static ArrayList<Attraction> getEatList(Context c) {
        ArrayList<Attraction> attrList = new ArrayList<>();

        // Ester Restaurant
        attrList.add(new Attraction(
                c.getString(R.string.e_name),
                (float) 4.4,
                R.drawable.ester,
                c.getString(R.string.e_desc),
                c.getString(R.string.e_phone_num),
                c.getString(R.string.e_url),
                 -33.8876065,  151.1987313));

        // Bennelong
        attrList.add(new Attraction(
                c.getString(R.string.b_name),
                (float) 4.1,
                R.drawable.bennelong,
                c.getString(R.string.b_desc),
                c.getString(R.string.b_phone_num),
                c.getString(R.string.b_url),
                 -33.8575555,  151.2124993));

        // Spice Temple
        attrList.add(new Attraction(
                c.getString(R.string.st_name),
                (float) 4.2,
                R.drawable.spice_temple,
                c.getString(R.string.st_desc),
                c.getString(R.string.st_phone_num),
                c.getString(R.string.st_url),
                 -33.8660023,  151.2080051));

        // La Disfida
        attrList.add(new Attraction(
                c.getString(R.string.ld_name),
                (float) 4.6,
                R.drawable.ladisfida,
                c.getString(R.string.ld_desc),
                c.getString(R.string.ld_phone_num),
                c.getString(R.string.ld_url),
                 -33.8812436,  151.1373781));

        return attrList;
    }

    /**
     * Returns a list of places to drink
     *
     * @return drink list
     */
    static ArrayList<Attraction> getDrinkList(Context c) {
        ArrayList<Attraction> attrList = new ArrayList<>();

        // Opera Bar
        attrList.add(new Attraction(c.getString(R.string.ob_name), (float) 4.3,
                R.drawable.opera_bar,
                c.getString(R.string.ob_desc),
                c.getString(R.string.ob_phone_num),
                c.getString(R.string.ob_url),
                 -33.8583877,  151.2117862));

        // Baxter Inn
        attrList.add(new Attraction(
                c.getString(R.string.binn_name),
                (float) 4.7,
                R.drawable.baxter,
                c.getString(R.string.binn_desc),
                c.getString(R.string.binn_phone_num),
                c.getString(R.string.binn_url),
                 -33.8697104,  151.2035421));

        // 4 Pines Brewery
        attrList.add(new Attraction(
                c.getString(R.string.pb_name),
                (float) 4.5,
                R.drawable.pines,
                c.getString(R.string.pb_desc),
                c.getString(R.string.pb_phone_num),
                c.getString(R.string.pb_url),
                 -33.7995507,  151.2832162));

        // Stitch Bar
        attrList.add(new Attraction(
                c.getString(R.string.sb_name),
                (float) 4.3,
                R.drawable.stitch,
                c.getString(R.string.sb_desc),
                c.getString(R.string.sb_phone_num),
                c.getString(R.string.sb_url),
                 -33.8674391,  151.2035477));

        return attrList;
    }

    /**
     * Returns a list of places to sleep
     *
     * @return sleep list
     */
    static ArrayList<Attraction> getSleepList(Context c) {
        ArrayList<Attraction> attrList = new ArrayList<>();

        // Park Hyatt
        attrList.add(new Attraction(
                c.getString(
                        R.string.ph_name),
                (float) 4.6,
                R.drawable.park_hyatt,
                c.getString(R.string.ph_desc),
                c.getString(R.string.ph_phone_num),
                c.getString(R.string.ph_url),
                 -33.8557542,  151.2071636));

        // Oyolo 1888
        attrList.add(new Attraction(
                c.getString(R.string.o_name),
                (float) 4.7,
                R.drawable.hotel_1888,
                c.getString(R.string.o_desc),
                c.getString(R.string.o_phone_num),
                c.getString(R.string.o_url),
                 -33.8726664,  151.1948629));

        // The old clare hotel
        attrList.add(new Attraction(
                c.getString(R.string.oc_name),
                (float) 4.2,
                R.drawable.old_clare,
                c.getString(R.string.oc_desc),
                c.getString(R.string.oc_phone_num),
                c.getString(R.string.oc_url),
                 -33.8844495,  151.1992123));

        // Rendezvous hotel
        attrList.add(new Attraction(
                c.getString(R.string.r_name),
                (float) 3.9,
                R.drawable.rendezvous_hotel,
                c.getString(R.string.r_desc),
                c.getString(R.string.r_phone_num),
                c.getString(R.string.r_url),
                 -33.8844082,  151.1838915));


        return attrList;
    }
}
