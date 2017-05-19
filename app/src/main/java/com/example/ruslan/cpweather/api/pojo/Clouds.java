package com.example.ruslan.cpweather.api.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ruslan on 19.05.2017.
 */

public class Clouds {
    @SerializedName("all")
    @Expose
    private Integer all;

    /**
     *
     * @return
     *     The all
     */
    public Integer getAll() {
        return all;
    }

    /**
     *
     * @param all
     *     The all
     */
    public void setAll(Integer all) {
        this.all = all;
    }
}
