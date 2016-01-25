package com.test.trade.quotation;

import java.math.BigDecimal;

public class Bar {
	private int barId = 0;
	private String symbol = "";
	private long time = 0;
	private long openTime = 0;
	private long closeTime = 0;
	private BigDecimal open = BigDecimal.ZERO;
	private BigDecimal close = BigDecimal.ZERO;
	private BigDecimal low = BigDecimal.ZERO;
	private BigDecimal high = BigDecimal.ZERO;
	private BigDecimal volume = BigDecimal.ZERO;

	public int getBarId() {
		return barId;
	}

	public void setBarId(int barId) {
		this.barId = barId;
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

	public BigDecimal getOpen() {
		return open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public BigDecimal getClose() {
		return close;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
	}

	public BigDecimal getLow() {
		return low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Bar [barId=" + barId + ", symbol=" + symbol + ", time=" + time + ", open=" + open + ", close=" + close + ", low=" + low + ", high=" + high + ", volume="
				+ volume + "]";
	}

	public long getOpenTime() {
		return openTime;
	}

	public void setOpenTime(long openTime) {
		this.openTime = openTime;
	}

	public long getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(long closeTime) {
		this.closeTime = closeTime;
	}

}
