package ca.mcgill.ecse321.backend.model;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class Tutor extends User {
	
	private boolean fired;
	
	public boolean isFired() {
		return fired;
	}
	
	public void setfire(boolean fire) {
		fired = fire;
	}
	
	private ArrayList<String> warnings;
	
	public ArrayList<String> getWarnings() {
		return warnings;
	}

	public void addWarning(String warning) { 
		if (warnings == null) {
			warnings = new ArrayList<String>();
		}
		warnings.add(warning);
	}
	
	public int getNumWarnings() {
		return this.warnings.size();
	}
	
	private boolean suspended;
	
	private int daysLeftSuspended; 
	
	public boolean getSuspended() { 
		return suspended;
	}
	
	public void setSuspended(boolean b) {
		suspended = b;	
	}
	
	public int getDaysLeftSuspended() { 
		return daysLeftSuspended;
	}

	public void setDaysLeftSuspended(int days) { 
		this.daysLeftSuspended = days;
	}
	
	private int maxPrice;

	public void setMaxPrice(int value) {
		this.maxPrice = value;
	}
	public int getMaxPrice() {
		return this.maxPrice;
	}
	
	private int minPrice;

	public void setMinPrice(int value) {
		this.minPrice = value;
	}
	public int getMinPrice() {
		return this.minPrice;
	}
	
	// getter
	/**
	 * <pre>
	 *           0..*     1..1
	 * Tutor ------------------------- Subject
	 *           tutor        &gt;       subject
	 * </pre>
	 */
	private Subject subject;

	public void setSubject(Subject value) {
		this.subject = value;
	}

	public Subject getSubject() {
		return this.subject;
	}

	// getter
	/**
	 * <pre>
	 *           1..1     0..*
	 * Tutor ------------------------- Evaluation
	 *           tutor        &lt;       evaluation
	 * </pre>
	 */
	private Set<Evaluation> evaluation;

	public Set<Evaluation> getEvaluation() {
		if (this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		return this.evaluation;
	}
	

	private Set<Session> sessions;
	
	public Set<Session> getSession() {
		if (this.sessions == null) {
			this.sessions = new HashSet<Session>();
		}
		return this.sessions;
	}
	
	public void addEvaluation(Evaluation e) {
		this.evaluation.add(e);
	}
	
	public boolean removeEvaluation(Evaluation e) {
		return this.evaluation.remove(e);
	}

}
