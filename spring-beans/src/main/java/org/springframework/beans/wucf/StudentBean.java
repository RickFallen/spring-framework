package org.springframework.beans.wucf;

import java.util.HashMap;
import java.util.Map;


public class StudentBean {
    private String name;
    private String address;
    private Integer age;

    public StudentBean(){
        System.out.println("-------------------student bean----------------------");
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String dependentBeans = map.computeIfAbsent("test", k -> k + "123");
        System.out.println(dependentBeans);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
