package cn.cc.mytest.java8.learn0402Stream;

public class Property implements Comparable<Property> {

	String name;
	// 距离，单位:米
    Integer distance;
    // 销量，月售
    Integer sales;
    // 价格，这里简单起见就写一个级别代表价格段
    Integer priceLevel;
    
    public Property(String name, int distance, int sales, int priceLevel) {
        this.name = name;
        this.distance = distance;
        this.sales = sales;
        this.priceLevel = priceLevel;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getPriceLevel() {
		return priceLevel;
	}

	public void setPriceLevel(Integer priceLevel) {
		this.priceLevel = priceLevel;
	}

	@Override
	public String toString() {
		return "Property [name=" + name + ", distance=" + distance + ", sales=" + sales + ", priceLevel=" + priceLevel
				+ "]";
	}
    
    public void sss() {
    	System.out.println(this);
    }

	@Override
	public int compareTo(Property o) {
		int d1 =  this.distance.intValue();
		int d2 = o.distance.intValue();
		if (d1 < d2) {
			return -1;
		} else  if (d1 > d2) {
			return 1;
		} else {
			return 0;
		}
	}

}
