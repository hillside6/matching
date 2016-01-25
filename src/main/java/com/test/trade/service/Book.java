package com.test.trade.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.test.trade.bean.DayOrder;

public class Book {
	private static BigDecimal currentPrice = BigDecimal.ZERO;
	public static List<DayOrder> buyDayOrderList = new LinkedList<>();
	public static List<DayOrder> sellDayOrderList = new LinkedList<>();

	public static void buy(DayOrder dayOrder) {
		buyDayOrderList.add(dayOrder);
		Collections.sort(buyDayOrderList);
		trade();
	}

	public static void sell(DayOrder dayOrder) {
		sellDayOrderList.add(dayOrder);
		Collections.sort(sellDayOrderList);
		trade();
	}

	private static void trade() {
		// 交易
		if (buyDayOrderList.size() > 0 && sellDayOrderList.size() > 0) {
			DayOrder buyDayOrder = buyDayOrderList.get(buyDayOrderList.size() - 1);
			DayOrder sellDayOrder = sellDayOrderList.get(0);
			// 买价低于卖价
			if (buyDayOrder.getPrice().compareTo(sellDayOrder.getPrice()) < 0) {
				return;
			}
			if (buyDayOrder.getLots() > sellDayOrder.getLots()) {
				sellDayOrderList.remove(0);
				buyDayOrder.setLots(buyDayOrder.getLots() - sellDayOrder.getLots());
				currentPrice = createPrice(currentPrice, buyDayOrder.getPrice(), sellDayOrder.getPrice());
				System.out.println("当前最新价格：" + currentPrice+" "+buyDayOrder.getPrice()+" "+sellDayOrder.getPrice());
				trade();
			} else if (buyDayOrder.getLots() < sellDayOrder.getLots()) {
				buyDayOrderList.remove(buyDayOrderList.size() - 1);
				sellDayOrder.setLots(sellDayOrder.getLots() - buyDayOrder.getLots());
				currentPrice = createPrice(currentPrice, buyDayOrder.getPrice(), sellDayOrder.getPrice());
				System.out.println("当前最新价格：" + currentPrice+" "+buyDayOrder.getPrice()+" "+sellDayOrder.getPrice());
				trade();
			} else {
				sellDayOrderList.remove(0);
				buyDayOrderList.remove(buyDayOrderList.size() - 1);
				currentPrice = createPrice(currentPrice, buyDayOrder.getPrice(), sellDayOrder.getPrice());
				System.out.println("当前最新价格：" + currentPrice+" "+buyDayOrder.getPrice()+" "+sellDayOrder.getPrice());
			}
		}
		// 设置读取的队列
	}

	private static BigDecimal createPrice(BigDecimal lastPrice, BigDecimal buyPrice, BigDecimal sellPrice) {
		// 肯定存在的条件buyPrice>=sellPrice
		if (lastPrice.compareTo(sellPrice) <= 0) {
			return sellPrice;
		}
		if (lastPrice.compareTo(buyPrice) >= 0) {
			return buyPrice;
		}
		return lastPrice;
	}
}
