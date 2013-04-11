package com.codetutr.domain;

public class Person {

	private String name;
	private Integer age;
	private Sex sex;
	private Frequency newsletterFrequency;
	private Boolean receiveNewsletter;
	
	public enum Frequency {
		HOURLY, DAILY, WEEKLY, MONTHLY, ANNUALLY
	}
	
	public enum Sex {
		MALE, FEMALE
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Frequency getNewsletterFrequency() {
		return newsletterFrequency;
	}

	public void setNewsletterFrequency(Frequency newsletterFrequency) {
		this.newsletterFrequency = newsletterFrequency;
	}

	public Boolean getReceiveNewsletter() {
		return receiveNewsletter;
	}

	public void setReceiveNewsletter(Boolean receiveNewsletter) {
		this.receiveNewsletter = receiveNewsletter;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex
				+ ", newsletterFrequency=" + newsletterFrequency
				+ ", receiveNewsletter=" + receiveNewsletter + "]";
	}
	
}
