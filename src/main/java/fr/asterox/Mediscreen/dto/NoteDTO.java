package fr.asterox.Mediscreen.dto;

import javax.persistence.Id;

public class NoteDTO {
	@Id
	private Long noteId;
	private Long patientId;
	private String practitionerNote;

	public NoteDTO() {
		super();
	}

	public NoteDTO(Long patientId, String practitionerNote) {
		super();
		this.patientId = patientId;
		this.practitionerNote = practitionerNote;
	}

	public Long getNoteId() {
		return noteId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPractitionerNote() {
		return practitionerNote;
	}

	public void setPractitionerNote(String practitionerNote) {
		this.practitionerNote = practitionerNote;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noteId == null) ? 0 : noteId.hashCode());
		result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
		result = prime * result + ((practitionerNote == null) ? 0 : practitionerNote.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoteDTO other = (NoteDTO) obj;
		if (noteId == null) {
			if (other.noteId != null)
				return false;
		} else if (!noteId.equals(other.noteId))
			return false;
		if (patientId == null) {
			if (other.patientId != null)
				return false;
		} else if (!patientId.equals(other.patientId))
			return false;
		if (practitionerNote == null) {
			if (other.practitionerNote != null)
				return false;
		} else if (!practitionerNote.equals(other.practitionerNote))
			return false;
		return true;
	}

}