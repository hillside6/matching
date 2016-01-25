package com.test.trade.quotation;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QuoteManager {
	// 分
	// private static Map<String, Bar> barMap = new ConcurrentHashMap<>();
	private static Map<String, Map<Long, Bar>> allBarMap = new ConcurrentHashMap<>();

	public static void putQuote(Quote quote) {
		long time = quote.getTime();
		time = time - (time % 60000);
		System.out.println(time);
		Map<Long, Bar> barMap = allBarMap.get(quote.getSymbol());
		if (barMap == null) {
			barMap = new ConcurrentHashMap<>();
			allBarMap.put(quote.getSymbol(), barMap);
		}
		Bar bar = barMap.get(time);
		if (bar == null) {
			bar = new Bar();
			bar.setSymbol(quote.getSymbol());
			bar.setTime(time);
			bar.setLow(quote.getPrice());
			bar.setOpenTime(quote.getTime());
			bar.setCloseTime(quote.getTime());
			bar.setHigh(quote.getPrice());
			bar.setOpen(quote.getPrice());
			bar.setClose(quote.getPrice());
			bar.setVolume(quote.getBidSize());
			barMap.put(time, bar);
		} else {
			bar.setHigh(bar.getHigh().compareTo(quote.getPrice()) > 0 ? bar.getHigh() : quote.getPrice());
			bar.setLow(bar.getLow().compareTo(quote.getPrice()) < 0 ? bar.getLow() : quote.getPrice());
			bar.setVolume(bar.getVolume().add(BigDecimal.ONE));
			if (bar.getOpenTime() > quote.getTime()) {
				bar.setOpenTime(quote.getTime());
				bar.setOpen(quote.getPrice());
			}
			if (bar.getCloseTime() < quote.getTime()) {
				bar.setCloseTime(quote.getTime());
				bar.setClose(quote.getPrice());
			}
		}
		// for (Map<Long, Bar> map : allBarMap.values()) {
		// System.out.println(JSON.toJSONString(map.values()));
		// }
	}

}
