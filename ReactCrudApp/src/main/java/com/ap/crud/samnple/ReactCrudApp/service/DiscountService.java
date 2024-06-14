package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Discount;

import java.util.List;

public interface DiscountService {

    Discount saveDiscount(Discount discount);

    List<Discount> getDiscountByRestaurant();


}
