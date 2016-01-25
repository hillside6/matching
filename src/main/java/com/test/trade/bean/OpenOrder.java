package com.test.trade.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OpenOrder {
	private int openOrderId;
	private Timestamp dateOpen;
	private int lots;
	private BigDecimal price;
	private int productId;
	private String symbol;

	public int getOpenOrderId() {
		return openOrderId;
	}

	public void setOpenOrderId(int openOrderId) {
		this.openOrderId = openOrderId;
	}

	public Timestamp getDateOpen() {
		return dateOpen;
	}

	public void setDateOpen(Timestamp dateOpen) {
		this.dateOpen = dateOpen;
	}

	public int getLots() {
		return lots;
	}

	public void setLots(int lots) {
		this.lots = lots;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
