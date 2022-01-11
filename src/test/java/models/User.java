package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty("name")
	private String name;

	@JsonProperty("job")
	private String job;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("job")
	public String getJob() {
		return job;
	}

	@JsonProperty("job")
	public void setJob(String job) {
		this.job = job;
	}
}
