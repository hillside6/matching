package com.test.trade.service;

import java.math.BigDecimal;

import com.test.trade.bean.DayOrder;

public class TestMain {

	public static void main(String[] args) {
		Book.sell(new DayOrder(BigDecimal.valueOf(1.3), 11, System.currentTimeMillis()));
		Book.sell(new DayOrder(BigDecimal.valueOf(1.4), 12, System.currentTimeMillis()));
		Book.sell(new DayOrder(BigDecimal.valueOf(1.5), 13, System.currentTimeMillis()));
		Book.sell(new DayOrder(BigDecimal.valueOf(1.6), 14, System.currentTimeMillis()));
		Book.sell(new DayOrder(BigDecimal.valueOf(1.7), 15, System.currentTimeMillis()));
		Book.buy(new DayOrder(BigDecimal.valueOf(2.1), 33, System.currentTimeMillis()));
		Book.buy(new DayOrder(BigDecimal.valueOf(2.2), 21, System.currentTimeMillis()));
		Book.buy(new DayOrder(BigDecimal.valueOf(2.3), 21, System.currentTimeMillis()));
		Book.sell(new DayOrder(BigDecimal.valueOf(1.2), 10, System.currentTimeMillis()));
		Book.buy(new DayOrder(BigDecimal.valueOf(2.4), 33, System.currentTimeMillis()));
		Book.buy(new DayOrder(BigDecimal.valueOf(2.5), 1, System.currentTimeMillis()));
		Book.buy(new DayOrder(BigDecimal.valueOf(2.6), 22, System.currentTimeMillis()));
		
		System.out.println(Book.buyDayOrderList);
		System.out.println(Book.sellDayOrderList);
	}

}
