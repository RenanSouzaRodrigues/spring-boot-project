package com.renansouza.sbp.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(0),
	PAID(1),
	SHIPPED(2),
	DELIVERED(3),
	CANCELED(4);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus orderStatus : OrderStatus.values()) {
			if(orderStatus.getCode() == code) {
				return orderStatus;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus Code.");
	}
}
