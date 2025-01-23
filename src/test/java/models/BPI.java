package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BPI {
	
	@JsonProperty("USD")
	private Currency usd;
	@JsonProperty("GBP")
	private Currency gbp;
	@JsonProperty("EUR")
	private Currency eur;
	
	public BPI() {}
	
	public BPI(Currency uSD, Currency gBP, Currency eUR) {
		super();
		usd = uSD;
		gbp = gBP;
		eur = eUR;
	}

	public Currency getUSD() {
		return usd;
	}

	public void setUSD(Currency uSD) {
		usd = uSD;
	}

	public Currency getGBP() {
		return gbp;
	}

	public void setGBP(Currency gBP) {
		gbp = gBP;
	}

	public Currency getEUR() {
		return eur;
	}

	public void setEUR(Currency eUR) {
		eur = eUR;
	}

	@Override
	public String toString() {
		return "BPI [USD=" + usd + ", GBP=" + gbp + ", EUR=" + eur + "]";
	}
}
