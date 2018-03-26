package com.dio.satriani.sadehan_gamelan.Beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by user on 3/19/2018.
 */

public class IklanList {
    @SerializedName("wisata")
    @Expose
    private ArrayList<Iklan> wisata = null;

    public ArrayList<Iklan> getWisata() {
        return wisata;
    }

    public void setWisata(ArrayList<Iklan> wisata) {
        this.wisata = wisata;
    }

}
