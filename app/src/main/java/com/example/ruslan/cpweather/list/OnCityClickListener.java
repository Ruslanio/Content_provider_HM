package com.example.ruslan.cpweather.list;

import com.example.ruslan.cpweather.model.City;

/**
 * Created by Ruslan on 19.05.2017.
 */

public interface OnCityClickListener {

    void onDelete(City city);

    void onClick(City city);
}
