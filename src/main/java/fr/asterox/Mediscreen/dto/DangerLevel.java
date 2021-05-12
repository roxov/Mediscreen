package fr.asterox.Mediscreen.dto;

public enum DangerLevel {
	None("None"), Borderline("Borderline"), InDanger("InDanger"), EarlyOnset("EarlyOnset");

	private String level;

	DangerLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return this.level;
	}
}
