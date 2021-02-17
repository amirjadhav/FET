package spring.two;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//pojo --> plain old java object
public class Order {
	private int orderId;
	private List<Item> item;
	public Order() {
		super();
	}
	public Order(int orderId, List<Item> item) {
		super();
		this.orderId = orderId;
		this.item = item;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", item=" + item + "]";
	}

	@PostConstruct
	public void myinit(){
		System.out.println("properties been initialized");
	}
	@PreDestroy
	public void mydestroy(){
		System.out.println("order bean deleted...");
	}
}