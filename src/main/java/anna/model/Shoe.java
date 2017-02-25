package anna.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Shoe {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    
    @Column
    private String category;
    
    @Column
	private String color;
    
    @Column(name="shoe_size")
    @ElementCollection(fetch=FetchType.EAGER)
	private Map<String, String> size = new HashMap<>();
		
	@ElementCollection(fetch=FetchType.EAGER)
	private List<Insole> insole = new ArrayList<>() ;
	
	public Shoe() {}

	public Shoe( String category, String color) {
		this.category = category;
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setInsole(List<Insole> insole){
		this.insole = insole;
	}
	
	public List<Insole> getInsole(){
		return insole;
	}

	public long getId() {
		return id;
	}

	public void setId(long id){
		this.id = id;
		
	}
	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public Map<String, String> getSize() {
		return size;
	}


	public void  setSize(Map <String, String> size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Shoe other = (Shoe) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shoe [id=" + id + ", category=" + category + ", color=" + color + ", size=" + size + ", insole="
				+ insole + "]";
	}

		
	
	
	
}
