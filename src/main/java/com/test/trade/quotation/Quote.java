package com.test.trade.quotation;

import java.math.BigDecimal;

public class Quote {
	private String symbol;
	private long time;
	private BigDecimal price;
	private BigDecimal volume;
	private BigDecimal bid;
	private BigDecimal bidSize;
	private BigDecimal ask;
	private BigDecimal askSize;
	private int dataFeederId;
	private BigDecimal prevClosePrice;
	private BigDecimal openPrice;

	public Quote(String quoteStr) {
		String fields[] = quoteStr.split(",");
		symbol = fields[0];
		time = Long.parseLong(fields[1]);
		price = BigDecimal.valueOf(Double.parseDouble(fields[2]));
		volume = BigDecimal.valueOf(Double.parseDouble(fields[3]));
		bid = BigDecimal.valueOf(Double.parseDouble(fields[4]));
		bidSize = BigDecimal.valueOf(Double.parseDouble(fields[5]));
		ask = BigDecimal.valueOf(Double.parseDouble(fields[6]));
		askSize = BigDecimal.valueOf(Double.parseDouble(fields[7]));
		// 兼容老的行情 只有8个字段 没有dataFeederId字段
		if (fields.length > 8)
			dataFeederId = Integer.valueOf(fields[8]);
		if (fields.length > 10) {
			prevClosePrice = BigDecimal.valueOf(Double.parseDouble(fields[9]));
			openPrice = BigDecimal.valueOf(Double.parseDouble(fields[10]));
		}
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public BigDecimal getBidSize() {
		return bidSize;
	}

	public void setBidSize(BigDecimal bidSize) {
		this.bidSize = bidSize;
	}

	public BigDecimal getAsk() {
		return ask;
	}

	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}

	public BigDecimal getAskSize() {
		return askSize;
	}

	public void setAskSize(BigDecimal askSize) {
		this.askSize = askSize;
	}

	public int getDataFeederId() {
		return dataFeederId;
	}

	public void setDataFeederId(int dataFeederId) {
		this.dataFeederId = dataFeederId;
	}

	public BigDecimal getPrevClosePrice() {
		return prevClosePrice;
	}

	public void setPrevClosePrice(BigDecimal prevClosePrice) {
		this.prevClosePrice = prevClosePrice;
	}

	public BigDecimal getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
	}

}
