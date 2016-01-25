package com.test.trade.bean;

import java.math.BigDecimal;

public class DayOrder implements Comparable<DayOrder> {
	private BigDecimal price;
	private int lots;
	private long createTime;

	public DayOrder() {
	}

	public DayOrder(BigDecimal price, int lots, long createTime) {
		this.price = price;
		this.lots = lots;
		this.createTime = createTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getLots() {
		return lots;
	}

	public void setLots(int lots) {
		this.lots = lots;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	@Override
	public int compareTo(DayOrder anotherDayOrder) {
		if (this.price.compareTo(anotherDayOrder.price) > 0) {
			return 1;
		} else if (this.price.compareTo(anotherDayOrder.price) < 0) {
			return -1;
		} else {
			if (this.createTime >= anotherDayOrder.createTime) {
				return 1;
			}
			return -1;
		}
	}

	@Override
	public String toString() {
		return "DayOrder [price=" + price + ", lots=" + lots + ", createTime=" + createTime + "]";
	}

}
