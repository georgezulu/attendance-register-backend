package za.co.rain.spring.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;

@Entity
public class Individual {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String href;

	private String aristocraticTitle;

	private OffsetDateTime birthDate;

	private String countryOfBirth;

	private OffsetDateTime deathDate;

	private String familyName;

	private String fullName;

	private String gender;

	private String baseType;

	private String schemaLocation;

	private String type;

	public Individual() {
	}

	public Individual(String href, String aristocraticTitle, OffsetDateTime birthDate, String countryOfBirth,
			OffsetDateTime deathDate, String familyName, String fullName, String gender, String baseType,
			String schemaLocation, String type) {
		if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("fullName can't be null");
        }
		
		this.href = href;
		this.aristocraticTitle = aristocraticTitle;
		this.birthDate = birthDate;
		this.countryOfBirth = countryOfBirth;
		this.deathDate = deathDate;
		this.familyName = familyName;
		this.fullName = fullName;
		this.gender = gender;
		this.baseType = baseType;
		this.schemaLocation = schemaLocation;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getAristocraticTitle() {
		return aristocraticTitle;
	}

	public void setAristocraticTitle(String aristocraticTitle) {
		this.aristocraticTitle = aristocraticTitle;
	}

	public OffsetDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(OffsetDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}

	public OffsetDateTime getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(OffsetDateTime deathDate) {
		this.deathDate = deathDate;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Individual individual = (Individual) o;
		return Objects.equals(id, individual.id) && Objects.equals(href, individual.href)
				&& Objects.equals(aristocraticTitle, individual.aristocraticTitle) && Objects.equals(birthDate, individual.birthDate)
				&& Objects.equals(countryOfBirth, individual.countryOfBirth) && Objects.equals(deathDate, individual.deathDate)
				&& Objects.equals(familyName, individual.familyName) && Objects.equals(fullName, individual.fullName)
				&& Objects.equals(gender, individual.gender) && Objects.equals(baseType, individual.baseType)
				&& Objects.equals(schemaLocation, individual.schemaLocation) && Objects.equals(type, individual.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, href, aristocraticTitle, birthDate, countryOfBirth , deathDate , familyName, fullName, gender, baseType, schemaLocation,type);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Individual{");
		sb.append("    id: ").append(id).append("\n");
	    sb.append("    href: ").append(href).append("\n");
	    sb.append("    aristocraticTitle: ").append(aristocraticTitle).append("\n");
	    sb.append("    birthDate: ").append(birthDate).append("\n");
	    sb.append("    countryOfBirth: ").append(countryOfBirth).append("\n");
	    sb.append("    deathDate: ").append(deathDate).append("\n");
	    sb.append("    familyName: ").append(familyName).append("\n");
	    sb.append("    fullName: ").append(fullName).append("\n");
	    sb.append("    gender: ").append(gender).append("\n");
	    sb.append("    baseType: ").append(baseType).append("\n");
	    sb.append("    schemaLocation: ").append(schemaLocation).append("\n");
	    sb.append("    type: ").append(type).append("\n");
	    sb.append("}");
		return sb.toString();
	}

}